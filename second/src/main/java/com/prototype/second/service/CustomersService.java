package com.prototype.second.service;

import com.prototype.second.model.Customer;
import com.prototype.second.repository.CustomersRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomersService {

    private final CustomersRepository repo;

    public CustomersService(CustomersRepository repo) {
        this.repo = repo;
    }

    public Iterable<Customer> get() {
        return repo.findAll();
    }

    public Customer get(Integer num) {
        return repo.findById(num).orElse(null);
    }

    public boolean exists(Integer num){
        return repo.existsById(num);
    }
    public void remove(Integer num) {
        repo.deleteById(num);
    }

    public Customer put(Customer customer) {
        System.out.println("Saving customer: " + customer);
        repo.save(customer);
        return customer;
    }
}
