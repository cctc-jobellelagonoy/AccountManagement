package com.freethinker.AccountManagement.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.freethinker.AccountManagement.Interfacce.AccountRepository;
import com.freethinker.AccountManagement.Model.Account;

@CrossOrigin(origins = "http://localhost:8282")
@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping("")
	 public String sayHi() {
		return "Welcome to account!";
	 }
	
	
	//Postman: PUT http://localhost:8282/account/update/{id}
	@PutMapping("/update/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable("id") Integer id, @RequestBody Account account) {
		Optional<Account> accountData = accountRepository.findById(id);

	    if (accountData.isPresent()) {
	      Account _account = accountData.get();
	      _account.copy(account);
	      return new ResponseEntity<>(accountRepository.save(_account), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
}