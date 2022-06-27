package com.example.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewDAO {
	public Review selectReview(@Param("id") int id);	// @Param: xml한테 id가 내려갈거라고 얘기해줌(한 개일 때는 map으로 변환할 필요가 없으므로 안써도 되긴 함. 두개 이상일 때는 써야함)
	
	public int insertReview(Review review);
	
	public int insertReviewAsField(
			@Param("storeName") String storeName, 
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") double point, 
			@Param("review") String review);
	
	public int updateReviewById(
			@Param("id") int id, 
			@Param("review") String review);
}
