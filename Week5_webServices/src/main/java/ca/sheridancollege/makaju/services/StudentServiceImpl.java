package ca.sheridancollege.makaju.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ca.sheridancollege.makaju.beans.Student;
import ca.sheridancollege.makaju.beans.repositories.StudentRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

	private StudentRepository stuRepo;
	@Override
	public Student addStudent(Student student) {
		student.setId(null);
		if(student.getGrade()<0) {
			student.setGrade(0d);
		}
		student.setLetterGrade(findletterGrade(student.getGrade()));
		Student addedStudent = stuRepo.save(student);
		
		// TODO Auto-generated method stub
		return addedStudent;
	}
	public String findletterGrade(double grade) {
		if (grade>=80) {
			return "A";
		}else if(grade>=70) {
			return "B";
		}else if (grade >=60) {
			return "C";
		}else if (grade >=50) {
			return "D";		
		}else {
			return "E";
		}
	}
	@Override
	public Student getStudentById(Long id) {
		Optional<Student> foundStudent = stuRepo.findById(id);
		if(foundStudent.isPresent()) {
			return foundStudent.get();
			
		}else {
			return null;
		}
		
		
	}
	
	

	@Override
	public List<Student> getAllStudents() {
		
		return stuRepo.findAll();
	}

	@Override
	public Student update(Student student) {
		student.setLetterGrade(findletterGrade(student.getGrade()));
		Student addedStudent = stuRepo.save(student);
		
		// TODO Auto-generated method stub
		return addedStudent;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> updateMultipleStudents(List<Student> students) {
		for (Student s:students) {
			update(s);
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStudentById(Long id) {
		stuRepo.deleteById(id);
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllStudents() {
		stuRepo.deleteAll();
		// TODO Auto-generated method stub

	}



}
