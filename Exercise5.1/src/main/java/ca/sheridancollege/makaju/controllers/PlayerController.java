package ca.sheridancollege.makaju.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.makaju.beans.Player;
import ca.sheridancollege.makaju.services.PlayerService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/players")
@AllArgsConstructor
public class PlayerController {
	
private PlayerService stuService;
	
	@GetMapping("/") 
	public List<Player> getAllPlayers() {
		return stuService.getAllPlayers();
		
		
	}
	
	@GetMapping("/{id}") 
	public Player getPlayerById(@PathVariable Long id) {
		return stuService.getPlayerById(id);
		
	}
	
	@PostMapping(value={"/",""},consumes="application/json") 
	public Player addNewStudent(@RequestBody Player student) {
		return stuService.addPlayer(student);
		
		
	}
	@PutMapping(value="/{id}",consumes="application/json") 
	public Player updateStuedntById(@PathVariable Long id,@RequestBody Player student) {
		student.setID(id);
		return stuService.update(student);
		
	}
	@PutMapping(value="/",consumes = "application/json")
	public List<Player> updateAllStudents(@RequestBody List<Player> students) {
	    return stuService.updateMultiplePlayers(students);
	}
	
	@DeleteMapping("/{id}")
	public String deletebyid(@PathVariable Long id) {
		stuService.deletePlayerById(id);;
		return "deleted";
	}
	@DeleteMapping("/")
	public String delete() {
		stuService.deleteAllPlayers();
		return "deleted";
	}

}
