package ca.sheridancollege.makaju.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.makaju.beans.Student;

@Service
public interface StudentService {
	
	public Student[] getStudents(RestTemplate restTemplate);
	public Student[] getStudentsById(RestTemplate restTemplate,Long id);
	public Student[] addStudent(RestTemplate restTemplate,Student student);
	public void editStudent(RestTemplate restTemplate,Student student);
	public void deleteStudentById(RestTemplate restTemplate);

}
