package com.winvest.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.winvest.data.Transaction;
import com.winvest.repository.TransactionRepository;

@RestController
@RequestMapping("api/transaction")
public class TransactionController {

	@Autowired
	private TransactionRepository transactionRepository;

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
