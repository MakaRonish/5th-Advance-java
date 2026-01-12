package ca.sheridancollege.makaju.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import ca.sheridancollege.makaju.beans.player;

@Controller
public class HomeController {
	public static ArrayList<player> Red_Team = new ArrayList<>();
	public static ArrayList<player> Blue_Team = new ArrayList<>();
	@GetMapping("/")
	public String goHome() {
		return "Home.html";
	}
	
	@GetMapping("/Add")
	public String goAdd(Model model) {
		model.addAttribute("player", new player());
		model.addAttribute("Team",List.of("RED","BLUE"));
		model.addAttribute("classes", List.of("Scout","Sniper","Soldier","Demoman"));
		return "AddPlayer.html";
	}
	
	@PostMapping("/Add")
	public String processAdd(
			@ModelAttribute player player
			) {
		
		System.out.println(player);
		if ((player.getTeam()).equals("RED")) {
			System.out.println("REd");
			Red_Team.add(player);
		}else {
			Blue_Team.add(player);
			System.out.println("Blue");
		}
		return "redirect:/Add";
	}
	
	@GetMapping("/View")
	public String goView(Model model) {
		model.addAttribute("Red_Team",Red_Team);
		model.addAttribute("Blue_Team",Blue_Team);
		return "View.html";
	}

}
