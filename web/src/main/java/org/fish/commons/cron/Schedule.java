package org.fish.commons.cron;

/**
 * @author Sumit Jha
 */
public final class Schedule {
    private String expression;

    private String seconds;
    private String minutes;
    private String hours;
    private String monthDay;
    private String month;
    private String weekDay;
    private String years;

    public static Schedule from(String expression) throws InvalidFormatException {
        return new Schedule();
    }
}
