public class CustomerService {
    private final CustomerRepository customerRepository;

    
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(String id) {
        Customer customer = customerRepository.findCustomerById(id);
        if (customer == null) {
            throw new IllegalArgumentException("No customer found with id: " + id);
        }
        return customer;
    }
}
