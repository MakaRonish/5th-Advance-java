package ca.sheridancollege.makaju.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.makaju.beans.Player;




@Controller
public class PlayerController {
	
	private final String REST_URL="http://localhost:8080/api/v1/players/";
	
	@GetMapping("/")
	public String goView(Model model, RestTemplate restTemplate) {
		ResponseEntity<Player[]> responseEntity= restTemplate.getForEntity(REST_URL,Player[].class);
		model.addAttribute("playerList", responseEntity.getBody());
		
		return "view.html";
	}
	
	@GetMapping("/add")
	private String Add(Model model) {
		model.addAttribute("player", new Player());
		return "Add.html";
	}
	
	@PostMapping("/add")
	private String processadd(@ModelAttribute Player player,RestTemplate restTemplate) {
		
		ResponseEntity<Player> responseEntity=restTemplate.postForEntity(REST_URL, player, Player.class);
		
		System.out.println(responseEntity.getBody());
		
		return "redirect:/add";
	}
	@GetMapping("/edit/{id}")
	public String editGame(@PathVariable long id,Model model, RestTemplate restTemplate) {
		ResponseEntity<Player> responseEntity= restTemplate.getForEntity(REST_URL+"/"+id,Player.class);
		model.addAttribute("player", responseEntity.getBody());
		
		
		
		return "Edit.html";
	}
	
	@PostMapping("/edit")
	public String processEdit(@ModelAttribute Player player, RestTemplate restTemplate) {
		
		restTemplate.put(REST_URL + "/" +player.getID(), player);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable long id, RestTemplate restTemplate) {
		restTemplate.delete(REST_URL+"/"+id);
		
		return "redirect:/";
	}
	@GetMapping("/win/{id}")
	public String addWin(@PathVariable long id, RestTemplate restTemplate) {

	    // 1. Get current player
	    Player player = restTemplate
	            .getForObject(REST_URL + "/" + id, Player.class);

	    // 2. Increase gameWon
	    player.setGameWon(player.getGameWon() + 1);

	    // 3. Send updated player back to REST API
	    restTemplate.put(REST_URL + "/" + id, player);

	    // 4. Redirect back to home
	    return "redirect:/";
	}
	@GetMapping("/loss/{id}")
	public String addLoss(@PathVariable long id, RestTemplate restTemplate) {
		
		// 1. Get current player
		Player player = restTemplate
				.getForObject(REST_URL + "/" + id, Player.class);
		
		// 2. Increase gameWon
		player.setGameLost(player.getGameLost() + 1);
		
		// 3. Send updated player back to REST API
		restTemplate.put(REST_URL + "/" + id, player);
		
		// 4. Redirect back to home
		return "redirect:/";
	}


}
