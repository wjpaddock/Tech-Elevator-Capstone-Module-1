package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class MainMenu {

    public MainMenu() {
    }

    public void welcomeMessage() {
        System.out.println("Welcome to the Wooben Vending Machine!");
        System.out.println("Please select an option below:");
        System.out.println();
    }

    public void mainMenu(Money money) {
        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
    }

    public void buildItemsList(VendingMachine vendingMachine) {
        File vendingMachineList = new File("vendingmachine.csv");
        try (Scanner itemsListScanner = new Scanner(vendingMachineList)) {
            while (itemsListScanner.hasNextLine()) {
                String itemLine = itemsListScanner.nextLine();
                String[] itemLineArray = itemLine.split("\\|");
                String id = itemLineArray[0];
                int itemQty = vendingMachine.vendingItemQtyMap.get(id);
                if (itemQty > 0) {
                    System.out.println(itemLine + "|" + itemQty);
                } else {
                    System.out.println(itemLine + "|SOLD OUT");
                }
            }
        } catch (Exception e) {
            System.exit(0);
        }

        }
}
