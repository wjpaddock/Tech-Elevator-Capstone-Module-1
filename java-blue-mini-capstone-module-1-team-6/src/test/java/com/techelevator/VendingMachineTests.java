package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class VendingMachineTests {

    @Test
    public void vending_map_builder_map_contains_ID_D4(){
        
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.vendingMapBuilder(vendingMachine);
        Assert.assertTrue(vendingMachine.vendingNameMap.containsKey("D4"));

    }

    @Test
    public void vending_map_builder_D4_price_equals_75_cents(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.vendingMapBuilder(vendingMachine);
        double tripleMintPrice = vendingMachine.vendingPriceMap.get("D4");
        Assert.assertEquals(0.75, tripleMintPrice, 2);

    }

    @Test
    public void vending_map_builder_C3_has_a_starting_quantity_of_5(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.vendingMapBuilder(vendingMachine);
        int startingQty = vendingMachine.vendingItemQtyMap.get("C3");
        Assert.assertEquals(5, startingQty);

    }

    @Test
    public void vending_map_builder_B1_is_Moonpie(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.vendingMapBuilder(vendingMachine);
        String b1Name = vendingMachine.vendingNameMap.get("B1");
        Assert.assertEquals("Moonpie", b1Name);

    }

    @Test
    public void vending_map_builder_A2_is_a_chip(){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.vendingMapBuilder(vendingMachine);
        String a2Type = vendingMachine.vendingTypeMap.get("A2");
        Assert.assertEquals("Chip", a2Type);

    }
}
