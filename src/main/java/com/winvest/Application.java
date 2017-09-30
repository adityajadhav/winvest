package com.winvest;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.winvest.data.Item;
import com.winvest.data.Transaction;
import com.winvest.data.User;
import com.winvest.repository.TransactionRepository;
import com.winvest.repository.UserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TransactionRepository transactionRepository;

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

		Item w3 = new Item();
		w3.setActualPrice(300);
		w3.setName("GoPro");
		w3.setCoverPrice(100);

		Item w4 = new Item();
		w4.setActualPrice(2000);
		w4.setName("Macbook Pro");
		w4.setCoverPrice(300);

		u.setWishlist(Arrays.asList(w1, w2, w3, w4));
		userRepository.save(u);

		// transactions
		transactionRepository.deleteAll();
		
		Transaction t1 = new Transaction();
		t1.setCreatedDate(new Date());
		t1.setBelongToUser("Aditya");
		t1.setText("Debit Card Purchase VENTRA MOBILE");
		t1.setAmount(30.0);
		
		transactionRepository.save(t1);

	}
}
