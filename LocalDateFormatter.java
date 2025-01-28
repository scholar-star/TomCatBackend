package org.zerock.springex.controller.formatter;

import org.springframework.format.Formatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class LocalDateFormatter implements Formatter<LocalDate> {
    @Override
    public LocalDate parse(String text, Locale locale) { // formatter
        return LocalDate.parse(text, DateTimeFormatter.ofPattern(("yyyy-MM-dd")));
        // text(yyyy-MM-dd) -> LocalDate로 변환
        // static
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(object);
        // LocalDate를 yyyy-MM-dd에 맞춰 format
    }
}
