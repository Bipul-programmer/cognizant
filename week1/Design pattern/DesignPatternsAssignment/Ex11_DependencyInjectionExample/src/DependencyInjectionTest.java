public class DependencyInjectionTest {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(repository);

        Customer found = customerService.getCustomer("C001");
        System.out.println("Found: " + found);

        try {
            customerService.getCustomer("C999");
        } catch (IllegalArgumentException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}
