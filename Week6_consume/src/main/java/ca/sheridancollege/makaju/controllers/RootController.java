package ca.sheridancollege.makaju.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.makaju.beans.Student;
import ca.sheridancollege.makaju.services.AuthenticationService;
import ca.sheridancollege.makaju.services.StudentService;
import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class RootController {
	
	private AuthenticationService authenticationService;
	private final String REST_URL="http://localhost:8080/api/v1/students/";
	
	
	
	@GetMapping("/")
	private String home() {
		return "Home.html";
	}
	@GetMapping("/add")
	private String Add(Model model) {
		model.addAttribute("student", new Student());
		return "Add.html";
	}
	
	@PostMapping("/add")
	private String processadd(@ModelAttribute Student student,RestTemplate restTemplate) {
		
		ResponseEntity<Student> responseEntity=
				authenticationService.standardRequest(restTemplate, REST_URL, HttpMethod.POST, student, Student.class);
				
				//restTemplate.postForEntity(REST_URL, student, Student.class);
		
		System.out.println(responseEntity.getBody());
		
		return "redirect:/add";
	}
	
	@GetMapping("/view")
	private String view(Model model, RestTemplate restTemplate) {
		
		ResponseEntity<Student[]> responseEntity= 
				authenticationService.standardRequest(restTemplate, REST_URL, HttpMethod.GET, "", Student[].class);
				//restTemplate.getForEntity(REST_URL,Student[].class);
		
		
		
		
		model.addAttribute("studentList", responseEntity.getBody());
		return "View.html";
	}
	@GetMapping("/edit/{id}")
	public String editGame(@PathVariable long id,Model model, RestTemplate restTemplate) {
		ResponseEntity<Student> responseEntity= 
				authenticationService.standardRequest(restTemplate, REST_URL+"/"+id, HttpMethod.GET, "", Student.class);
				
				//restTemplate.getForEntity(REST_URL+"/"+id,Student.class);
		model.addAttribute("student", responseEntity.getBody());
		
		
		
		return "Edit.html";
	}
	
	@PostMapping("/edit")
	public String processEdit(@ModelAttribute Student student, RestTemplate restTemplate) {
		
		restTemplate.put(REST_URL + "/" +student.getId(), student);
		return "redirect:/view";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable long id, RestTemplate restTemplate) {
		restTemplate.delete(REST_URL+"/"+id);
		
		return "redirect:/view";
	}
	
	@GetMapping(value = "/getStudentAsJSON/{id}", produces = "application/json")
	@ResponseBody
	public Student getStudentAsJSON(Model model,
			@PathVariable Long id, RestTemplate resttemplate) {
		
		return authenticationService.standardRequest(resttemplate, REST_URL+"/"+id, HttpMethod.GET, "", Student.class).getBody();
	}

}
