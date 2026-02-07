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

import ca.sheridancollege.makaju.beans.Student;
import ca.sheridancollege.makaju.services.StudentService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {
	
	private StudentService stuService;
	
	@GetMapping("/") 
	public List<Student> getAllStudents() {
		return stuService.getAllStudents();
		
		
	}
	
	@GetMapping("/{id}") 
	public Student getStuedntById(@PathVariable Long id) {
		return stuService.getStudentById(id);
		
	}
	
	@PostMapping(value={"/",""},consumes="application/json") 
	public Student addNewStudent(@RequestBody Student student) {
		return stuService.addStudent(student);
		
		
	}
	@PutMapping(value="/{id}",consumes="application/json") 
	public Student updateStuedntById(@PathVariable Long id,@RequestBody Student student) {
		student.setId(id);
		return stuService.update(student);
		
	}
	@PutMapping(value="/",consumes = "application/json")
	public List<Student> updateAllStudents(@RequestBody List<Student> students) {
	    return stuService.updateMultipleStudents(students);
	}
	
	@DeleteMapping("/{id}")
	public String deletebyid(@PathVariable Long id) {
		stuService.deleteStudentById(id);;
		return "deleted";
	}
	@DeleteMapping("/")
	public String delete() {
		stuService.deleteAllStudents();
		return "deleted";
	}


}
