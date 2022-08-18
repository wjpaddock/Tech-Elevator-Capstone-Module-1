package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class InputOutput {

    VendingMachine vendingMachine = new VendingMachine();
    Money money = new Money();
    MainMenu mainMenu = new MainMenu();
    PurchaseMenu purchaseMenu = new PurchaseMenu();
    Chip chip = new Chip();
    Drink drink = new Drink();
    Gum gum = new Gum();
    Candy candy = new Candy();
    File log = new File("log.txt");
    DecimalFormat df = new DecimalFormat("0.00");
    String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm:ss a"));


    public void inputOutput() {
        vendingMachine.vendingMapBuilder(vendingMachine);
        Scanner userInput = new Scanner(System.in);
        mainMenu.welcomeMessage();
        mainMenu.mainMenu(money);
            String mainMenuSelection = userInput.nextLine();
            while (!mainMenuSelection.equals("3")) {
                if (!mainMenuSelection.equals("1") && !mainMenuSelection.equals("2")) {
                    System.out.println("Please enter a valid numerical selection!");
                    System.out.println();
                    mainMenu.mainMenu(money);
                    mainMenuSelection = userInput.nextLine();
                }
                if (mainMenuSelection.equals("1")) {
                    mainMenu.buildItemsList(vendingMachine);
                    System.out.println();
                    mainMenu.mainMenu(money);
                    mainMenuSelection = userInput.nextLine();
                }
                if (mainMenuSelection.equals("2")) {
                    purchaseMenu.purchaseMenu(money);
                    String purchaseMenuSelection = userInput.nextLine();
                    while (!purchaseMenuSelection.equals("3")) {
                        if (!purchaseMenuSelection.equals("1") && !purchaseMenuSelection.equals("2")) {
                            System.out.println("Please enter a valid numerical selection!");
                            System.out.println();
                            purchaseMenu.purchaseMenu(money);
                            purchaseMenuSelection = userInput.nextLine();
                        }
                        if (purchaseMenuSelection.equals("1")) {
                            purchaseMenu.feedMoneyMessage();
                            purchaseMenu.billSelection = userInput.nextLine();
                            if (!purchaseMenu.billSelection.equals("1") && !purchaseMenu.billSelection.equals("5") && !purchaseMenu.billSelection.equals("10")) {
                                System.out.println("Please enter a $1, $5, or $10 bill!");
                            }
                            purchaseMenu.feedMoney(money);
                            try (PrintWriter logWriter = new PrintWriter(new FileWriter(log, true))) {
                                logWriter.println(dateTime + " FEED MONEY: $" + df.format(money.billSelectionAsDouble) + " $" + df.format(money.currentBalance));
                                logWriter.flush();
                            } catch (Exception e) {
                                System.exit(3);
                            }
                            purchaseMenu.purchaseMenu(money);
                            purchaseMenuSelection = userInput.nextLine();
                        }
                        if (purchaseMenuSelection.equals("2")) {
                            mainMenu.buildItemsList(vendingMachine);
                            System.out.println("Please enter item ID (e.g. A1): ");
                            purchaseMenu.itemSelection = userInput.nextLine();
                            while (!vendingMachine.vendingPriceMap.containsKey(purchaseMenu.itemSelection)) {
                                mainMenu.buildItemsList(vendingMachine);
                                System.out.println();
                                System.out.println("Invalid item ID!  Please enter a valid item ID (e.g. A1)!");
                                purchaseMenu.itemSelection = userInput.nextLine();
                            }
                            purchaseMenu.selectProduct(vendingMachine, money, candy, drink, gum, chip);
                            try (PrintWriter logWriter = new PrintWriter(new FileWriter(log, true))) {
                                logWriter.println(dateTime + " " + vendingMachine.vendingNameMap.get(purchaseMenu.itemSelection) + " " + purchaseMenu.itemSelection + " $" + df.format(vendingMachine.vendingPriceMap.get(purchaseMenu.itemSelection)) + " $" + df.format(money.currentBalance));
                                logWriter.flush();
                            } catch (Exception e) {
                                System.exit(3);
                            }
                            purchaseMenu.purchaseMenu(money);
                            purchaseMenuSelection = userInput.nextLine();
                        }
                    }
                    if (purchaseMenuSelection.equals("3")) {
                        money.calculateMoneyAsCurrency(money);
                        try (PrintWriter logWriter = new PrintWriter(new FileWriter(log, true))) {
                            logWriter.println(dateTime + " GIVE CHANGE: $" + df.format(money.currentBalance) + " $0.00");
                            logWriter.flush();
                        } catch (Exception e) {
                            System.exit(3);
                        }
                        System.out.print("Your change is: $" + df.format(money.currentBalance));
                        if (money.getQuarters(money) > 0) {
                            System.out.print(" (" + money.getQuarters(money) + " quarters");
                            if (money.getDimes(money) > 0) {
                                System.out.print(", " + money.getDimes(money) + " dimes");
                                if (money.getNickels(money) > 0) {
                                    System.out.print(", " + money.getNickels(money) + " nickel");
                                }
                            }
                            System.out.print(")");
                        } else if (money.getDimes(money) > 0) {
                            System.out.print(" (" + money.getDimes(money) + " dimes");
                            if (money.getNickels(money) > 0) {
                                System.out.print(", " + money.getNickels(money) + " nickel");
                            }
                            System.out.print(")");
                        } else if (money.getNickels(money) > 0) {
                            System.out.println("(" + money.getNickels(money) + " nickel)");
                        }
                        money.giveChange(money);
                        System.out.println();
                        System.out.println("Returning to Main Menu!");
                        System.out.println();
                        mainMenu.mainMenu(money);
                        mainMenuSelection = userInput.nextLine();

                    }
                }
            }
            if (mainMenuSelection.equals("3")) {
                System.out.println("Thank you for using Wooben Vending International LLC (a subsidiary of Tech Elevator (!NO RIGHTS RESERVED))");
                System.exit(3);
            }
        }
}




