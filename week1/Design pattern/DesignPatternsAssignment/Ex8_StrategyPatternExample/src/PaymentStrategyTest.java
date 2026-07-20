public class PaymentStrategyTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(new CreditCardPayment("4111111111111234"));
        context.executePayment(120.50);

        
        context.setStrategy(new PayPalPayment("shopper@example.com"));
        context.executePayment(59.99);
    }
}
