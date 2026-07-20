import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockMarket implements Stock {
    private final List<Observer> observers = new ArrayList<>();
    private final Map<String, Double> prices = new HashMap<>();

    
    
    private String lastUpdatedSymbol;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        double price = prices.get(lastUpdatedSymbol);
        for (Observer observer : observers) {
            observer.update(lastUpdatedSymbol, price);
        }
    }

    
    public void setPrice(String stockSymbol, double newPrice) {
        prices.put(stockSymbol, newPrice);
        lastUpdatedSymbol = stockSymbol;
        notifyObservers();
    }
}
