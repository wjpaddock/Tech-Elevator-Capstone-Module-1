package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MoneyTests {

    @Test
    public void feed_money_$1_increments_balance_by_$1(){
        Money money = new Money();
        money.insert1(money);
        Assert.assertEquals(1.0, money.getCurrentBalance(money), 1);
    }

    @Test
    public void feed_money_$5_increments_balance_by_$5(){
        Money money = new Money();
        money.insert5(money);
        Assert.assertEquals(5.0, money.getCurrentBalance(money), 1);
    }

    @Test
    public void feed_money_$10_increments_balance_by_$10(){
        Money money = new Money();
        money.insert10(money);
        Assert.assertEquals(10.0, money.getCurrentBalance(money), 1);
    }

    @Test
    public void feed_money_$5_and_$1_makes_balance_$6() {
        Money money = new Money();
        money.insert1(money);
        money.insert5(money);
        Assert.assertEquals(6.0, money.getCurrentBalance(money), 1);
    }

    @Test
    public void feed_money_$5_and_$10_makes_balance_$15() {
        Money money = new Money();
        money.insert5(money);
        money.insert10(money);
        Assert.assertEquals(15.0, money.getCurrentBalance(money), 1);
    }

    @Test
    public void calculate_money_as_currency_$1_as_coins(){
        Money money = new Money();
        money.insert1(money);
        money.calculateMoneyAsCurrency(money);
        Assert.assertEquals(4, money.getQuarters(money));

    }
    // balance of $1 = 4 quarters

    @Test
    public void calculate_money_as_currency_$10_as_coins(){
        Money money = new Money();
        money.insert10(money);
        money.calculateMoneyAsCurrency(money);
        Assert.assertEquals(40, money.getQuarters(money));
    }

    @Test
    public void calculate_money_as_currency_20_cents_as_coins(){
        Money money = new Money();
        money.currentBalance = 0.20;
        money.calculateMoneyAsCurrency(money);
        Assert.assertEquals(2, (money.getDimes(money)));

    }

    @Test
    public void calculate_money_as_currency_$1_85_cents_as_coins(){
        Money money = new Money();
        money.currentBalance = 1.85;
        money.calculateMoneyAsCurrency(money);
        Assert.assertEquals(7, money.getQuarters(money));
        Assert.assertEquals(1, money.getDimes(money));
    }
}
