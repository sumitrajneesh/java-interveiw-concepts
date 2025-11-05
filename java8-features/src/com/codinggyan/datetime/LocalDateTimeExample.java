package com.codinggyan.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeExample {
    public static void main(String[] args) {

        // 1️⃣ Current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + currentDateTime);

        // 2️⃣ Specific date and time
        LocalDateTime specificDateTime = LocalDateTime.of(2025, 11, 5, 10, 30, 45);
        System.out.println("Specific Date and Time: " + specificDateTime);

        // 3️⃣ Add or subtract time
        LocalDateTime futureDateTime = currentDateTime.plusDays(5).plusHours(2);
        LocalDateTime pastDateTime = currentDateTime.minusWeeks(1);
        System.out.println("Future Date and Time (+5 days +2 hours): " + futureDateTime);
        System.out.println("Past Date and Time (-1 week): " + pastDateTime);

        // 4️⃣ Format LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Formatted DateTime: " + formattedDateTime);

        // 5️⃣ Extract parts (year, month, day, hour, minute)
        System.out.println("Year: " + currentDateTime.getYear());
        System.out.println("Month: " + currentDateTime.getMonth());
        System.out.println("Day: " + currentDateTime.getDayOfMonth());
        System.out.println("Hour: " + currentDateTime.getHour());
        System.out.println("Minute: " + currentDateTime.getMinute());

        // 6️⃣ Compare two LocalDateTime values
        if (currentDateTime.isBefore(futureDateTime)) {
            System.out.println("Current time is before the future time.");
        } else {
            System.out.println("Current time is after or equal to the future time.");
        }
    }
}
