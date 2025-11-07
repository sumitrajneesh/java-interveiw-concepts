package creational.prototype.prototypedemo;

public class EmployeeRecord implements Prototype {

    private int id;
    private String name;
    private String department;

    public EmployeeRecord(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    @Override
    public Prototype clone() {
        return new EmployeeRecord(id, name, department);
    }

    @Override
    public String toString() {
        return "EmployeeRecord [id=" + id + ", name=" + name + ", dept=" + department + "]";
    }
}
