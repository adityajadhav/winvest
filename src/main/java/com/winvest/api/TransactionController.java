package com.winvest.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.winvest.data.Transaction;
import com.winvest.data.User;
import com.winvest.repository.TransactionRepository;
import com.winvest.repository.UserRepository;

@RestController
@RequestMapping("api/transaction")
public class TransactionController {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = RequestMethod.GET)
	public final List<Transaction> getTransactions() {
		List<Transaction> transaction = transactionRepository.findAllByOrderByCreatedDateDesc();
		return transaction;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/pay/{amount}")
	public final void pay(@PathVariable("amount") String amount) {
		System.out.println(amount);
		Transaction t1 = new Transaction();
		t1.setCreatedDate(new Date());
		t1.setBelongToUser("Aditya");
		t1.setText("Chipotle Mexican Grill");
		Double amt = Double.parseDouble(amount);
		t1.setAmount(amt);
		t1.setWishlistAmount(addWishListTransaction(t1));

		transactionRepository.save(t1);
		
		List<User> users = userRepository.findByName("Aditya Jadhav");
		User user = users.get(0);
		user.setAmount(user.getAmount() -amt - addWishListTransaction(t1));
		user.getWishlist().get(0).setCoverPrice(user.getWishlist().get(0).getCoverPrice() + addWishListTransaction(t1));
		userRepository.save(user);

	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/update")
	public final void pay(@RequestBody ResponseDAO responseDAO) {
		System.out.println(responseDAO.getAmount());
		Transaction t1 = new Transaction();
		t1.setCreatedDate(new Date());
		t1.setBelongToUser("Aditya");
		t1.setText("Chipotle Mexican Grill");
		Double amt = Double.parseDouble(responseDAO.getAmount());
		t1.setAmount(amt);
		t1.setWishlistAmount(addWishListTransaction(t1));

		transactionRepository.save(t1);
		
		
		List<User> users = userRepository.findByName("Aditya Jadhav");
		
		
		User user = userRepository.findOne(users.get(0).getId());
		
		user.setAmount(user.getAmount() -amt - addWishListTransaction(t1));
		user.getWishlist().get(0).setCoverPrice(user.getWishlist().get(0).getCoverPrice() + addWishListTransaction(t1));
		user.getWishlist().get(0).setPercentCovered((user.getWishlist().get(0).getCoverPrice() * 100) / user.getWishlist().get(0).getActualPrice());

		userRepository.save(user);

		

	}
	
	public Double addWishListTransaction(Transaction t) {
		Transaction t1 = new Transaction();
		int roundOff = (int) Math.round(t.getAmount()) + 1;
		double amountToBeAdded = roundOff - t.getAmount();
		t1.setAmount(amountToBeAdded);
		t1.setCreatedDate(t.getCreatedDate());
		t1.setText("Wishlist Transaction");
		t1.setType("Wishlist");
		//transactionRepository.save(t1);
		return amountToBeAdded;
	}

}
