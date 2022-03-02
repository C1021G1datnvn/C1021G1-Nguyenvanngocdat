package repository.customer;

import model.customer.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    void create(Customer customer);
    void delete(int customer_id);
    void update(Customer customer);
    Customer selectCustomer(int customer_id);
    List<Customer> search(String customer_name);

}
