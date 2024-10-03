package com.Administration.Pro.Administration.Pro.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatterUtils {
    public static final String DATE_FORMATTER = "dd-MM-yyyy HH:mm";
    public static String formatDateTime (LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        String formatDateTime = localDateTime.format(formatter);
        return formatDateTime;
    }
}
