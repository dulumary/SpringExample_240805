package com.marondal.spring.ex.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.ex.jpa.domain.Student;
import com.marondal.spring.ex.jpa.repository.StudentRepository;
import com.marondal.spring.ex.jpa.service.StudentService;

@Controller
@RequestMapping("/jpa/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	// 임시로 사용하는 형태
	// 절대 Controller 에서는 Repository 객체를 다루면 안된다!!!!!!!!
	@Autowired
	private StudentRepository studentRepository;
	
	// C, U, D
	@GetMapping("/create")
	@ResponseBody
	public Student createStudent() {
		// 김인규, 010-1234-5678, lecture@hagulu.com, 개발자
		Student student = studentService.addStudent("김인규", "010-1234-5678", "lec@hagulu.com", "개발자");
		
		return student;
	}
	
	@GetMapping("/update")
	@ResponseBody
	public Student updateStudent() {
		// id가 3인 학생정보의 장래희망을 강사로 변경
		Student student = studentService.updateStudent(3, "강사");
		
		return student;
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public String deleteStudent() {
		// id 가 4인 학생정보 삭제
		studentService.deleteStudent(4);
		
		return "삭제!";
	}
	
	@GetMapping("/find")
	@ResponseBody
	public List<Student> findStudent() {
		
		// 모든행 조회 
		List<Student> studentList = null;
		
//		studentList = studentRepository.findAll();
		
//		studentList = studentRepository.findAllByOrderByIdDesc();
//		studentList = studentRepository.findTop2ByOrderByIdDesc();
//		studentList = studentRepository.findByName("김인규");
		// 유재석, 조세호
		List<String> nameList = new ArrayList<>();
		nameList.add("유재석");
		nameList.add("조세호");
		
//		studentList = studentRepository.findByNameIn(nameList);
//		studentList = studentRepository.findByEmailContaining("naver");
//		studentList = studentRepository.findByIdBetweenOrderByIdDesc(2, 3);
		
		studentList = studentRepository.selectByDreamJob("프로그래머");
		
		return studentList;
	}
	
	
	@GetMapping("/jpa/lombok/test")
	@ResponseBody
	public Student lombokTest() {
		
//		Student student = new Student(10, "김인규", "010-1111-2222", "lecture@hagulu.com" ,"프로그래머", null, null);
//		student.setPhoneNumber("010-0000-9999");
		
		Student student = Student.builder()
				.name("김인규")
				.phoneNumber("010-0000-1111")
				.dreamJob("프로그래머")
				.email("lecture@hagulu.com")
				.build();
		
		return student;
		
	}

}
