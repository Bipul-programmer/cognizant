import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private final Map<String, Customer> customers = new HashMap<>();

    public CustomerRepositoryImpl() {
        customers.put("C001", new Customer("C001", "John Doe"));
        customers.put("C002", new Customer("C002", "Jane Smith"));
    }

    @Override
    public Customer findCustomerById(String id) {
        return customers.get(id);
    }
}
