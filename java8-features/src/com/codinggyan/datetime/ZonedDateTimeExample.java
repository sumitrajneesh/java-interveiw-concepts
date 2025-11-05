package com.codinggyan.datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeExample {
    public static void main(String[] args) {

        // 1️⃣ Current date and time with system default time zone
        ZonedDateTime currentZoneDateTime = ZonedDateTime.now();
        System.out.println("Current Zoned DateTime (System Default): " + currentZoneDateTime);

        // 2️⃣ Create ZonedDateTime with specific zone
        ZonedDateTime indiaTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("India Time: " + indiaTime);
        System.out.println("New York Time: " + newYorkTime);

        // 3️⃣ Convert LocalDateTime to ZonedDateTime
        LocalDateTime localDateTime = LocalDateTime.of(2025, 11, 5, 10, 30);
        ZonedDateTime zonedFromLocal = localDateTime.atZone(ZoneId.of("Europe/London"));
        System.out.println("LocalDateTime -> ZonedDateTime (London): " + zonedFromLocal);

        // 4️⃣ Convert between time zones
        ZonedDateTime tokyoTime = zonedFromLocal.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println("London Time converted to Tokyo Time: " + tokyoTime);

        // 5️⃣ Formatting ZonedDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z Z");
        System.out.println("Formatted India Time: " + indiaTime.format(formatter));
        System.out.println("Formatted New York Time: " + newYorkTime.format(formatter));

        // 6️⃣ Extract parts
        System.out.println("Zone ID: " + indiaTime.getZone());
        System.out.println("Offset: " + indiaTime.getOffset());
    }
}
