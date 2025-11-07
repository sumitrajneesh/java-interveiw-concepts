package creational.prototype.prototypedemo;

public class PrototypeMain {
    public static void main(String[] args) {
        EmployeeRecord original = new EmployeeRecord(101, "sumit", "DevOps");

        // Clone the original object
        EmployeeRecord copy = (EmployeeRecord)  original.clone();

//        original.id = 102; make them public int

        System.out.println("Original: " + original);
        System.out.println("Copy: " + copy);
    }
}
