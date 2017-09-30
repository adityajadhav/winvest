package com.winvest;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.winvest.data.Item;
import com.winvest.data.User;
import com.winvest.repository.UserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		User u = new User();
		u.setName("Aditya");

		Item w1 = new Item();
		w1.setActualPrice(999);
		w1.setName("iPhone");
		w1.setCoverPrice(800);

		Item w2 = new Item();
		w2.setActualPrice(599);
		w2.setName("Drone");
		w2.setCoverPrice(300);

		u.setWishlist(Arrays.asList(w1, w2));
		userRepository.save(u);

	}
}
