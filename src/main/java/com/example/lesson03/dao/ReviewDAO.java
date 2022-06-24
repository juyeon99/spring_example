package com.example.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewDAO {
	public Review selectReview(@Param("id") int id);	// @Param: xml한테 id가 내려갈거라고 얘기해줌
}
