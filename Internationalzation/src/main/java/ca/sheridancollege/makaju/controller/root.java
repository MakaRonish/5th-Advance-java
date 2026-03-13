package ca.sheridancollege.makaju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class root {
	
	@GetMapping("/")
	public String goHome() {
		return "home.html";
	}

}
