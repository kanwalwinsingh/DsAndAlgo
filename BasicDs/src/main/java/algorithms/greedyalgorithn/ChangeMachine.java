package main.java.algorithms.greedyalgorithn;

import java.util.ArrayList;

public class ChangeMachine {
    public static int[] coins = {25, 10, 5, 1};

    // function to recieve change in the form of coins
    public static ArrayList<Integer> getMinCoins(int amount) {
        // an array list to store all the coins
        ArrayList<Integer> change = new ArrayList<>();
        for (int i = 0; i < coins.length && amount > 0; i++) {
            while (amount >= coins[i]) {// keep checking if the amount is greater than the max coins
                amount -= coins[i]; // subtract the max coin selected from the total amount in every iteration
                change.add(coins[i]); // add the coin to list of change

            }
        }
        return change;
    }

    public static void main(String args[])
    {
        // Play around with this amount to see how many coins you get!
        int amount = 1;
        System.out.println(amount + " --> " + getMinCoins(amount));

        amount = 17;
        System.out.println(amount + " --> " + getMinCoins(amount));

        amount = 33;
        System.out.println(amount + " --> " + getMinCoins(amount));

        amount = 99;
        System.out.println(amount + " --> " + getMinCoins(amount));
    }
}
