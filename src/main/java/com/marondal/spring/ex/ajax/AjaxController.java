package com.marondal.spring.ex.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	
	// Response 에 데이터(JSON)를 담는 페이지
	// API
	// 이름과 생년월일을 전달 받고, 이름과 나이를 json 으로 response 담는 기능
	@GetMapping("/ajax/person")
	@ResponseBody
	public Map<String, Object> personInfo(
			String name
			, String birthday) {
		
		int year = Integer.parseInt(birthday.substring(0, 4));
		
		int age = 2024 - year + 1;
		
		// {"name":"김인규", "age":24}
		Map<String, Object> personMap = new HashMap<>();
		personMap.put("name", name);
		personMap.put("age", age);
		
		return personMap;
		
	}
	
	@GetMapping("/ajax/ex01")
	public String ex01() {
		return "ajax/ex01";
	}

}
