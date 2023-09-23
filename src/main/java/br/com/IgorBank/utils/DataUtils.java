package br.com.IgorBank.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataUtils {

    private static final DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
    private static final DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String formatterDateTime(LocalDateTime date){
        return date.format(formatterDateTime);
    }

    public static LocalDate fromStringToLocalDate(String date){
        return LocalDate.parse(date, formatterDate);
    }

}
