public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Application started");

        Logger logger2 = Logger.getInstance();
        logger2.log("User logged in");

        Logger logger3 = Logger.getInstance();
        logger3.log("Processing request");

        System.out.println();
        System.out.println("logger1 == logger2 ? " + (logger1 == logger2));
        System.out.println("logger2 == logger3 ? " + (logger2 == logger3));
        System.out.println("Total log entries seen by logger1: " + logger1.getLogCount());

        if (logger1 == logger2 && logger2 == logger3) {
            System.out.println("SUCCESS: Only one Logger instance exists.");
        } else {
            System.out.println("FAILURE: Multiple Logger instances were created.");
        }
    }
}
