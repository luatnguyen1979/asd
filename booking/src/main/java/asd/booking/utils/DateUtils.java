package asd.booking.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static final String FORMAT_DATE = "yyyy-MM-dd";

    public static String adaptToDate(LocalDate localDate) {
        StringBuilder ret = new StringBuilder(30);
        ret.append(localDate.getYear());
        ret.append("-");
        if (localDate.getMonthValue() < 10) {
            ret.append("0");
            ret.append(localDate.getMonthValue());
        } else {
            ret.append(localDate.getMonthValue());
        }
        ret.append("-");
        if (localDate.getDayOfMonth() < 10) {
            ret.append("0");
            ret.append(localDate.getDayOfMonth());
        } else {
            ret.append(localDate.getDayOfMonth());
        }
        return ret.toString();
    }

    public static LocalDate adaptFromDate(String localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_DATE);
        return LocalDate.parse(localDate, formatter);
    }
}
