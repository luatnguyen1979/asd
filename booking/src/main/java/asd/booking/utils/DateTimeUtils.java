package asd.booking.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    private static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";

    public static String adaptToDateTime(LocalDateTime localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_DATETIME);
        return localDate.format(formatter);
    }

    public static LocalDateTime adaptFromDateTime(String localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_DATETIME);
        return LocalDateTime.parse(localDate, formatter);
    }
}
