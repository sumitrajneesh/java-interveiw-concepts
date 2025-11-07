package creational.prototype.clone.deep;


public class Employee implements Cloneable {
    int id;
    String name;
    Department department;

    Employee(int id, String name, Department department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // We'll write two versions: shallow and deep clone
    @Override
    public Employee clone() throws CloneNotSupportedException {
        // Deep clone: create a new Department object
        Department deptCopy = new Department(this.department.name);
        return new Employee(this.id, this.name, deptCopy);
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", dept=" + department.name + "]";
    }}
