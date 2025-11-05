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

