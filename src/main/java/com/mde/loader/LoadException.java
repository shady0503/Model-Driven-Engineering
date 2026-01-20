package com.mde.loader;

/**
 * Exception thrown when YAML model loading fails
 */
public class LoadException extends Exception {

    /**
     * Creates exception with message
     */
    public LoadException(String message) {
        super(message);
    }

    /**
     * Creates exception with message and cause
     */
    public LoadException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates exception with cause
     */
    public LoadException(Throwable cause) {
        super(cause);
    }
}
