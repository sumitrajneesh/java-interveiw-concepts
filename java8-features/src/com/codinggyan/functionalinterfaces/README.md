🧠 Explanation
Concept	Description
Consumer<T>	A functional interface that takes one argument and returns no result.
Method	void accept(T t) — performs this operation on the given argument.
andThen()	Chains multiple Consumers to execute sequentially.
Usage in Streams	Commonly used with forEach() for side effects like printing or logging.

🧠 Explanation
Concept	Description
Supplier<T>	A functional interface that provides a result of type T without taking any input.
Method	T get() — returns an instance/value when invoked.
Common Use Cases	Lazy loading, default/fallback values, data generation, object factory pattern.
Difference from Consumer/Function	Consumer takes input, Function takes input and returns output, Supplier just returns output.

🧠 Explanation
Concept	Description
Function<T, R>	Represents a function that accepts one argument (T) and produces a result (R).
Method	R apply(T t) — applies the function to the argument and returns a result.
andThen()	Executes this function, then applies another function on the result.
compose()	Applies another function first, then this one.
identity()	Returns a function that always returns its input (useful in collectors).
Common Use Case	Transforming data using Stream.map(), chaining transformations.
