package com.techelevator;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
    Map<String, Double> vendingPriceMap = new HashMap<>();
    Map<String, Integer> vendingItemQtyMap = new HashMap<>();
    Map<String, String> vendingTypeMap = new HashMap<>();
    Map<String, String> vendingNameMap = new HashMap<>();

    public VendingMachine() {
        Map<String, Double> vendingPriceMap = this.vendingPriceMap;
        Map<String, Integer> vendingItemQtyMap = this.vendingItemQtyMap;
        Map<String, String> vendingTypeMap = this.vendingTypeMap;
        Map<String, String> vendingNameMap = this.vendingNameMap;
    }

    public Map<String, Double> vendingMapBuilder(VendingMachine vendingMachine) {
        File vendingMachineList = new File("vendingmachine.csv");
        try (Scanner itemsListScanner = new Scanner(vendingMachineList)) {
            while (itemsListScanner.hasNextLine()) {
                String itemsListLine = itemsListScanner.nextLine();
                String[] itemDelimiter = itemsListLine.split("\\|");
                String id = itemDelimiter[0];
                String name = itemDelimiter[1];
                Double price = Double.parseDouble(itemDelimiter[2]);
                String type = itemDelimiter[3];
                int qty = 5;
                vendingPriceMap.put(id, price);
                vendingItemQtyMap.put(id, qty);
                vendingTypeMap.put(id, type);
                vendingNameMap.put(id, name);
            }
        } catch (Exception e) {
            System.exit(0);
        }
        return vendingPriceMap;
    }




}


