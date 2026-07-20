public class MobileApp implements Observer {
    private final String userName;

    public MobileApp(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String stockSymbol, double newPrice) {
        System.out.println("[Mobile App - " + userName + "] " + stockSymbol +
                " is now $" + newPrice);
    }
}
