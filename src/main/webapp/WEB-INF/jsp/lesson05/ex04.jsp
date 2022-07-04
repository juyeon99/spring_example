<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lesson05 Ex04 - JSTL fn 라이브러리</title>
</head>
<body>
	<c:set var="str1" value="No pain. No gain."/>
	
	<h1>1. 길이 구하기 (length)</h1>
	${fn:length(str1)}<br>
	
	<h1>2. 특정 문자열이 있는지 확인 (contains)</h1>
	'No'가 존재하는가? ${fn:contains(str1, 'No')}<br>
	'No'가 존재하는가? ${fn:contains(str1, 'no')}<br>
	<c:if test="${fn:containsIgnoreCase(str1, 'no')}">
		문장에 'no'라는 문자열이 존재합니다. (대소문자 구분 안함)<br>
	</c:if>
	
	<h1>3. 특정 문자열로 시작하는지 확인 (startsWith)</h1>
	'No'로 시작하는가? ${fn:startsWith(str1, 'No')}<br>
	
	<h1>4. 특정 문자열로 끝나는지 확인 (endsWith)</h1>
	'n'으로 끝나는가? ${fn:endsWith(str1, 'n')}<br>
	'.'으로 끝나는가?(점은 제대로 검사가 안됨) ${fn:endsWith(str1, '.')}<br>
	단어째로 검사는 가능 -> ${fn:endsWith(str1, 'gain.')}<br>
	
	<h1>5. 문자열 치환 (replace)</h1>
	<c:set var="str2" value="I love chicken."/>
	${str2}<br>
	${fn:replace(str2, 'chicken', 'bread')}<br>
	
	<h1>6. 구분자로 잘라서 배열 만들기 (split)</h1>
	${fn:split(str1, '.')[0]}<br>
	${fn:split(str1, '.')[1]}<br>
	
	<h1>7. 시작 인덱스부터 종료 인덱스까지 자르기 (substring)</h1>
	<!-- str2에서 love 추출 -->
	<!-- I love chicken. =>	2,6 -->
	${fn:substring(str2, 2, 6)}<br>
	
	<h1>8. 모두 소문자로 변경 (toLowerCase)</h1>
	${fn:toLowerCase(str2)}<br>
	
	<h1>9. 모두 대문자로 변경 (toUpperCase)</h1>
	${fn:toUpperCase(str2)}<br>
	
	<h1>10. 앞 뒤 공백 제거 (trim)</h1>
	<c:set var="str3" value="        hello     "/>
	<pre>str3: ${str3}</pre>
	<pre>str3: ${fn:trim(str3)}</pre>
		
</body>
</html>