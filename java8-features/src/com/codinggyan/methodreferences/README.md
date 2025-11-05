🧠 Explanation

Person::new → refers to the Person(String name) constructor.

Function<String, Person> → functional interface that takes a String and returns a Person.

The compiler infers which constructor to use based on the functional interface signature.

💡 When to use Constructor References

When you want to create objects in a clean, readable way using streams, lambdas, or method references.

For example:

List<String> names = Arrays.asList("John", "Jane", "Jack");
List<Person> people = names.stream()
.map(Person::new)  // constructor reference
.collect(Collectors.toList());

🧠 Explanation
Concept	Example	Meaning
Instance method reference	object::instanceMethod	Refers to an existing method of a particular object.
Static method reference	ClassName::staticMethod	Refers to a static method of a class.
Constructor reference	ClassName::new	Refers to a class constructor.

💡 Another Real-Life Use Case

Let’s say you have a list of names and want to print them in uppercase using an instance method of a helper class.

class StringProcessor {
public void printUpperCase(String s) {
System.out.println(s.toUpperCase());
}
}

public class Example {
public static void main(String[] args) {
List<String> names = Arrays.asList("alice", "bob", "carol");
StringProcessor processor = new StringProcessor();
names.forEach(processor::printUpperCase);  // instance method reference
}
}

🧠 Explanation
Type	Syntax	Example	Equivalent Lambda
Static Method Reference	ClassName::staticMethod	Utility::print	msg -> Utility.print(msg)
Instance Method Reference (of a particular object)	object::instanceMethod	printer::printMessage	msg -> printer.printMessage(msg)
Instance Method Reference (of arbitrary object of a type)	ClassName::instanceMethod	String::toUpperCase	s -> s.toUpperCase()
Constructor Reference	ClassName::new	Person::new	name -> new Person(name)

⚙️ Key Notes

Static method references are most used when working with Stream operations (map, filter, forEach, etc.).

The compiler automatically determines which static method matches the target functional interface signature.
