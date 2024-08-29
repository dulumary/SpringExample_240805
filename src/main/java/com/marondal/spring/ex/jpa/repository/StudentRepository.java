package com.marondal.spring.ex.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.marondal.spring.ex.jpa.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	// 1행 Insert
	// id(PK)를 기반으로 하나의 행을 조회하는 기능
	
	// id기준으로 내림차순 정렬된 결과 조회 
	// ORDER BY `id` DESC
	public List<Student> findAllByOrderByIdDesc();
	
	// id기준으로 내림차순한 결과를 2개만 조회 
	// ORDER BY `id` DESC LIMIT 2
	public List<Student> findTop2ByOrderByIdDesc();
	
	// 전달 받은 이름과 일치하는 행 조회 
	// WHERE `name` = #{name}
	public List<Student> findByName(String name);
	
	// 전달받은 이름 들과 일치하는 행 조회 
	// WHERE `name` IN (#{name1}, #{name2})
	public List<Student> findByNameIn(List<String> nameList);
	
	// 전달 받은 값이 포함된 email 컬럼을 가진 행 조회
	// WHERE `email` LIKE '%gmail%'
	public List<Student> findByEmailContaining(String email);
	
	// id컬럼의 값이 특정값 사이에 대응 되는 행을 id 기반으로 내림차순 정려 한 결과 조회 
	// WHERE `id` BETWEEN 1 AND 5 ORDER BY `id` DESC
	public List<Student> findByIdBetweenOrderByIdDesc(int start, int end);
	
	// 쿼리를 직접 작성해서 실행
	// Native Query
	// dreamJob 컬럼이 일치하는 데이터 조회
	@Query(value="SELECT * FROM `student` WHERE `dreamJob` = :dreamJob", nativeQuery=true)
	public List<Student> selectByDreamJob(@Param("dreamJob") String dreamJob); 
	
}
