package service.customer;

import model.customer.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void create(Customer customer);
    void delete(int id);
    void update(Customer customer);
    Customer selectCustomer(int customer_id);
    List<Customer> search(String customer_name);
}
