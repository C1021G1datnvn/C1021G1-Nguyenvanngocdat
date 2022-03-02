package service.customer.impl;

import model.customer.Customer;
import repository.customer.impl.CustomerImpl;
import service.customer.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerImpl customerRepository = new CustomerImpl();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void create(Customer customer) {
        customerRepository.create(customer);
    }

    @Override
    public void delete(int id) {
        customerRepository.delete(id);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.update(customer);
    }

    @Override
    public Customer selectCustomer(int customer_id) {
       return customerRepository.selectCustomer(customer_id);
    }

    @Override
    public List<Customer> search(String customer_name) {
        return customerRepository.search(customer_name);
    }
}
