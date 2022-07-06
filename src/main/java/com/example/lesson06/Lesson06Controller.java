package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.NewUserBO;
import com.example.lesson04.model.NewUser;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	
	@Autowired
	private NewUserBO newUserBO;
	
	// 유저를 추가할 수 있는 view 화면
	// http://localhost/lesson06/add_user_view
	@RequestMapping("/add_user_view")
	public String addUserView() {
		return "lesson06/addUserView";
	}
	
	// 유저 추가
	// http://localhost/lesson06/add_user
	@ResponseBody	// returns the string itself not the path of the jsp
	@RequestMapping("/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value="email", required=false) String email,
			@RequestParam(value="introduce", required=false) String introduce) {
		
		// insert db
		NewUser newUser = new NewUser();
		newUser.setName(name);
		newUser.setYyyymmdd(yyyymmdd);
		newUser.setEmail(email);
		newUser.setIntroduce(introduce);
		newUserBO.addNewUser(newUser);
		
		return "입력 성공";
	}
	
}
