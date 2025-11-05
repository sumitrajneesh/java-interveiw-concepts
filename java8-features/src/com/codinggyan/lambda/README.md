🧩 Explanation
Type	Where Defined	Scope	Memory	Notes
Local variable	Inside method	Method only	Stack	Must be effectively final to be accessed in lambda
Instance variable	Class (non-static)	Per object	Heap	Each object gets its own copy
Static variable	Class (static)	Shared across all objects	Method area	Loaded once per class
Lambda variable	Inside lambda block	Same scope as where it’s defined	Stack	Can capture outer variables (read-o