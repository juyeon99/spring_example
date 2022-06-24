package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RestController
public class ReviewRestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// http://localhost/lesson03/ex01
	// http://localhost/lesson03/ex01?id=2&name=a		// query parameter
	@RequestMapping("/lesson03/ex01")
	public Review ex01(	// Review table의 하나의 객체만 리턴
			// @RequestParam("id") int id			/*필수 파라미터 null 비허용*/
			// @RequestParam(value="id") int id		/*필수 파라미터*/
			// @RequestParam(value="id", required=true) int id		/*필수 파라미터*/
			// @RequestParam(value="id", required=false) Integer id	/*비필수 파라미터(null 허용이므로 int가 아니라 Integer타입)*/
			@RequestParam(value="id", defaultValue="1") int id		/*비필수 파라미터, null이 들어오면 id = 1*/
			) {		
		System.out.println("##### id: " + id);
		return reviewBO.getReview(id);
	}
	
}
