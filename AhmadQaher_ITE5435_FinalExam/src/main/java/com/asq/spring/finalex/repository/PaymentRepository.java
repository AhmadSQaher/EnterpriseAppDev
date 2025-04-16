package com.asq.spring.finalex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.asq.spring.finalex.model.Payment;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}