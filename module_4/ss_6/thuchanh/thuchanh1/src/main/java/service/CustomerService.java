package service;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService<Customer>{

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        if (customerRepository.findById(id) != null){
            return (Customer) customerRepository.findById(id);
        }else {
            return null;
        }
    }


    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.remove(id);
    }
}
