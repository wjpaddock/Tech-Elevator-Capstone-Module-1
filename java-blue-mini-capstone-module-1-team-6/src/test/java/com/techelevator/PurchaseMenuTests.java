package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class PurchaseMenuTests {

    @Test
    public void select_product_purchase_cowtales_decrements_quantity_by_1(){
        PurchaseMenu purchaseMenu = new PurchaseMenu();
        VendingMachine vendingMachine = new VendingMachine();
        Money money = new Money();
        Chip chip = new Chip();
        Gum gum = new Gum();
        Drink drink = new Drink();
        Candy candy = new Candy();
        vendingMachine.vendingMapBuilder(vendingMachine);
        money.insert5(money);
        purchaseMenu.itemSelection = "B2";
        purchaseMenu.selectProduct(vendingMachine, money, candy, drink, gum, chip);
        int itemQuantity = vendingMachine.vendingItemQtyMap.get(purchaseMenu.itemSelection);
        Assert.assertEquals(4, itemQuantity);


    }

    @Test
    public void select_product_purchase_mountain_melter_decrements_quantity_by_1(){
        PurchaseMenu purchaseMenu = new PurchaseMenu();
        VendingMachine vendingMachine = new VendingMachine();
        Money money = new Money();
        Chip chip = new Chip();
        Gum gum = new Gum();
        Drink drink = new Drink();
        Candy candy = new Candy();
        vendingMachine.vendingMapBuilder(vendingMachine);
        money.insert5(money);
        purchaseMenu.itemSelection = "C3";
        purchaseMenu.selectProduct(vendingMachine, money, candy, drink, gum, chip);
        int itemQuantity = vendingMachine.vendingItemQtyMap.get(purchaseMenu.itemSelection);
        Assert.assertEquals(4, itemQuantity);

    }

    @Test
    public void select_product_purchase_cowtales_decrements_balance_by_$1_50_cents(){
        PurchaseMenu purchaseMenu = new PurchaseMenu();
        VendingMachine vendingMachine = new VendingMachine();
        Money money = new Money();
        Chip chip = new Chip();
        Gum gum = new Gum();
        Drink drink = new Drink();
        Candy candy = new Candy();
        vendingMachine.vendingMapBuilder(vendingMachine);
        money.insert5(money);
        purchaseMenu.itemSelection = "B2";
        purchaseMenu.selectProduct(vendingMachine, money, candy, drink, gum, chip);
        Assert.assertEquals(3.5, money.getCurrentBalance(money), 1);

    }

    @Test
    public void select_product_purchase_mountain_melter_decrements_balance_by_$1_50_cents(){
        PurchaseMenu purchaseMenu = new PurchaseMenu();
        VendingMachine vendingMachine = new VendingMachine();
        Money money = new Money();
        Chip chip = new Chip();
        Gum gum = new Gum();
        Drink drink = new Drink();
        Candy candy = new Candy();
        vendingMachine.vendingMapBuilder(vendingMachine);
        money.insert5(money);
        purchaseMenu.itemSelection = "C1";
        purchaseMenu.selectProduct(vendingMachine, money, candy, drink, gum, chip);
        Assert.assertEquals(3.75, money.getCurrentBalance(money), 2);

    }

    @Test
    public void select_product_insufficient_funds_purchase_mountain_melter_with_balance_of_$1_returns_false(){
        PurchaseMenu purchaseMenu = new PurchaseMenu();
        VendingMachine vendingMachine = new VendingMachine();
        Money money = new Money();
        Chip chip = new Chip();
        Gum gum = new Gum();
        Drink drink = new Drink();
        Candy candy = new Candy();
        vendingMachine.vendingMapBuilder(vendingMachine);
        money.insert1(money);
        purchaseMenu.itemSelection = "C3";
        Assert.assertFalse(purchaseMenu.selectProduct(vendingMachine, money, candy, drink, gum, chip));

    }

    @Test
    public void select_product_mountain_melter_sold_out_returns_false(){
        PurchaseMenu purchaseMenu = new PurchaseMenu();
        VendingMachine vendingMachine = new VendingMachine();
        Money money = new Money();
        Chip chip = new Chip();
        Gum gum = new Gum();
        Drink drink = new Drink();
        Candy candy = new Candy();
        vendingMachine.vendingMapBuilder(vendingMachine);
        money.insert5(money);
        vendingMachine.vendingItemQtyMap.put("C3", 0);
        purchaseMenu.itemSelection = "C3";
        Assert.assertFalse(purchaseMenu.selectProduct(vendingMachine, money, candy, drink, gum, chip));

    }
}
