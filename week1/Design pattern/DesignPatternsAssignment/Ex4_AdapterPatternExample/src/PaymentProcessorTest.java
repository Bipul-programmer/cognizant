import java.util.List;

public class PaymentProcessorTest {
    public static void main(String[] args) {
        List<PaymentProcessor> processors = List.of(
                new StripeAdapter(new StripeGateway()),
                new PayPalAdapter(new PayPalGateway()),
                new RazorpayAdapter(new RazorpayGateway())
        );

        for (PaymentProcessor processor : processors) {
            processor.processPayment(49.99);
        }
    }
}
