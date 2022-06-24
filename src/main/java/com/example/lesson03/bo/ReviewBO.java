package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	public Review getReview(int id) {	// int는 null이 허용이 안되므로 id가 꼭 값이 있음. 
										// Integer타입이면 null이 허용되므로 있을 수도 있고 없을 수도 있음
										// 필수냐 아니냐에 따라 primitive 타입을 쓸지 결정
		return reviewDAO.selectReview(id);
	}
	
}
