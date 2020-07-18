package org.fish.commons.cron;

/**
 * @author Sumit Jha
 */
public interface Configuration {
    boolean isValid();
    int[] values();

    static final String EVERY = "*";
    static final String ANY = "?";

    default int[] parse(String expression) {
        if (EVERY.equals(expression) || ANY.equals(expression)) {
            return new int[] { };
        }
        return new int[] {};
    }
}
