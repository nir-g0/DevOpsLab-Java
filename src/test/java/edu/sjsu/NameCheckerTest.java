package edu.sjsu;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class NameCheckerTest {

    @Test
    public void testValidName() {
        assertTrue(NameChecker.check("John"));
    }

    @Test
    public void testInvalidNameWithSpecialCharacter() {
        assertFalse(NameChecker.check("John$"));
    }

    @Test
    public void testInvalidNameWithNumbers() {
        assertFalse(NameChecker.check("John123"));
    }

    @Test
    public void testValidNameWithApostrophe() {
        assertTrue(NameChecker.check("O'Brien"));
    }

    @Test
    public void testValidNameWithHyphen() {
        assertTrue(NameChecker.check("Smith-Jones"));
    }

    @Test
    public void testInvalidNameWithTooManyCharacters() {
        assertFalse(NameChecker.check("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    public void testInvalidNameWithDoubleHyphen() {
        assertFalse(NameChecker.check("John--Doe"));
    }

    @Test
    public void testInvalidNameWithQuotes() {
        assertFalse(NameChecker.check("'John'"));
    }

    @Test
    public void testValidNameWithQuotesWithinAllowedLength() {
        assertTrue(NameChecker.check("O'Neil"));
    }

    @Test
    public void testInvalidNameWithQuotesBeyondAllowedLength() {
        assertFalse(NameChecker.check("O'Connolly'"));
    }

    @Test
    public void testInvalidNameWithSpaces() {
        assertFalse(NameChecker.check("John Smith"));
    }

    @Test
    public void testInvalidNameWithFirstCharacterHyphen() {
        assertFalse(NameChecker.check("-John"));
    }

    public void testInvalidNameWithFirstCharacterApostrophe() {
        assertFalse(NameChecker.check("'John"));
    }
}
