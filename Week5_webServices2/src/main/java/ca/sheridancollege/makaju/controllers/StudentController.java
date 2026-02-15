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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {
	
	private StudentService stuService;
	
	@Operation(summary="Return all the student we have")
	@ApiResponse(responseCode="200",
		description="List of students",
		content= {
				@Content(mediaType="application/json",
						 schema= @Schema(example="[{\"id\": 1,\"name\": \"Ronish\",\"grade\": 99.0,\"letterGrade\": \"A\"},{\"id\": 2,\"name\": \"Priya\",\"grade\": 87.0,\"letterGrade\": \"A\"}]")
						)
		}
			)
	@GetMapping("/") 
	public List<Student> getAllStudents() {
		return stuService.getAllStudents();
		
		
	}
	
	@GetMapping("/{id}") 
	public Student getStuedntById(@PathVariable Long id) {
		return stuService.getStudentById(id);
		
	}
	
	@Operation(summary="Adds a new students")
	@ApiResponse(responseCode="200",
		description="List of students",
		content= {
				@Content(mediaType="application/json",
						 schema= @Schema(example="[{\"id\": 1,\"name\": \"Ronish\",\"grade\": 99.0,\"letterGrade\": \"A\"},{\"id\": 2,\"name\": \"Priya\",\"grade\": 87.0,\"letterGrade\": \"A\"}]")
						)
		}
			)
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
