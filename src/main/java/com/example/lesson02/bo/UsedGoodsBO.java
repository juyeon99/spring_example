package com.example.lesson02.bo;	//  bo = business object

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.lesson02.dao.UsedGoodsDAO;
import com.example.lesson02.model.UsedGoods;

@Service		// Business Layer
public class UsedGoodsBO {
	
	@Autowired		// 빼먹으면 NoSuchBeanDefinitionException
	private UsedGoodsDAO usedGoodsDAO;	// DI = Dependency Injection: new를 하지 않고도 spring 컨테이너 내의 클래스의 객체를 가져와 쓸 수 있음
	
	public List<UsedGoods> getUsedGoodsList() {
		return usedGoodsDAO.selectUsedGoodsList();
	}
}
