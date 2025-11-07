package creational.prototype.clone.shallow;

public class ShallowCloneExample {

    public static void main(String[] args) throws CloneNotSupportedException {
        Department d1 = new Department("DevOps");
        Employee e1 = new Employee(101, "Sumit", d1);
        Employee e2 = e1.clone(); //shallow clone

        System.out.println("Before changes: ");
        System.out.println("e1 = " + e1);
        System.out.println("e2 = " + e2);

        e1.department.name = "Cloud Platform";

        System.out.println("\nAfter change:");
        System.out.println("e1 = " + e1);
        System.out.println("e2 = " + e2);
    }

}
