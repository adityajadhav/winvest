package com.winvest.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.winvest.data.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	public List<User> findByName(String name);

}
