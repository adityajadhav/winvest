package com.winvest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.winvest.data.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

}
