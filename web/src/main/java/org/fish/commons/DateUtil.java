package org.fish.commons;

import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * @author Sumit Jha
 */
public final class DateUtil {
    public static LocalDateTime localDateTimeOf(Calendar cal) {
        return LocalDateTime.ofInstant(cal.toInstant(), cal.getTimeZone().toZoneId());
    }
}
