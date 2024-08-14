package com.marondal.spring.ex.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.ex.mvc.domain.User;
import com.marondal.spring.ex.mvc.service.UserService;

@Controller
@RequestMapping("/mvc/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// 사용자 정보 저장 기능
	@PostMapping("/create")
	public String createUser(
			 @RequestParam("name") String name
			 , @RequestParam("birthday") String birthday
			 , @RequestParam("email") String email
			 , @RequestParam("introduce") String introduce
			 , Model model) {
		
//		int count = userService.addUser(name, birthday, email, introduce);
		
		User user = new User();
		user.setName(name);
		user.setYyyymmdd(birthday);
		user.setEmail(email);
		user.setIntroduce(introduce);
		
		userService.addUserByObject(user);
		
		model.addAttribute("result", user);
//		return "redirect:/mvc/user/info";
		return "mvc/userInfo";
		
	}
	
	// 입력 화면 페이지
	@GetMapping("/input")
	public String userInput() {
		return "mvc/userInput";
	}
	
//	@RequestMapping(path="/mvc/user/info", method=RequestMethod.GET)
	@GetMapping("/info")
	public String userInfo(Model model) {
		
		User user = userService.getLastUser();
		
		model.addAttribute("result", user);
		model.addAttribute("title", "회원정보");
		
		return "mvc/userInfo";
	}

}
