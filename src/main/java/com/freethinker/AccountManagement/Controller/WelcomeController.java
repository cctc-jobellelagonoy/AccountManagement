package com.freethinker.AccountManagement.Controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8282")
@RestController
@RequestMapping("/")
public class WelcomeController {

	@GetMapping("")
	 public String sayHi() {
		return "Welcome!";
	 }
}
