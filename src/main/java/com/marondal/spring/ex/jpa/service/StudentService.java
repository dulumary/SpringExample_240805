package com.marondal.spring.ex.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.ex.jpa.domain.Student;
import com.marondal.spring.ex.jpa.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student addStudent(String name, String phoneNumber, String email, String dreamJob) {
		
		Student student = Student.builder()
							.name(name)
							.phoneNumber(phoneNumber)
							.email(email)
							.dreamJob(dreamJob)
							.build();
		
		Student result = studentRepository.save(student);
		return result;
	}
	
	// id와 장래희망을 전달 받고, 수정하는 기능
	public Student updateStudent(int id, String dreamJob) {
		// update 대상을 조회 한다. 
		// 조회된 객체에서 수정을 진행한다. 
		// 해당 객체를 저장한다. 
		
		// Optional 
		// null 일수도 있는 객체를 저장할때 사용하는 객체
		// null일 수도 있는 객체를 리턴할때 사용
		Optional<Student> optionalStudent = studentRepository.findById(id);
		Student student = optionalStudent.orElse(null);
		
		student = student.toBuilder().dreamJob(dreamJob).build();
		
		Student result = studentRepository.save(student);
		
		return result;
		
	}
	
	public void deleteStudent(int id) {
		// 삭제 대상을 조회 한다. 
		// 조회된 객체를 통해 삭제 한다. 
		Optional<Student> optionalStudent = studentRepository.findById(id);
		Student student = optionalStudent.orElse(null);
		
		studentRepository.delete(student);
		
		
	}
	

}
