package ca.sheridancollege.makaju.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.makaju.beans.Therapist;
import ca.sheridancollege.makaju.services.TherapistService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/therapist")
@AllArgsConstructor
public class TherapistController {
	private TherapistService therapistService;
	
	@GetMapping("/") 
	public List<Therapist> getAllTherapists() {
		return therapistService.getAllTherapists();
		
		
	}
	
	@GetMapping("/{id}") 
	public Therapist getTherapistById(@PathVariable Long id) {
		return therapistService.getTherapistById(id);
		
	}
	
	@PostMapping(value={"/",""},consumes="application/json") 
	public Therapist addNewTherapist(@RequestBody Therapist therapist ) {
		return therapistService.addTherapist(therapist);
		
		
	}

}
