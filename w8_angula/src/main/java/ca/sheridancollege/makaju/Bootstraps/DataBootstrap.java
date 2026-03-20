package ca.sheridancollege.makaju.Bootstraps;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.makaju.domain.Student;
import ca.sheridancollege.makaju.services.StudentService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DataBootstrap implements CommandLineRunner {

	private StudentService stuService;
	@Override
	public void run(String... args) throws Exception {
		
		if (stuService.findAll().size()>0) return;	
		stuService.save(Student.builder().name("Ronish").age(21).build());
		stuService.save(Student.builder().name("Alex").age(20).build());
		stuService.save(Student.builder().name("Sophia").age(22).build());
		stuService.save(Student.builder().name("Michael").age(19).build());
		stuService.save(Student.builder().name("Emma").age(21).build());
		stuService.save(Student.builder().name("Daniel").age(23).build());
		stuService.save(Student.builder().name("Olivia").age(20).build());
		stuService.save(Student.builder().name("James").age(24).build());
		stuService.save(Student.builder().name("Ava").age(18).build());
		stuService.save(Student.builder().name("William").age(22).build());
		stuService.save(Student.builder().name("Isabella").age(21).build());

	}

}
