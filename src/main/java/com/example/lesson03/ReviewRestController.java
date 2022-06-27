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
	
	// http://localhost/lesson03/ex02/1
	@RequestMapping("/lesson03/ex02/1")
	public String ex02_1() {
		Review review = new Review();
		review.setStoreName("배달삼겹");
		review.setMenu("삼겹혼밥세트");
		review.setUserName("jy");
		review.setPoint(5);
		review.setReview("good");
		
		int row = reviewBO.addReview(review);	// insert된 row 수를 리턴받음
		return row > 0 ? row + "행 입력 성공" : "입력 실패";
	}
	
	// http://localhost/lesson03/ex02/2
	@RequestMapping("/lesson03/ex02/2")
	public String ex02_2() {
		int row = reviewBO.addReviewAsField("도미노피자","콤비네이션 피자","jy",5.0,"good");
		return row > 0 ? row + "행 입력 성공" : "입력 실패";
	}
	
	// http://localhost/lesson03/ex03?id=24&review=도미노피자는 맛있어
	@RequestMapping("/lesson03/ex03")
	public String ex03(
			@RequestParam("id") int id,
			@RequestParam("review") String review) {
		int row = reviewBO.updateReviewById(id, review);
		return row > 0 ? row + "행 수정 성공" : "수정 실패";
	}
}
