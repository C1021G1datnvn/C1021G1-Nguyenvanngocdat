package service.customer.impl;

import model.customer.CustomerType;
import repository.customer.impl.CustomerTypeImpl;
import service.customer.CustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImpl implements CustomerTypeService {
    CustomerTypeImpl customerType = new CustomerTypeImpl();
    @Override
    public List<CustomerType> findAll() {
        return customerType.findAll();
    }
}
