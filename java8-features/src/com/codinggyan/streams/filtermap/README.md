### filter

🧠 Concept Breakdown
✅ filter(Predicate<T>)

Used to select elements that match a condition.
Example:

.filter(e -> e.getSalary() > 90000)

✅ map(Function<T, R>)

Used to transform elements from one type to another.
Example:

.map(Employee::getName)

✅ collect(Collectors.toList())

Used to gather results back into a List, Set, or Map.

⚙️ Stream Flow
Source (employees)
↓
filter(e -> e.getSalary() > 90000)
↓
map(Employee::getName)
↓
map(String::toUpperCase)
↓
collect(Collectors.toList())


Each stage transforms or filters the data before passing it to the next one — this is a stream pipeline.

⚡ Common Real-World Use Cases

Filtering database results (like active users, top performers).

Transforming data for APIs or reports.

Aggregating filtered data into collections.