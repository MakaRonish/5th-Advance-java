package ca.sheridancollege.makaju.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.makaju.ContactRepository;
import ca.sheridancollege.makaju.beans.contacts;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;




@Controller
@AllArgsConstructor
public class Contact {
	
	ContactRepository ContactRepo;
	
	@PostConstruct
	public void defaultcontact() {
		ContactRepo.save(new contacts(null, "Ronish", "123-456-7890", "123 Street", "ronish@example.com"));
	    ContactRepo.save(new contacts(null, "Alice", "987-654-3210", "456 Avenue", "alice@example.com"));
	    ContactRepo.save(new contacts(null, "Bob Smith", "555-123-4567", "789 Pine Road", "bob@example.com"));
	    ContactRepo.save(new contacts(null, "Carol Lee", "444-987-6543", "321 Cedar Lane", "carol@example.com"));
	    ContactRepo.save(new contacts(null, "David Kim", "333-222-1111", "654 Birch Boulevard", "david@example.com"));
	    ContactRepo.save(new contacts(null, "Eva Green", "111-222-3333", "987 Spruce Street", "eva@example.com"));
		
	}
	
	
	
	@GetMapping({"/","","/add"})
	public String goContact(Model model) {
		model.addAttribute("contacts", new contacts());

		return "contact.html";
	}
	
	@PostMapping({"/","","/add"})
	public String processContact(@ModelAttribute contacts contacts) {
		
		ContactRepo.save(contacts);
		System.out.println(ContactRepo);
		return "redirect:/";
	}
	@GetMapping("/view")
	public String view(Model model) {
		model.addAttribute("contacts", ContactRepo.findAll());
		return "View.html";
	}

}
