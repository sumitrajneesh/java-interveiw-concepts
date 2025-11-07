package creational.singleton.log.nothreadsafe;

public class Logger {

    // Step 1: Create a private static instance of the same class
    private static Logger instance;


    // Step 2: Make the constructor private — no one can create objects from outside
    private Logger() {
    }

    // Step 3: Provide a public static method to get the instance
    public static Logger getInstance() {
        if(instance == null) { // Lazy initialization
            instance = new Logger();
        }
        return instance;
    }

    // Step 4: Define a method for logging
    public void log(String message) {
        System.out.println("[LOG]" + message);
    }
}
