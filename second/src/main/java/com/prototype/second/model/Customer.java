package com.prototype.second.model;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("CUSTOMERS")
public class Customer {
    @Id
    private Integer num;
    @NotEmpty
    private String name;

    public Customer() {
    }

    public Customer(String customerData) {
        this.name = customerData;
    }

    public Integer getId() {
        return num;
    }

    public void setId(Integer id) {
        this.num = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
