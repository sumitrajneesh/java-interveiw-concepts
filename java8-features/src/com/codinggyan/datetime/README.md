🧠 Explanation
Feature	Description
LocalDate.now()	Gets the current date from the system clock.
LocalDate.of()	Creates a specific date from year, month, and day.
LocalDate.parse()	Converts a string (ISO format) to a date.
DateTimeFormatter	Used for custom date formats.
plusDays(), plusWeeks(), plusMonths()	Adds time units to a date.
minusYears()	Subtracts time units.
isBefore(), isAfter()	Compare dates.
ChronoUnit.DAYS.between()	Measures days between two dates.
isLeapYear()	Checks if the current year is leap.

🔍 Key Takeaways

LocalDateTime ➜ no time zone.

ZonedDateTime ➜ includes full time zone + offset info.

ZoneId ➜ identifies the time zone (e.g., "Asia/Kolkata", "America/New_York").

withZoneSameInstant() ➜ converts between zones, keeping the same moment in time.

withZoneSameLocal() ➜ changes zone but keeps the local clock time (rarely used).