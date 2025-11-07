package creational.singleton.db;

public class DatabaseConnection {
    private static DatabaseConnection instance;


    private DatabaseConnection() {
        System.out.println("New DB connection created");
    }

    public static  DatabaseConnection getInstance() {
        if(instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

}
