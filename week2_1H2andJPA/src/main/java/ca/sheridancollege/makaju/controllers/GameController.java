package ca.sheridancollege.makaju.controllers;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		Pageable page=PageRequest.of(0, 10);
		model.addAttribute("games",vgRepo.findBy(page));
		return "view.html";
	}
	@GetMapping("/edit/{id}")
	public String editGame(@PathVariable long id,Model model) {
		
		Optional<Videogame> checkGame= vgRepo.findById(id);
		if (checkGame.isPresent()) {
			Videogame game=checkGame.get();
			model.addAttribute("game", game);
		}else {
			return "redirect:/view";
		}
		return "editGame.html";
	}
	@PostMapping("/edit")
	public String processEdit(@ModelAttribute Videogame game) {
		vgRepo.save(game);
		
		return "redirect:/View";
	}
//	@GetMapping("/delete/{id}")
//	public String delete(@PathVariable long id) {
//		vgRepo.deleteById(id);	
//		return "redirect:/View";
//	}
	@GetMapping("/delete_sure/{id}")
	public String delete(@PathVariable long id) {
		vgRepo.deleteById(id);	
		return "redirect:/View";
	}
	
	@GetMapping("/delete/{id}")
	public String sure(@PathVariable long id,Model model) {
		model.addAttribute("id", id);
		return "delete.html";
	}
	
	@GetMapping("/search")
	public String search(Model model) {
		Videogame game = new Videogame();
		model.addAttribute("genre", game.getGenre());
		System.out.println(game.getGenre());
		return "search.html";
	}
	@PostMapping("/searchTitle")
	public String searchTitle(@RequestParam String title,Model model) {
		List<Videogame> games=vgRepo.findByTitleContainingIgnoreCase(title);
		model.addAttribute("games",games);
		
		return"search.html";
		
	}
	@PostMapping("/searchPrice")
	public String searchPrice(@RequestParam double price,Model model) {
		List<Videogame> games=vgRepo.findByPriceLessThan(price);
		model.addAttribute("games",games);
		
		return"search.html";
		
	}

}
