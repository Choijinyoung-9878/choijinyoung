<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="${conPath }/css/style2.css" rel="stylesheet" type="text/css">
</head>
 <body>
   	<form action="${conPath }/modify.do" method="post"  enctype="multipart/form-data">
   		<table>
   			<caption>정보 수정</caption>
   			<tr>
   				<th>아이디</th>
   				<td>
   					<input type="text" name="mid" value="${member.mid }" readonly="readonly">
   				</td>
   				<td rowspan="3">
   					<img src="${conPath}/memberPhotoUp/${member.mphoto }" alt="사진">
   				</td>
   			</tr>
   			<tr>
   				<th>비밀번호</th>
   				<td>
   					<input type="password" name="mpw" required="required">
   				</td>
   			</tr>
   			<tr>
   				<th>이름</th>
   				<td>
   					<input type="text" name="mname" value="${member.mname }" required="required">
   				</td>
   			</tr>
   			<tr>
   				<th>메일</th>
   				<td>
   					<input type="email" name="memail" value="${member.memail }">
   				</td>
   				<th>사진</th>
   			</tr>  
   			<tr>
   				<th>사진</th>
   				<td>
   					<input type="file" name="mphoto" >
   				</td>
   			</tr> 		
   			<tr>
   				<th>생년월일</th>
   				<td>
   					<input type="date" name="mbirth" value="${member.mbirth }">
   				</td>
   			</tr>
   			<tr>
   				<th>주소</th>
   				<td>
   					<input type="text" name="maddress" value="${member.maddress }">
   				</td>
   			</tr>
   			<tr>
   				<td colspan="3">
	   				<input type="submit" value="정보수정">
	   				<input type="button" value="취소" onclick="history.back()">
   				</td>
   			</tr>
   		</table>
   	</form>
 </body>
</html>
