package edu.kit.informatik.program_logic;

import edu.kit.informatik.exceptions.SyntaxException;

/**
 * Helper methods designed to reduce code duplicates and class size.
 *
 * Created by Christian on 11.02.2017.
 */
final class HelperMethods {

    /**
     * Private constructor to prevent instantiation.
     */
    private HelperMethods() {
    }

    /**
     * Checks if a String contains only letters as characters.
     * @param string The String to be checked.
     * @return True if the String contains only letters as characters.
     */
    static boolean isFromAlphabet(String string) {
        Boolean isFromAlphabet = true;
        for (char c : string.toCharArray()) {
            if (!Character.isLetter(c)) {
                isFromAlphabet = false;
            }
        }
        return isFromAlphabet;
    }

    /**
     * Checks if the given String contains only digits.
     * @param parameter The String to be checked.
     * @return true if the String contains only digit characters.
     */
    static boolean isDigit(String parameter) {
        boolean isDigit = true;
        for (char c: parameter.toCharArray()) {
            if (Character.digit(c, 10) < 0) {
                isDigit = false;
            }
        }
        return isDigit;
    }

    /**
     * Checks if a String array has the right number of fields.
     * @param s The String array to be checked.
     * @param i The number of fields expected.
     * @param errorMessage The error message of the SyntaxException which is thrown in case of failure.
     * @throws SyntaxException throws if the expected number of fields isn't found.
     */
    static void checkArrayLength(String[] s, int i, String errorMessage) throws SyntaxException {
        if (s.length != i) {
            throw new SyntaxException(errorMessage);
        }
    }

    /**
     * Prints "Ok" to the console to indicate a successful command.
     */
    static void confirmSuccess() {
        Terminal.printLine("Ok");
    }
}
