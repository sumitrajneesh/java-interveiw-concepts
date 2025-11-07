package creational.singleton.log.threadsafe;

public class Logger {

    // volatile ensures visibility of changes across threads
    private static volatile Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if(instance == null) { //First check (no locking)
            synchronized (Logger.class) {
                if(instance == null ) { // second check (with locking)
                    instance = new Logger();
                }
            }
        }

        return instance;
    }

    public void log(String message) {
        System.out.println(Thread.currentThread().getName() + " - " + message);
    }
}
