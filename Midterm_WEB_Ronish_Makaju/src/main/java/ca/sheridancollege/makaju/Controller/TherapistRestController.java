package ca.sheridancollege.makaju.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.makaju.beans.Shirt;
import ca.sheridancollege.makaju.beans.Therapist;



@Controller
public class TherapistRestController {
	
	private final String REST_URL="http://localhost:8085/api/v1/therapist/";

	
	@GetMapping("/")
	private String home() {
		return "Home.html";
	}
	
	@GetMapping("/view/therapist")
	private String view(Model model, RestTemplate restTemplate) {
		
		ResponseEntity<Therapist[]> responseEntity= restTemplate.getForEntity(REST_URL,Therapist[].class);
		model.addAttribute("therapistList", responseEntity.getBody());
		return "ViewTherapist.html";
	}
	
	@GetMapping("/addTherapist")
	private String Add(Model model,RestTemplate restTemplate) {
		model.addAttribute("therapist", new Therapist());
		 
		return "AddTherapist.html";
	}
	
	@PostMapping("/addTherapist")
	private String processadd(@ModelAttribute Therapist therapist,RestTemplate restTemplate) {
		
		ResponseEntity<Therapist> responseEntity=restTemplate.postForEntity(REST_URL, therapist, Therapist.class);
		
		System.out.println(responseEntity.getBody());
		
		return "redirect:/view/therapist";
	}

}
