package edu.kit.informatik.exceptions;

/**
 * Created by Christian on 17.01.2017.
 */
public class SemanticsException extends Exception {
    /**
     * Standard error message prefix.
     */
    protected static final String DEFAULT_PREFIX = "Error, ";

    /**
     * Standard error message.
     */
    protected static final String DEFAULT_MESSAGE = "semantics exception.";

    /**
     * Constructs a new edu.kit.informatik.SemanticsException with a default message.
     */
    public SemanticsException() {
        super(DEFAULT_PREFIX + DEFAULT_MESSAGE);
    }

    /**
     * Constructs a new edu.kit.informatik.SemanticsException with the given message.
     *
     * @param message The message.
     */
    public SemanticsException(String message) {
        super(DEFAULT_PREFIX + message);
    }
}
