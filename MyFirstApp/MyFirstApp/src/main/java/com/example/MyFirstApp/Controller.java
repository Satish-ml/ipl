package com.example.MyFirstApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome to my site mf";
	}

}
