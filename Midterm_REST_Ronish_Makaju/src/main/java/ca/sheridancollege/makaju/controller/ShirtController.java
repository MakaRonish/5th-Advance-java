package ca.sheridancollege.makaju.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.makaju.beans.Shirt;

import ca.sheridancollege.makaju.services.ShirtService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/shirt")
@AllArgsConstructor
public class ShirtController {
	private ShirtService shirtService;
	
	@GetMapping("/") 
	public List<Shirt> getAllShirts() {
		return shirtService.getAllShirts();
		
		
	}
	
	@GetMapping("/{id}") 
	public Shirt getShirtById(@PathVariable Long id) {
		return shirtService.getShirtById(id);
		
	}
	
	@PostMapping(value={"/",""},consumes="application/json") 
	public Shirt addNewShirt(@RequestBody Shirt shirt) {
		return shirtService.addShirt(shirt);
		
		
	}
	@PutMapping(value="/{id}",consumes="application/json") 
	public Shirt updateShirtById(@PathVariable Long id,@RequestBody Shirt shirt) {
		shirt.setId(id);
		return shirtService.update(shirt);
		
	}
	@DeleteMapping("/{id}")
	public String deletebyid(@PathVariable Long id) {
		shirtService.deleteShirtById(id);;
		return "deleted";
	}

}
