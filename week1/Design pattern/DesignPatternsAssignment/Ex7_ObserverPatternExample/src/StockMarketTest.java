public class StockMarketTest {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobile = new MobileApp("Alice");
        Observer web = new WebApp("sess-9182");

        market.registerObserver(mobile);
        market.registerObserver(web);

        market.setPrice("AAPL", 195.32);
        System.out.println();
        market.setPrice("GOOG", 2801.10);

        System.out.println();
        System.out.println("-- Deregistering mobile app --");
        market.deregisterObserver(mobile);
        market.setPrice("AAPL", 196.05);
    }
}
