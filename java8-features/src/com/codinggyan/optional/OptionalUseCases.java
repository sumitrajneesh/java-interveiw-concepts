package com.codinggyan.optional;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Demonstrates real-world Optional use cases similar to a Spring Boot service layer.
 */
public class OptionalUseCases {
    // Simulated in-memory database
    private static Map<Integer, String> userDB = new HashMap<>();

    static {
        userDB.put(101, "Alice");
        userDB.put(102, "Bob");
        // user 103 not present
    }

    // ✅ Use case 1: find user safely
    public static Optional<String> findUserById(int id) {
        // Return Optional instead of null
        return Optional.ofNullable(userDB.get(id));
    }

    // ✅ Use case 2: optional chaining for transformations
    public static String getUpperCaseUserName(int id) {
        return findUserById(id)
                .map(String::toUpperCase)
                .orElse("USER NOT FOUND");
    }

    // ✅ Use case 3: Optional in API logic (avoid null checks)
    public static void greetUser(int id) {
        findUserById(id)
                .ifPresentOrElse(
                        name -> System.out.println("Hello, " + name + "!"),
                        () -> System.out.println("Hello, Guest!")
                );
    }

    // ✅ Use case 4: optional filter example
    public static void printIfUserStartsWithA(int id) {
        findUserById(id)
                .filter(name -> name.startsWith("A"))
                .ifPresentOrElse(
                        name -> System.out.println("User " + name + " starts with A"),
                        () -> System.out.println("User doesn't start with A or not found")
                );
    }

    // ✅ Use case 5: optional for dependent service calls
    public static void sendEmailToUser(int id) {
        findUserById(id)
                .map(OptionalUseCases::getEmailByName) // simulate dependent lookup
                .flatMap(email -> email)               // flatten nested Optional<Optional<String>>
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to: " + email),
                        () -> System.out.println("No email found for user ID: " + id)
                );
    }

    private static Optional<String> getEmailByName(String name) {
        // Simulate an email lookup
        if (name.equals("Alice")) return Optional.of("alice@example.com");
        if (name.equals("Bob")) return Optional.of("bob@example.com");
        return Optional.empty();
    }

    public static void main(String[] args) {
        System.out.println("---- Use Case 1: Safe User Lookup ----");
        System.out.println("User 101: " + findUserById(101).orElse("Not Found"));
        System.out.println("User 103: " + findUserById(103).orElse("Not Found"));

        System.out.println("\n---- Use Case 2: Transform Value ----");
        System.out.println("Uppercase user: " + getUpperCaseUserName(102));

        System.out.println("\n---- Use Case 3: Greet User ----");
        greetUser(101);
        greetUser(999);

        System.out.println("\n---- Use Case 4: Filter User ----");
        printIfUserStartsWithA(101);
        printIfUserStartsWithA(102);

        System.out.println("\n---- Use Case 5: Nested Optional (Email Lookup) ----");
        sendEmailToUser(101);
        sendEmailToUser(102);
        sendEmailToUser(103);
    }
}
