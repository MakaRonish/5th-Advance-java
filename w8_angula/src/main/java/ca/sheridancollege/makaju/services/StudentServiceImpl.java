package ca.sheridancollege.makaju.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ca.sheridancollege.makaju.domain.Student;
import ca.sheridancollege.makaju.repositories.StudentRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

	private StudentRepository stuRepo;
	@Override
	public List<Student> findAll() {
		
		
		return stuRepo.findAll();
	}

	@Override
	public Student findById(Long id) {
		Optional<Student> foundStudent = stuRepo.findById(id);
		if(foundStudent.isPresent()) {
			return foundStudent.get();
			
		}else {
			return null;
		}
	}

	@Override
	public Student findByName(String name) {
		Optional<Student> foundStudent = stuRepo.findByName(name);
		if(foundStudent.isPresent()) {
			return foundStudent.get();
			
		}else {
			return null;
		}
	}

	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		return stuRepo.save(student);
	}

	@Override
	public List<Student> saveAll(List<Student> studentList) {
		// TODO Auto-generated method stub
		return stuRepo.saveAll(studentList);
	}

}
