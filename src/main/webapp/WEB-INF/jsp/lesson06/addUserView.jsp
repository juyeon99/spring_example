<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lesson06 Ex01 - 회원 정보 추가 (Using Ajax)</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	<!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script> -->
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원 정보 추가</h1>
		
		<form method="post" action="/lesson06/add_user">
			<div class="form-group">
				<label for="name">이름</label>
				<input type="text" id="name" name="name" class="form-control col-3" placeholder="이름 입력">
			</div>
			
			<div class="form-group">
				<label for="yyyymmdd">생년월일</label>
				<input type="text" id="yyyymmdd" name="yyyymmdd" class="form-control col-3" placeholder="예) 20000101">
			</div>
			
			<div class="form-group">
				<label for="email">이메일</label>
				<input type="text" id="email" name="email" class="form-control col-3" placeholder="이메일 주소 입력">
			</div>
			
			<div class="form-group">
				<label for="introduce">자기소개</label>
				<textarea id="introduce" name="introduce" class="form-control col-5" rows="10"></textarea>
			</div>
			
			<!-- <input type="submit" class="btn btn-success" value="회원가입">	 -->	<!-- e.preventDefault() -->
			<input type="button" id="addBtn" class="btn btn-success" value="회원가입">	
		</form>
	</div>
	
<script>
	$(document).ready(function(){
		// 1) jquery의 submit 기능 이용하기(form은 잘 안씀)
		/* $('form'). on('submit', function(e){	// form태그 안의 모든 스크립트
			e.preventDefault();		// submit 되는 것을 막는다
			
			// validation 유효성 체크
			let name = $('#name').val().trim();
			if(name == ''){
				alert('이름을 입력하세요.');
				return false;	// submit을 안하고 끝냄
			}
			
			let yyyymmdd = $('#yyyymmdd').val().trim();
			if(yyyymmdd == ''){
				alert('생년월일을 입력하세요.');
				return false;
			}
			
			// 여기까지 도달하면 submit
			// return true;
		}); */
		
		
		// 2) jquery의 ajax 통신 이용하기 (ajax는 submit버튼 이용X)
		$('#addBtn').on('click', function(){
			// validation 유효성 체크
			let name = $('#name').val().trim();
			if(name == ''){
				alert('이름을 입력하세요.');
				return;
			}
			
			let yyyymmdd = $('#yyyymmdd').val().trim();
			if(yyyymmdd == ''){
				alert('생년월일을 입력하세요.');
				return;
			}
			
			// 모두 숫자인지 확인
			if(isNaN(yyyymmdd)){
				alert('생년월일에 숫자만 입력해주세요.');
				return;
			}
			
			let email = $('#email').val().trim();		// id로 가져오기
			let introduce = $('textarea[name=introduce]').val();		// name으로 가져오기
			
			// AJAX: 폼태그하고 상관없이 비동기(Asynchronous)로 별도 요청 (AJAX 특징: 요청한 사이트에서 그대로 머물러 있음)
			$.ajax({
				// request
				type:"POST"						// Request Method
				,url:"/lesson06/add_user"		// Action URL
				,data:{"name":name, "yyyymmdd":yyyymmdd, "email":email, "introduce":introduce}
				
				// response
				,success:function(data/*ResponseBody에 들어있는 값*/){
					alert(data);
					// location.href="/lesson06/add_user";
					location.href="https://google.com";
				}
				,complete:function(){	// 성공이든 실패든 상관없이 끝남
					alert("완료");
				}
				,error:function(e){
					alert("error :" + e);
				}
			});
			
		});
		
	});
</script>
</body>
</html>