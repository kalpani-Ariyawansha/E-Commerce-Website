package com.SQA.QATestForShop.payment;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PaymentRepository extends MongoRepository<Payment,String> {
    Optional<Payment> findById(String id);
}
