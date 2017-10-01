package com.winvest.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.winvest.data.Transaction;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {

	public List<Transaction> findAllByOrderByCreatedDateDesc();

}
