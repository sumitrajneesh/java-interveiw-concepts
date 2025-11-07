package creational.prototype.clone.shallow;

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
        return (Employee) super.clone();  // <-- Shallow clone
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", dept=" + department.name + "]";
    }

}
