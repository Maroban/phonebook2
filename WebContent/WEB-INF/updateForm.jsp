<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호 수정</h1>

	<p>수정 화면입니다. 아래 항목을 수정하고 "수정" 버튼을 클릭하세요.</p>

	<form action="/phonebook2/pbc" method="get">
		<label>이름:</label>
		<input type="text" name="name" value="${requestScope.pVo.name}">
		<br> 전화번호:
		<input type="text" name="hp" value="${requestScope.pVo.hp}">
		<br> 회사:
		<input type="text" name="company" value="${requestScope.pVo.company}">
		<br>

		<input type="hidden" name="id" value="${requestScope.pVo.person_id}">
		<input type="hidden" name="action" value="update">

		<button type="submit">수정</button>

	</form>
</body>
</html>