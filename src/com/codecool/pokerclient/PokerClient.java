package com.codecool.pokerclient;

import java.util.Arrays;
import java.util.List;

public class PokerClient {

    private List<Card> cards;

    public PokerClient(String card1, String card2, String card3, String card4, String card5) {
        this.cards = Arrays.asList(new Card(card1),
                                   new Card(card2),
                                   new Card(card3),
                                   new Card(card4),
                                   new Card(card5));
    }

    public boolean highestCardIsMine(String card1, String card2, String card3, String card4, String card5) {
        Card highestCard = cards.get(0);
        List<Card> playerCards = Arrays.asList(new Card(card1),
                                               new Card(card2),
                                               new Card(card3),
                                               new Card(card4),
                                               new Card(card5));
        List<Card> computerCards = this.cards;

        for (Card currentComputerCard : computerCards) {
            for (Card currentPlayerCard : playerCards) {
                if (currentPlayerCard.getValue() > currentComputerCard.getValue()) {
                    highestCard = currentPlayerCard.getValue() > highestCard.getValue() ? currentPlayerCard : highestCard;
                } else {
                    highestCard = currentComputerCard.getValue() > highestCard.getValue() ? currentComputerCard : highestCard;
                }
            }
        }

        return computerCards.contains(highestCard);
    }

}