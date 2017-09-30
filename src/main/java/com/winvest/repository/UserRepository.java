package com.winvest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.winvest.data.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
