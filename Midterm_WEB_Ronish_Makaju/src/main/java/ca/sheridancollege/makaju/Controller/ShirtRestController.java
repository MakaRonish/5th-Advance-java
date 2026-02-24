package ca.sheridancollege.makaju.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.makaju.beans.Shirt;
import ca.sheridancollege.makaju.beans.Therapist;



@Controller
public class ShirtRestController {
	
	private final String REST_URL="http://localhost:8085/api/v1/shirt/";

	
	@GetMapping("/view/shirts")
	private String view(Model model, RestTemplate restTemplate) {
		
		ResponseEntity<Shirt[]> responseEntity= restTemplate.getForEntity(REST_URL,Shirt[].class);
		
		
		
		
		model.addAttribute("shirtList", responseEntity.getBody());
		return "ViewShirt.html";
	}
	
	@GetMapping("/add")
	private String Add(Model model,RestTemplate restTemplate) {
		model.addAttribute("shirt", new Shirt());
		 String therapistUrl = "http://localhost:8085/api/v1/therapist/"; 
		    ResponseEntity<Therapist[]> response = restTemplate.getForEntity(therapistUrl, Therapist[].class);
		    
		    model.addAttribute("therapists", response.getBody());
		return "Add.html";
	}
	
	@PostMapping("/add")
	private String processadd(@ModelAttribute Shirt shirt,RestTemplate restTemplate) {
		
		ResponseEntity<Shirt> responseEntity=restTemplate.postForEntity(REST_URL, shirt, Shirt.class);
		
		System.out.println(responseEntity.getBody());
		
		return "redirect:/add";
	}
	
	@GetMapping("/delete/shirt/{id}")
	public String delete(@PathVariable long id, RestTemplate restTemplate) {
		restTemplate.delete(REST_URL+"/"+id);
		
		return "redirect:/view/shirts";
	}
	
	 @GetMapping("/purchase/shirt/{id}")
	    public String purchaseShirt(@PathVariable Long id, RestTemplate restTemplate) {
	        ResponseEntity<Shirt> response = restTemplate.getForEntity(REST_URL + id, Shirt.class);
	        Shirt shirt = response.getBody();

	        if (shirt != null && shirt.getQuantity() > 0) {
	            shirt.setQuantity(shirt.getQuantity() - 1);

	            restTemplate.put(REST_URL + id, shirt);
	        }

	        return "redirect:/view/shirts";
	    }

}
