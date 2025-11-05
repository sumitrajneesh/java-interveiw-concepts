### Default Method

🧩 Explanation
Feature	Description
Default method	Introduced in Java 8 — allows you to add new methods to interfaces without breaking existing classes that implement them.
Static method in interface	Can be called using the interface name directly, not via the instance.
Backward compatibility	Before Java 8, adding a new method in an interface forced all implementing classes to implement it — breaking old code. Default methods solved that problem.

🧠 3. Rules of Multiple Inheritance in Java 8
Rule	Explanation
1️⃣ Class wins	If a class in the hierarchy already has a method implementation, that takes precedence over interface default methods.
2️⃣ Sub-interface wins	If both parent and child interfaces have the same default method, the child’s version overrides the parent’s.
3️⃣ Must override if conflict	If a class implements two interfaces with the same default method, it must override the method to resolve the ambiguity.

Concept	Key Point
Default Methods	Allow interfaces to have implementations
Ambiguity	Occurs when multiple interfaces have same default method
Resolution	Override method in implementing class
Super call	Use InterfaceName.super.methodName()
Rules	Class > Child Interface > Parent Interface
