package com.winvest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.winvest.data.User;
import com.winvest.repository.UserRepository;

@RestController
@RequestMapping("api/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = RequestMethod.GET)
	public final List<User> getUsers() {
		List<User> users = this.userRepository.findAll();
		return users;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/aditya")
	public final List<User> getUserByName() {
		List<User> users = this.userRepository.findByName("Aditya Jadhav");
		return users;
	}

}
