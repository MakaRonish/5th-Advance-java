package ca.sheridancollege.makaju.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	//@GetMapping(value={"/","","/index"}) //multiple url maping
	@GetMapping("/") 
	public String goHome() {
		return "home.html";
	}
	
	
}
