package com.marondal.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.marondal.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {
	
	// 전달 받은 id와 일치하는 행 조회 
	public Review selectReview(@Param("id") int id);

}
