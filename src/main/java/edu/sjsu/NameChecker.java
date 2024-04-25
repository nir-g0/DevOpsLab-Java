package edu.sjsu;

public class NameChecker {
    /**
     * Checks if a given string is a valid name following these rules:
     * - Between 2 to 40 characters
     * - Contains only alphabetic characters, non-consecutive hyphens, or a single
     * quote
     * - Cannot start with a hyphen or single quote
     * 
     * @param input Name to check
     * @return True if input is a valid name, else false
     */
    public static boolean check(String input) {
        if (input.length() < 2 || input.length() > 40) {
            return false;
        }

        boolean prevWasHyphen = false;
        char[] chars = input.toCharArray();
        int singleQuoteCount = 0;

        if (chars[0] == '\'' || chars[0] == '-') {
            return false;
        }

        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == '\'') {
                singleQuoteCount++;
                if (singleQuoteCount > 1) {
                    return false;
                }
            }
            if (Character.isLetter(c) || c == '\'') {
                prevWasHyphen = false;
            } else if (c == '-') {
                if (prevWasHyphen) {
                    return false;
                }
                prevWasHyphen = true;
            } else {
                return false;
            }
        }

        return true;
    }
}
