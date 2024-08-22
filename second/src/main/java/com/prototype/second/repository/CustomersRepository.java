package com.prototype.second.repository;

import com.prototype.second.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepository extends CrudRepository<Customer, Integer> {}
