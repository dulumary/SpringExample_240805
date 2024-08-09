package com.marondal.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.marondal.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {
	
	// 전달 받은 id와 일치하는 행 조회 
	public Review selectReview(@Param("id") int id);
	
	// 리뷰테이블에 한행 저장에 필요한 정보를 전달 받고 한 행을 insert
	public int insertReview(
			@Param("storeId") int storeId
			, @Param("menu") String menu
			, @Param("userName") String userName
			, @Param("point") double point
			, @Param("review") String review);
	
	// 리뷰테이블에 한행 저장에 필요한 정보를 객체로 전달 받고 한행을 insert
	public int insertReviewByObject(Review review);
}
