package ca.sheridancollege.makaju.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.makaju.beans.Player;
import ca.sheridancollege.makaju.repositories.PlayerRepository;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Controller
public class MainController {
	
	PlayerRepository PlayerRepo;
	
	public String getRank(float points) {
	    if (points < 100) {
	        return "Bronze";
	    } else if (points < 300) {
	        return "Silver";
	    } else if (points < 700) {
	        return "Gold";
	    } else if (points < 1000) {
	        return "Platinum";
	    } else {
	        return "Diamond";
	    }
	}
	
	@GetMapping({"/","/add"})
	public String addPage(Model model) {
		model.addAttribute("player", new Player());
		return "Add.html";
	}
	
	@PostMapping("/add")
	public String proccessForm(@ModelAttribute Player info) {
		float points=info.getPoints();
		String rank=getRank(points);
		info.setRanks(rank);
		PlayerRepo.save(info);
		
		System.out.println(PlayerRepo);
		
		return "redirect:/";
	}
	
	@GetMapping("/view")
	public String goView(Model model) {
		model.addAttribute("players", PlayerRepo.findAll());
		return "View.html";
	}

}
