package ca.sheridancollege.makaju.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ca.sheridancollege.makaju.repositories.StudentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class StudentController {
	
	StudentRepository stuRepo;
	
	@GetMapping("/view")
	public String viewStudents(Model model) {
		model.addAttribute("students", stuRepo.findAll());
		
		return "viewStudent.html";
		
	}

}
