package com.codinggyan.methodreferences;


import java.util.function.Function;

// A simple class with a constructor
class Person {
    private String name;

    // Constructor
    public Person(String name) {
        this.name = name;
        System.out.println("Person created: " + name);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "'}";
    }
}

public class ConstructorReference {
    public static void main(String[] args) {

        // ✅ Traditional way using Lambda Expression
        Function<String, Person> personCreatorLambda = name -> new Person(name);
        Person p1 = personCreatorLambda.apply("Alice");
        System.out.println(p1);

        System.out.println("--------------------------------");

        // ✅ Java 8 Constructor Reference using ::
        Function<String, Person> personCreatorRef = Person::new;
        Person p2 = personCreatorRef.apply("Bob");
        System.out.println(p2);

        /*
         * Here:
         * Function<T, R> = functional interface that takes one argument (T) and returns (R)
         * Person::new is equivalent to (name) -> new Person(name)
         */
    }
}
