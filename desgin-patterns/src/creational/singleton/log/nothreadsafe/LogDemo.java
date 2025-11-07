package creational.singleton.log.nothreadsafe;

public class LogDemo {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application started");
        logger2.log("User logged In");
        logger1.log("New Log added");

        System.out.println(logger1);

        System.out.println(logger1 == logger2);
    }
}
