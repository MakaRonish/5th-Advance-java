package ca.sheridancollege.makaju.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ca.sheridancollege.makaju.beans.Student;



@Service

public interface StudentService {
	
	//Post
	public Student addStudent(Student student);
	//Get
	public Student getStudentById(Long id);
	
	public List<Student> getAllStudents();
	
	//put
	public Student update(Student student);
	
	public List<Student> updateMultipleStudents(List<Student> students);
	
	//delete
	public void deleteStudentById(Long id);
	public void deleteAllStudents();

}
