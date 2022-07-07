package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.NewUserBO;

@Controller
public class Lesson06Ex02Controller {
	
	@Autowired
	private NewUserBO newUserBO;
	
	// 회원가입 화면
	// http://localhost/lesson06/sign_up_view
	@RequestMapping("/lesson06/sign_up_view")
	public String signUpView() {
		return "lesson06/signUpView";
	}
	
	// 이름 중복 확인 - AJAX가 호출한 API
	@GetMapping("/lesson06/is_duplication")
	@ResponseBody		// AJAX 호출의 응답은 반드시 @ResponseBody => JSON String
	public Map<String, Boolean> isDuplication(
			@RequestParam String name){		// now we don't need Model to send data to jsp anymore cos JSON String doesn't need EL.
		
		// db select (new_user 테이블)
		boolean isDuplication = newUserBO.existNewUserByName(name);	// 중복이면 true
		
		Map<String, Boolean> result = new HashMap<>();
		result.put("is_duplication", isDuplication);
		
		return result;
	}
	
}