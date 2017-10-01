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
		u.setName("Aditya Jadhav");

		Item w1 = new Item();
		w1.setActualPrice(999);
		w1.setName("iPhone");
		w1.setCoverPrice(800);
		w1.setPercentCovered((w1.getCoverPrice() * 100) / w1.getActualPrice());

		Item w2 = new Item();
		w2.setActualPrice(599);
		w2.setName("Drone");
		w2.setCoverPrice(300);
		w2.setPercentCovered((w2.getCoverPrice() * 100) / w2.getActualPrice());

		Item w3 = new Item();
		w3.setActualPrice(300);
		w3.setName("GoPro");
		w3.setCoverPrice(100);
		w3.setPercentCovered((w3.getCoverPrice() * 100) / w3.getActualPrice());

		Item w4 = new Item();
		w4.setActualPrice(2000);
		w4.setName("Macbook Pro");
		w4.setCoverPrice(300);
		w4.setPercentCovered((w4.getCoverPrice() * 100) / w4.getActualPrice());

		u.setWishlist(Arrays.asList(w1, w2, w3, w4));
		userRepository.save(u);

		// transactions
		transactionRepository.deleteAll();

		Transaction t1 = new Transaction();
		t1.setCreatedDate(new Date());
		t1.setBelongToUser("Aditya");
		t1.setText("Debit Card Purchase VENTRA MOBILE");
		t1.setAmount(30.12);

		Transaction t2 = new Transaction();
		t2.setCreatedDate(new Date());
		t2.setBelongToUser("Aditya");
		t2.setText("Debit Card Purchase VENTRA MOBILE");
		t2.setAmount(15.10);

		transactionRepository.save(t1);
		addWishListTransaction(t1);
		transactionRepository.save(t2);
		addWishListTransaction(t2);

	}

	public void addWishListTransaction(Transaction t) {
		Transaction t1 = new Transaction();
		int roundOff = (int) Math.round(t.getAmount()) + 1;
		double amountToBeAdded = roundOff - t.getAmount();
		t1.setAmount(amountToBeAdded);
		t1.setCreatedDate(t.getCreatedDate());
		t1.setText("Wishlist Transaction");
		t1.setType("Wishlist");
		transactionRepository.save(t1);
	}
}
