package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Spring Bean
@RequestMapping("/lesson01/ex01")
@RestController		// = @Controller + @ResponseBody
public class Ex01RestController {
	
	// @Controller + @ResponseBody => MessageConverter 클래스 참조 => jackson lib (String이면 그자체를 리턴, Map같은건 json string으로 변환해서 리턴)
	
	// http://localhost:8080/lesson01/ex01/3
	@RequestMapping("/3")
	public String ex01_3() {
		return "@RestController를 사용해서 String을 리턴";
	}
	
	@RequestMapping("/4")
	public Map<String,String> ex01_4() {
		Map<String,String> map = new HashMap<>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		return map;		// jackson 라이브러리에 의해 JSON String으로 리턴
	}
	
	@RequestMapping("/5")
	public Data ex01_5() {
		Data data = new Data();
		data.setId(1);
		data.setName("jy");
		return data;	// jackson 라이브러리로 인해 JSON String이 된다.
	}
	
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_6() {
		Data data = new Data();
		data.setId(2);
		data.setName("jk");
		
		return new ResponseEntity<>(data,HttpStatus.INTERNAL_SERVER_ERROR);
		// ex) if 잘못된 요청을 할 때 사용자에게 알려줄 때 사용
	}
}

/* 302: redirect
 * 
 * 400번대: 서버문제
 * 400: bad request(파라미터 불일치)
 * 404: page not found
 * 405: method 불일치
 * 
 * 500번대: 서버는 OK, 로직문제
 * 500: 서버에 요청은 됐는데, 서버 로직 문제 발생
 */
