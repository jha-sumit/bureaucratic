package org.fish.commons.cron;

/**
 * @author Sumit Jha
 */
public final class Expression {

//    private final String seconds;
//    private final String minutes;
//    private final String hours;
//    private final String monthDay;
//    private final String month;
//    private final String weekDay;
//    private final String years;



    public static final byte SECONDS = 0x00;
    public static final byte MINUTES = 0x01;
    public static final byte HOURS = 0x02;
    public static final byte DAY_OF_MONTH = 0x03;
    public static final byte MONTH = 0x04;
    public static final byte DAY_OF_WEEK = 0x05;
    public static final byte YEARS = 0x06;

    public Expression(
            String seconds, String minutes, String hours,
            String monthDay, String month, String weekDay, String years) {
//        this.seconds = isValid(seconds, SECONDS) ? seconds : EVERY;
//        this.minutes = isValid(minutes, MINUTES) ? minutes : EVERY;
//        this.hours = isValid(hours, HOURS) ? hours : EVERY;
//        this.monthDay = isValid(monthDay, DAY_OF_MONTH) ? monthDay : ANY;
//        this.month = isValid(month, MONTH) ? month : EVERY;
//        this.weekDay = isValid(weekDay, DAY_OF_WEEK) ? weekDay : ANY;
//        this.years = isValid(years, YEARS) ? years : EVERY;
    }

    public static boolean isValid(String exp, byte type) {
        return exp != null;
    }

    public static Expression parse(String expression) throws InvalidFormatException {
        if (expression == null)
            throw new InvalidFormatException("Expression can't be NULL.");

        String[] exp = expression.trim().split("\\s+");
        String[] exp1 = new String[7];
        int l = Math.min(exp.length, exp1.length);
        for (int i = 0; i < l; i++) exp1[i] = exp[i];
        return new Expression(
                exp1[SECONDS], exp1[MINUTES], exp1[HOURS],
                exp1[DAY_OF_MONTH], exp1[MONTH], exp1[DAY_OF_WEEK], exp1[YEARS]);
    }


    public Schedule toSchedule() {
        return null;
    }
}
