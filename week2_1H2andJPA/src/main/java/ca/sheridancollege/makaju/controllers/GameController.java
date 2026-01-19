package ca.sheridancollege.makaju.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.makaju.beans.Videogame;
import ca.sheridancollege.makaju.repositories.VideogameRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class GameController {
	
	VideogameRepository vgRepo;
	
//	public GameController(VideogameRepository vgRepo) {
//		this.vgRepo=vgRepo;
//	}
	
	@GetMapping("/")
	public String goHome() {
		
		return "home.html";
	}
	@GetMapping("/Add")
	public String addGames(Model model) {
		model.addAttribute("Videogame", new Videogame());
		return "Addgame.html";
	}
	@PostMapping("/Add")
	public String processGame(@ModelAttribute Videogame Videogame) {
		
		vgRepo.save(Videogame);
		return "redirect:/Add";
	}
	@GetMapping("/View")
	public String viewGame(Model model) {
		
		model.addAttribute("games",vgRepo.findAll());
		return "view.html";
	}

}
