package com.freethinker.AccountManagement.Controller;

import java.util.ArrayList;
import java.util.List;
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
	
	//Postman: PUT http://localhost:<PORT>/account/update/{id}
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
	//Added code!	
	//Postman: GET http://localhost:<PORT>/account/getAccount/{id}
		@GetMapping("/getAccount/{id}")
		  public ResponseEntity<Account> getTutorialById(@PathVariable("id") Integer id) {
			    Optional<Account> accountData = accountRepository.findById(id);

			    if (accountData.isPresent()) {
			      return new ResponseEntity<>(accountData.get(), HttpStatus.OK);
			    } else {
			      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			    }
			  }
		
		//Postman: GET http://localhost:<PORT>/account/getAccounts
		@GetMapping("/getAccounts")
		  public ResponseEntity<List<Account>> getAllTutorials(@RequestParam(required = false) String AccountId) {
		    try {
		      List<Account> accountData = new ArrayList<Account>();

		      if (AccountId == null)
		    	  accountRepository.findAll().forEach(accountData::add);
		      else
		    	  accountRepository.findByAccountIdContaining(AccountId).forEach(accountData::add);

		      if (accountData.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(accountData, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }
		
		//DELETE http://localhost:<PORT>/account/delete{id}
		@DeleteMapping("/delete/{id}")
		  public ResponseEntity<HttpStatus> deleteAccount(@PathVariable("id") Integer id) {
		    try {
		      accountRepository.deleteById(id);
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }
}