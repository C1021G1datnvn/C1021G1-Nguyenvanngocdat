package com.codegym.service;

import com.codegym.model.Customer;
import org.springframework.stereotype.Service;

//@Service
public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}
