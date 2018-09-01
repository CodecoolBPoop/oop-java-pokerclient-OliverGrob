package com.codecool.pokerclient;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    public void isCardConstructorThrowsExceptionOnNullInput() {
        assertThrows(NullPointerException.class, () -> new Card(null));
    }

    @Test
    public void isCardConstructorThrowsExceptionOnEmptyStringInput() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> new Card(""));
    }

    @Test
    public void isCardConstructorThrowsExceptionOnWrongCardColor() {
        assertThrows(IllegalArgumentException.class, () -> new Card("r5"));
    }

    @Test
    public void isCardConstructorThrowsExceptionOnTooHighCardNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Card("s11"));
    }

    @Test
    public void isCardConstructorThrowsExceptionOnTooLowCardNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Card("s1"));
    }

    @Test
    public void isCardCorrectCardValue() {
        assertEquals(5, new Card("s5").getValue());
    }

    @Test
    public void isCardIncorrectCardValue() {
        assertNotEquals(11, new Card("sq").getValue());
    }

}