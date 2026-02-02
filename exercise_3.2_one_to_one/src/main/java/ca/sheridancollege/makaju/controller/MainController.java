package ca.sheridancollege.makaju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.makaju.beans.Guest;
import ca.sheridancollege.makaju.beans.Pet;
import ca.sheridancollege.makaju.repositories.GuestRepository;
import ca.sheridancollege.makaju.repositories.PetRepository;
import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class MainController {
	
	private GuestRepository guestRepo;
	private PetRepository petRepo;
	
	@GetMapping({"/","/add"})
	public String addPage(Model model) {
		model.addAttribute("guest", new Guest());
		
		return "Add.html";
	}
	
	@PostMapping("/add")
	public String processAdd(@ModelAttribute Guest guest) {
		if (guest.getPet() != null) {
	        boolean emptyName =
	                guest.getPet().getName() == null || guest.getPet().getName().isBlank();
	        boolean emptySpecies =
	                guest.getPet().getSpecies() == null || guest.getPet().getSpecies().isBlank();

	        if (emptyName && emptySpecies) {
	            guest.setPet(null);
	        }
	    }

	    guestRepo.save(guest);
	    return "redirect:/add";
	}
	
	@GetMapping("/view")
	public String view(Model model) {
		model.addAttribute("guest", guestRepo.findAll());
		return "View.html";
	}

}
