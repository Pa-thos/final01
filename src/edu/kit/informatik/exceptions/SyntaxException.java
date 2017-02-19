package edu.kit.informatik.exceptions;

/**
 * Created by Christian on 17.01.2017.
 */
public class SyntaxException extends Exception {
    /**
     * Standard error message prefix.
     */
    protected static final String DEFAULT_PREFIX = "Error, ";

    /**
     * Standard error message.
     */
    protected static final String DEFAULT_MESSAGE = "syntax exception.";

    /**
     * Constructs a new edu.kit.informatik.SyntaxException with a default message.
     */
    public SyntaxException() {
        super(DEFAULT_PREFIX + DEFAULT_MESSAGE);
    }

    /**
     * Constructs a new edu.kit.informatik.SyntaxException with the given message.
     *
     * @param message The message.
     */
    public SyntaxException(String message) {
        super(DEFAULT_PREFIX + message);
    }
}
