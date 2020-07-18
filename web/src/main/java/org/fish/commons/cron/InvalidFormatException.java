package org.fish.commons.cron;

/**
 * @author Sumit Jha
 */
public class InvalidFormatException extends Exception {
    public InvalidFormatException() {
        super();
    }

    public InvalidFormatException(String message) {
        super(message);
    }

    public InvalidFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidFormatException(Throwable cause) {
        super(cause);
    }
}
