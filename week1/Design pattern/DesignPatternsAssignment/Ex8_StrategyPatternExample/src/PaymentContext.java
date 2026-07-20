public class PaymentContext {
    private PaymentStrategy strategy;

    public PaymentContext() {
    }

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(double amount) {
        if (strategy == null) {
            throw new IllegalStateException("No payment strategy has been set.");
        }
        strategy.pay(amount);
    }
}
