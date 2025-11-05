### Optional

🧩 Explanation
Method	Description	Example
Optional.of(value)	Creates Optional with non-null value	Optional.of("Java")
Optional.empty()	Creates empty Optional	Optional.empty()
Optional.ofNullable(value)	Safe creation (works with null)	Optional.ofNullable(null)
isPresent()	Returns true if value exists	opt.isPresent()
get()	Returns value (⚠️ throws if empty)	opt.get()
orElse(defaultValue)	Returns value or default	opt.orElse("Default")
orElseGet(Supplier)	Lazily computes default	opt.orElseGet(() -> "Default")
orElseThrow(Supplier)	Throws exception if empty	opt.orElseThrow(...)
map(Function)	Transforms value if present	opt.map(String::length)
filter(Predicate)	Keeps value if condition true	opt.filter(s -> s.startsWith("J"))
ifPresent(Consumer)	Executes action if present	opt.ifPresent(System.out::println)

⚙️ When to Use Optional

✅ Use it for return types where null may occur:

```public Optional<User> findUserById(int id) {
return Optional.ofNullable(database.find(id));
}


❌ Don’t use it for:

Fields or class variables

Method parameters (not good practice)

Serialization (can cause issues)

🧠 Why Java Introduced Optional

Before Java 8:

String name = getUserName();
if (name != null) {
    System.out.println(name.toUpperCase());
} else {
    System.out.println("Anonymous");
}


After Java 8:

Optional.ofNullable(getUserName())
        .map(String::toUpperCase)
        .ifPresentOrElse(System.out::println, () -> System.out.println("Anonymous"));


Cleaner ✅
Null-safe ✅
Declarative ✅

🧩 Explanation of Each Use Case
Use Case	Real-World Meaning	Code Benefit
1️⃣ Safe lookup	Simulates DB or repository returning user	Eliminates null checks
2️⃣ Transform	Convert data safely if present	Cleaner chaining
3️⃣ ifPresentOrElse	Replaces if (obj != null)	Declarative flow
4️⃣ filter	Apply conditions elegantly	Avoids nested if blocks
5️⃣ flatMap	Handles dependent Optional results (like nested service calls)	Prevents Optional<Optional<T>>


🧠 When to Use Optional in Real Projects (Best Practices)

✅ Good use cases

As a return type from methods that might not find a value (like repository or lookup).

public Optional<User> findUserByEmail(String email);


For stream transformations or functional pipelines.

For optional configuration values.

❌ Avoid Optional

In method parameters or fields (not serializable, adds complexity).

For large collections (prefer empty lists/sets).

⚙️ Optional in Spring Boot (for your future projects)

In a Spring Data JPA Repository, this is very common:

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}


Then in your service layer:

userRepository.findByEmail(email)
    .ifPresentOrElse(
        user -> sendWelcomeEmail(user),
        () -> log.warn("User not found for email {}", email)
    );