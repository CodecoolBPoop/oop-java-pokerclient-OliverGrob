package com.codecool.pokerclient;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokerClientTest {

    private static PokerClient pokerClient = null;

    @BeforeAll
    public static void createPokerClient() {
        pokerClient = new PokerClient("s2", "s3", "s4", "s5", "s6");
    }

    @Test
    public void isHighestCardIsMineThrowsExceptionOnNullInput() {
        assertThrows(NullPointerException.class, () -> pokerClient.highestCardIsMine(null, "s2", "s3", "s10", "s5"));
    }

    @Test
    public void isHighestCardIsMineThrowsExceptionOnEmptyStringInput() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> pokerClient.highestCardIsMine("", "s2", "s3", "s10", "s5"));
    }

    @Test
    public void isHighestCardIsMineWrongParameter() {
        assertThrows(IllegalArgumentException.class, () -> pokerClient.highestCardIsMine("s2", "s2", "sqqqqq", "s2", "s2"));
    }

    @Test
    public void isHighestCardIsMineWrongInputColor() {
        assertThrows(IllegalArgumentException.class, () -> pokerClient.highestCardIsMine("s2", "s2", "z6", "s2", "s2"));
    }

    @Test
    public void isHighestCardIsMineWrongInputNumber() {
        assertThrows(IllegalArgumentException.class, () -> pokerClient.highestCardIsMine("s2", "s2", "s20", "s2", "s2"));
    }

    @Test
    public void isHighestCardReturnValueCorrectComputerWon() {
        assertFalse(pokerClient.highestCardIsMine("s2", "s2", "sk", "s2", "s2"));
    }

    @Test
    public void isHighestCardReturnValueCorrectPlayerWon() {
        assertTrue(pokerClient.highestCardIsMine("s2", "s2", "s2", "s2", "s2"));
    }

    @Test
    public void isHighestCardReturnValueCorrectMatchingCards() {
        assertFalse(pokerClient.highestCardIsMine("s2", "s3", "s4", "s5", "s6"));
    }

}