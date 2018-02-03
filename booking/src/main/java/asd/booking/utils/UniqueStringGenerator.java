package asd.booking.utils;

import java.util.UUID;

public class UniqueStringGenerator {

    public static String generate(int len) {
        final int startIndex = 0;
        final String uuid = UUID.randomUUID()
                .toString()
                .replace("-", "")
                .toUpperCase()
                .substring(startIndex, len);
        return uuid;
    }
}
