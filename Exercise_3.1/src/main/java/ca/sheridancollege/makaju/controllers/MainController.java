package ca.sheridancollege.makaju.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import ca.sheridancollege.makaju.beans.Player;

import ca.sheridancollege.makaju.repositories.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Controller
//@AllArgsConstructor
@RequiredArgsConstructor
public class MainController {
	
	private final PlayerRepository playerRepo;
	boolean accId=true;
	boolean accName=true;
	boolean accClass=true;
	boolean accPoint=true;
	
	@GetMapping({"/","/add"})
	public String goAdd(Model model) {
		model.addAttribute("Player", new Player());		
		
		return "Add.html";
	}
	@PostMapping("/add")
	public String processAdd(@ModelAttribute Player player) {
					
		playerRepo.save(player);
		
		return "redirect:/add";
	}
	@GetMapping("/view")
	public String goView(Model model) {
		model.addAttribute("Players", playerRepo.findAll());		
		
		return "View.html";
	}
	
	@GetMapping("/edit/{id}")
	public String goEdit(@PathVariable long id,Model model) {
		
		Optional<Player> checkPlayer= playerRepo.findById(id);
		if (checkPlayer.isPresent()) {
			Player player=checkPlayer.get();
			model.addAttribute("Player", player);
		}else {
			return "redirect:/view";
		}
		return"Edit.html";
	}
	
	@PostMapping("/edit")
	public String processEdit(@ModelAttribute Player player) {
		
		playerRepo.save(player);
		
		return "redirect:/view";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		playerRepo.deleteById(id);	
		return "redirect:/view";
	}
	
	@GetMapping("/id")
	public String sortbyId(Model model) {
		Pageable pageable;
		if (accId) {
		pageable = PageRequest.of(0, 100, Sort.by("id").ascending());
		accId=false;
		}
		else {
			pageable = PageRequest.of(0, 100, Sort.by("id").descending());
			accId=true;
			
		}

		model.addAttribute("Players", playerRepo.findAll(pageable));		
		
		return "View.html";
	}
	@GetMapping("/name")
	public String sortbyName(Model model) {
		Pageable pageable;
		if (accName) {
			pageable = PageRequest.of(0, 100, Sort.by("name").ascending());
			accName=false;
		}
		else {
			pageable = PageRequest.of(0, 100, Sort.by("name").descending());
			accName=true;
			
		}
		
		
		model.addAttribute("Players", playerRepo.findAll(pageable));		
		
		return "View.html";
	}
	@GetMapping("/class")
	public String sortbyClass(Model model) {
		
		Pageable pageable;
		if (accClass) {
			pageable = PageRequest.of(0, 100, Sort.by("unitClass").ascending());
			accClass=false;
		}
		else {
			pageable = PageRequest.of(0, 100, Sort.by("unitClass").descending());
			accClass=true;
			
		}
		model.addAttribute("Players", playerRepo.findAll(pageable));		
		
		return "View.html";
	}
	@GetMapping("/points")
	public String sortbyPoint(Model model) {
		Pageable pageable;
		if (accPoint) {
			pageable = PageRequest.of(0, 100, Sort.by("guildPoint").ascending());
			accPoint=false;
		}
		else {
			pageable = PageRequest.of(0, 100, Sort.by("guildPoint").descending());
			accPoint=true;
			
		}
		
		
		model.addAttribute("Players", playerRepo.findAll(pageable));		
		
		return "View.html";
	}
	
	

}
