###Lambda Basic

🧠 What This Demonstrates
Concept	Example	Interface Used
No parameter lambda	() -> System.out.println("Hello")	Runnable
Single parameter lambda	(msg) -> System.out.println(msg)	Consumer
Multiple params with return	(a,b) -> a + b	BinaryOperator
Boolean test condition	n -> n % 2 == 0	Predicate
Transformation function	s -> s.length()	Function
Sorting collection	(a,b) -> a.compareTo(b)	Comparator
Iterating list	list.forEach(x -> ...)	Consumer

🧠 Explanation
Interface Type	Method	Description	Example
Custom Functional Interface	single abstract method	Your own interface for lambdas	Calculator
Predicate<T>	boolean test(T t)	Returns true/false	Check if string starts with “J”
Function<T,R>	R apply(T t)	Transform value	Convert String → length
Consumer<T>	void accept(T t)	Process input, no return	Print message
Supplier<T>	T get()	No input, returns value	Generate random number