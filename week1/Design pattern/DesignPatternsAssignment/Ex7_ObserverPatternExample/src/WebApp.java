public class WebApp implements Observer {
    private final String sessionId;

    public WebApp(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public void update(String stockSymbol, double newPrice) {
        System.out.println("[Web App - session " + sessionId + "] " + stockSymbol +
                " is now $" + newPrice);
    }
}
