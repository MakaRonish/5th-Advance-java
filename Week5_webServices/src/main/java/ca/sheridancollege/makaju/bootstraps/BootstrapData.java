package ca.sheridancollege.makaju.bootstraps;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.makaju.beans.Student;
import ca.sheridancollege.makaju.services.StudentService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {
	
	private StudentService stuService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		stuService.addStudent(Student.builder().name("Ronish").grade(99d).build());
		stuService.addStudent(Student.builder().name("Priya").grade(87d).build());
		stuService.addStudent(Student.builder().name("Ashim").grade(76d).build());
		stuService.addStudent(Student.builder().name("Kushal").grade(65d).build());
		stuService.addStudent(Student.builder().name("Rey").grade(58d).build());
		stuService.addStudent(Student.builder().name("Bikesh").grade(92d).build());
		stuService.addStudent(Student.builder().name("Aarav").grade(81d).build());
		stuService.addStudent(Student.builder().name("Nisha").grade(73d).build());
		stuService.addStudent(Student.builder().name("Maya").grade(69d).build());
		stuService.addStudent(Student.builder().name("Sam").grade(54d).build());
		stuService.addStudent(Student.builder().name("Leo").grade(48d).build());

		
		

	}

}
