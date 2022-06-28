package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.NewUserBO;
import com.example.lesson04.model.NewUser;

@RequestMapping("/lesson04")
@Controller		// no responsebody
public class NewUserController {
	
	@Autowired
	public NewUserBO newUserBO;
	
	// http://localhost/lesson04/sign_up_view
	@RequestMapping(path = "/sign_up_view", method = RequestMethod.GET)		// only allows get method (405에러: 메소드 불일치)
	public String signUpView() {
		// /WEB-INF/jsp/	.jsp
		return "lesson04/addUserView";		// view 경로 => jsp
	}
	
	// http://localhost/lesson04/add_user
//	@RequestMapping(path = "/add_user", method = RequestMethod.POST)
	@PostMapping("/add_user")		// post method (get으로 요청하면 405 error)
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value="email", required=false) String email/*비필수 파라미터*/,
			@RequestParam(value="introduce", required=false) String introduce/*비필수 파라미터*/) {
		
		// db insert (BO 요청)
		NewUser newUser = new NewUser();
		newUser.setName(name);
		newUser.setYyyymmdd(yyyymmdd);
		newUser.setEmail(email);
		newUser.setIntroduce(introduce);
		newUserBO.addNewUser(newUser);
		
		// response
		return "lesson04/afterAddUser";
	}
	
	// http://localhost/lesson04/last_user_view
	@GetMapping("/last_user_view")
	public String lastUserView(Model model) {
		// 가장 최근에 가입한 사람 한 명 정보 가져오기 -> select db
		NewUser newUser = newUserBO.getLastNewUser();
		
		// 결과 jsp view에 결과 객체값을 model에 담아 넘긴다.
		model.addAttribute("result"/*jsp에서 사용할 이름*/, newUser/*데이터*/);
		model.addAttribute("title", "회원 정보");
		
		// response
		return "lesson04/lastUserView";
	}
	
	
}
