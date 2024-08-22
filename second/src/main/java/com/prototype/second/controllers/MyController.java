package com.prototype.second.controllers;

import com.prototype.second.model.Customer;
import com.prototype.second.service.CustomersService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Optional;

@RestController
public class MyController {

    private final CustomersService service;

    public MyController(CustomersService service){
        this.service = service;
    }


    @GetMapping("/")
    public String welcome(){
        return "Welcome to our customer database!";
    }

    @GetMapping("/customers")           // READ
    public Iterable<Customer> get(){
        return service.get();
    }

    @GetMapping("/customers/{id}")
    public Customer get(@PathVariable Integer id){
        Customer customer = service.get(id);
        if(customer == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return customer;
    }

    @DeleteMapping("/customers/{id}")        // DELETE
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (service.exists(id)) {
            service.remove(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/customers")              // CREATE
    public Customer post(@RequestBody Customer customer) {
        System.out.println("Received customer: " + customer);
        return service.put(customer);
    }

    @PutMapping("/customers/{id}")          // UPDATE
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestBody Customer updatedCustomer) {
        if (service.exists(id)) {
            Customer existingCustomer = service.get(id);
            existingCustomer.setName(updatedCustomer.getName());
            service.put(existingCustomer);
            return ResponseEntity.ok(existingCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
