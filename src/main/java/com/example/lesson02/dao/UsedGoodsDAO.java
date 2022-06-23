package com.example.lesson02.dao;	// dao = Data Access Object(DB 데이터에 접근)

import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.lesson02.model.UsedGoods;

@Repository		// persistence layer
public interface UsedGoodsDAO {
	public List<UsedGoods> selectUsedGoodsList();
}