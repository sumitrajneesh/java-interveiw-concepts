package com.codinggyan.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDateExample {
    public static void main(String[] args) {

        // 1️⃣ Current date
        LocalDate today = LocalDate.now();
        System.out.println("Today's Date: " + today);

        // 2️⃣ Creating specific dates
        LocalDate birthday = LocalDate.of(1995, Month.MAY, 15);
        System.out.println("My Birthday: " + birthday);

        // 3️⃣ Parsing date from string
        LocalDate parsedDate = LocalDate.parse("2025-12-31");
        System.out.println("Parsed Date: " + parsedDate);

        // 4️⃣ Formatting date to string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formatted = today.format(formatter);
        System.out.println("Formatted Today: " + formatted);

        // 5️⃣ Add / Subtract days, months, years
        System.out.println("\nDate Arithmetic:");
        System.out.println("Next Week: " + today.plusWeeks(1));
        System.out.println("Next Month: " + today.plusMonths(1));
        System.out.println("Previous Year: " + today.minusYears(1));

        // 6️⃣ Get date parts
        System.out.println("\nDate Components:");
        System.out.println("Year: " + today.getYear());
        System.out.println("Month: " + today.getMonth());
        System.out.println("Day of Month: " + today.getDayOfMonth());
        System.out.println("Day of Week: " + today.getDayOfWeek());

        // 7️⃣ Compare dates
        LocalDate tomorrow = today.plusDays(1);
        System.out.println("\nComparisons:");
        System.out.println("Is today before tomorrow? " + today.isBefore(tomorrow));
        System.out.println("Is today after yesterday? " + today.isAfter(today.minusDays(1)));

        // 8️⃣ Period between two dates
        LocalDate newYear = LocalDate.of(2026, 1, 1);
        long daysUntilNewYear = ChronoUnit.DAYS.between(today, newYear);
        System.out.println("\nDays until New Year 2026: " + daysUntilNewYear);

        // 9️⃣ Check for leap year
        System.out.println("Is this year a leap year? " + today.isLeapYear());
    }
}
