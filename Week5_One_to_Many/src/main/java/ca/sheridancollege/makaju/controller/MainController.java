package ca.sheridancollege.makaju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ca.sheridancollege.makaju.Repositories.StoreRepository;
import ca.sheridancollege.makaju.beans.Employee;
import ca.sheridancollege.makaju.beans.Store;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MainController {
	private StoreRepository storeRepo;
	
	
	@GetMapping("/")
	public String view(Model model) {
		model.addAttribute("store", storeRepo.findAll());
		for (Store s: storeRepo.findAll()) {
			System.out.println("Data");
			System.out.println(s);
		}
		return "View.html";
	}

}
