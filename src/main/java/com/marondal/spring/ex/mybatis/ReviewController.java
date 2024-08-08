package com.marondal.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.ex.mybatis.domain.Review;
import com.marondal.spring.ex.mybatis.service.ReviewService;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	// parameter로 전달 받은 id와 일치하는 리뷰 정보를 json으로 Response 담는다.
	@RequestMapping("/mybatis/review")
	@ResponseBody
	public Review review(@RequestParam("id") int id) {
		// request Parameter 
		// request.getParameter("id");
		Review review = reviewService.getReview(id);
		
		return review;
	}

}
