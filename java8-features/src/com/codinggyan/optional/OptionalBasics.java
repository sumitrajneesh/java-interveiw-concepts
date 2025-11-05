package com.codinggyan.optional;

import java.util.Optional;

public class OptionalBasics {

    public static void main(String[] args) {
        // ✅ 1. Create Optionals
        Optional<String> nonEmpty = Optional.of("Java 8 Optional");  // value present
        Optional<String> emptyOpt = Optional.empty();                // empty optional
        Optional<String> nullableOpt = Optional.ofNullable(null);    // handles null safely

        // ✅ 2. Check presence
        System.out.println("nonEmpty isPresent: " + nonEmpty.isPresent());
        System.out.println("emptyOpt isPresent: " + emptyOpt.isPresent());

        // ✅ 3. Get value safely
        if (nonEmpty.isPresent()) {
            System.out.println("Value: " + nonEmpty.get());
        }

        // ✅ 4. Avoid NoSuchElementException
        System.out.println("orElse(): " + emptyOpt.orElse("Default Value"));
        System.out.println("orElseGet(): " + emptyOpt.orElseGet(() -> "Computed Default"));

        // ✅ 5. Throws exception if empty
        try {
            emptyOpt.orElseThrow(() -> new IllegalArgumentException("Value is missing!"));
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // ✅ 6. Functional-style methods
        Optional<String> upper = nonEmpty.map(String::toUpperCase);
        System.out.println("Mapped value: " + upper.orElse("No Value"));

        // ✅ 7. filter() example
        Optional<String> filtered = nonEmpty.filter(s -> s.contains("Optional"));
        System.out.println("Filtered value: " + filtered.orElse("Filtered out"));

        // ✅ 8. Chaining Optionals
        String result = Optional.ofNullable(getUserName())
                .map(String::toUpperCase)
                .orElse("ANONYMOUS USER");
        System.out.println("Chained result: " + result);

    }

    private static String getUserName() {
        // simulate null from a DB or API
        return null;
    }
}
