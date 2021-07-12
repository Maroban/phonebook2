<%@page import="com.javaex.vo.PersonVo"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
// Controller에서 Attribute()의 데이터를 가져오기
List<PersonVo> personList = (List<PersonVo>) request.getAttribute("pList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호 리스트</h1>
	<p>입력한 정보 내역입니다.</p>

	<%
	for (int i = 0; i < personList.size(); i++) {
	%>

	<table border="1">
		<tr>
			<td>이름</td>
			<td><%=personList.get(i).getName()%></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><%=personList.get(i).getHp()%></td>
		</tr>
		<tr>
			<td>회사</td>
			<td><%=personList.get(i).getCompany()%></td>
		</tr>
		<tr>
			<td><a href="/phonebook2/pbc?action=delete&id=<%=personList.get(i).getPerson_id()%>"> [삭제]</a></td>
			<td><a href="/phonebook2/pbc?action=uform&id=<%=personList.get(i).getPerson_id()%>"> [수정]</a></td>
		</tr>
	</table>
	<br>
	<%
	}
	%>

	<a href="/phonebook2/pbc?action=wform">전화번호 등록하기</a>

</body>
</html>