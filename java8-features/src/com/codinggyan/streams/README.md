### Stream

🧠 Explanation
1️⃣ Stream Creation

Streams can be created from:

Collections → list.stream()

Arrays → Arrays.stream(array)

Static factories → Stream.of()

Infinite streams → Stream.generate() or Stream.iterate()

2️⃣ Intermediate Operations (return a stream)

These are lazy operations — they only execute when a terminal operation is called.
Examples:

filter()

map()

sorted()

distinct()

limit(), skip()

3️⃣ Terminal Operations (trigger execution)

Examples:

forEach()

collect()

count()

reduce()

findFirst()

anyMatch()

4️⃣ Stream Pipeline

A stream pipeline = Source → Intermediate operations → Terminal operation
Example:

list.stream()
.filter(...)
.map(...)
.collect(...);

⚙️ Key Properties of Streams

They don’t store data — they work on data sources.

They are lazy — operations are only executed when needed.

They are single-use — once consumed, they cannot be reused.

They support parallel processing via .parallelStream().

🧠 Explanation
✅ Types of sorting:

Natural Sorting – uses the element’s Comparable (e.g., strings, numbers)

names.stream().sorted()


Custom Sorting – uses Comparator

employees.stream().sorted(Comparator.comparing(Employee::getName))


Descending Order

.sorted(Comparator.comparing(...).reversed())

⚙️ Notes

sorted() → sorts in natural order (ascending).

sorted(Comparator) → sorts using a custom comparator.

Streams do not modify the original list, they return a new stream with the sorted elements.

Use .collect(Collectors.toList()) to store sorted results.

🧠 Explanation
✅ Sequential vs Parallel Stream
Feature	Sequential Stream	Parallel Stream
Execution	Single thread (main)	Multiple threads (ForkJoinPool)
Order guarantee	Preserved	May not preserve order
Best for	Small datasets or order-sensitive tasks	Large datasets or CPU-intensive computations
Creation	stream()	parallelStream() or .parallel()
⚙️ Under the Hood

Java 8 parallel streams use the ForkJoinPool.commonPool (a shared thread pool).

The framework splits the data into chunks and processes them concurrently.

It then merges the results after computation.

🚨 When Not to Use Parallel Streams

When the operation is I/O-bound (e.g., DB or file operations).

When the operation is not thread-safe.

When order of elements matters (use .forEachOrdered() instead).

💡 Example of Ordered Parallel Processing
names.parallelStream()
.map(String::toUpperCase)
.forEachOrdered(System.out::println);


This keeps the order even in parallel execution.

🧩 Explanation

Stream.of(...) → creates a stream from given elements.

Stream.concat(s1, s2) → combines two streams into one.

forEach(System.out::println) → prints each element.

Once a stream is consumed (via a terminal operation like forEach), it cannot be reused.

💡 Notes

Both streams must be of the same type (Stream<String> with Stream<String>, etc.).

You can chain multiple concatenations if needed:

Stream<String> all = Stream.concat(stream1, Stream.concat(stream2, stream3));


For large collections, prefer using Stream.of() or flatMap() to combine dynamically.

🧠 Explanation
Feature	Method	Description
toList()	Collectors.toList()	Collects stream elements into a List.
toSet()	Collectors.toSet()	Collects elements into a Set (removes duplicates).
toMap()	Collectors.toMap()	Collects elements into a Map with key-value logic.
joining()	Collectors.joining(", ")	Joins elements into a single String.
groupingBy()	Collectors.groupingBy()	Groups elements based on a classifier function.
counting()	Collectors.counting()	Counts occurrences when used with grouping.
partitioningBy()	Collectors.partitioningBy()	Divides elements into two groups based on a condition.

