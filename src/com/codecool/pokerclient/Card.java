package com.codecool.pokerclient;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Card {

    private String cardCode;
    private Integer cardValue;
    private List<String> correctColorList = Arrays.asList("S", "C", "D", "H");

    public Card(String cardCode) throws IllegalArgumentException {
        this.cardCode = cardCode.toUpperCase();

        String cardColor = this.cardCode.substring(0, 1);

        if (!correctColorList.contains(cardColor)) {
            throw new IllegalArgumentException("card color isn't valid: " + cardColor);
        }

        String cardValue = this.cardCode.substring(1);
        Integer intCardValue;

        HashMap<String, Integer> alphabeticCardValue = new HashMap<>();
        alphabeticCardValue.put("J", 11);
        alphabeticCardValue.put("Q", 12);
        alphabeticCardValue.put("K", 13);
        alphabeticCardValue.put("A", 14);

        if (alphabeticCardValue.get(cardValue) == null) {
            // raises exception if cardValue is a letter, but not J/Q/K/A
            intCardValue = Integer.parseInt(cardValue);
            if (intCardValue > 10 || intCardValue < 2) {
                throw new IllegalArgumentException("card number isn't valid: " + intCardValue);
            }
        } else {
            intCardValue = alphabeticCardValue.get(cardValue);
        }

        this.cardValue = intCardValue;
    }

    public int getValue() {
        return this.cardValue;
    }
}
