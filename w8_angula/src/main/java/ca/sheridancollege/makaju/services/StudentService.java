package ca.sheridancollege.makaju.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ca.sheridancollege.makaju.domain.Student;

@Service
public interface StudentService {
	public List<Student> findAll();
	public Student findById(Long id);
	public Student findByName(String name);
	public Student save(Student student);
	public List<Student> saveAll(List<Student> studentList);

}
