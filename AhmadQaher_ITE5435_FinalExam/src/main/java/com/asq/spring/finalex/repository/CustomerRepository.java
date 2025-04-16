package com.asq.spring.finalex.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.asq.spring.finalex.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}