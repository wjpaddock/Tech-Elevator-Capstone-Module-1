package com.techelevator;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.math.RoundingMode;




public class Money {
    private int quarters = 0;
    private int dimes = 0;
    private int nickels = 0;
    private double moneyAsCurrency;
    public double currentBalance = 0.0;
    public double billSelectionAsDouble = 0.0;


    public double insert1(Money money) {
        money.currentBalance++;
        money.billSelectionAsDouble = 1.0;
        return money.currentBalance;
    }

    public double insert5(Money money) {
        money.currentBalance += 5;
        money.billSelectionAsDouble = 5.0;
        return money.currentBalance;
    }

    public double insert10(Money money) {
        money.currentBalance += 10;
        money.billSelectionAsDouble = 10.0;
        return money.currentBalance;
    }

    public int getQuarters(Money money) {
        return money.quarters;
    }

    public int getDimes(Money money) {
        return money.dimes;
    }

    public int getNickels(Money money) {
        return money.nickels;
    }

    public double getMoneyAsCurrency() {
        return moneyAsCurrency;
    }

    public double getCurrentBalance(Money money) {
        return money.currentBalance;
    }

    public Map<String, Integer> getChangeMap() {
        return changeMap;
    }



    Map <String, Integer> changeMap = new HashMap<>();

    Map <String, Integer> calculateMoneyAsCurrency(Money money) {
        money.moneyAsCurrency = money.currentBalance;
        while (money.moneyAsCurrency >= 0.25) {
            money.moneyAsCurrency -= 0.25;
            money.quarters++;
        }
        money.changeMap.put("Quarters: ", money.quarters);
        while (money.moneyAsCurrency >= 0.10) {
            money.moneyAsCurrency -= 0.10;
            money.dimes++;
        }
        money.changeMap.put("Dimes: ", money.dimes);
        while (money.moneyAsCurrency >= 0.05) {
            money.moneyAsCurrency -= 0.05;
            money.nickels++;
        }
        money.changeMap.put("Nickels: ", money.nickels);
        return money.changeMap;
    }

    Map <String, Integer> giveChange(Money money) {
        money.moneyAsCurrency = money.currentBalance;
        while (money.moneyAsCurrency >= 0.25) {
            money.moneyAsCurrency -= 0.25;
            money.quarters--;
        }
        money.changeMap.put("Quarters: ", money.quarters);
        while (money.moneyAsCurrency >= 0.10) {
            money.moneyAsCurrency -= 0.10;
            money.dimes--;
        }
        money.changeMap.put("Dimes: ", money.dimes);
        while (money.moneyAsCurrency >= 0.05) {
            money.moneyAsCurrency -= 0.05;
            money.nickels--;
        }
        money.changeMap.put("Nickels: ", nickels);
        money.currentBalance = 0.0;
        return money.changeMap;
    }

}
