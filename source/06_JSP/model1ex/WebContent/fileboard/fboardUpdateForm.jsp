<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="com.lec.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath%>/css/style.css" rel="stylesheet">
  <style>
		#content_form{
			height: 550px; 
			padding-top:50px;
		}
	</style>  
</head>
 <body>
 	<jsp:include page="../main/header.jsp"/>
 	<div id="content_form">
 	<%
 		String pageNum = request.getParameter("pageNum");
 		int fnum = Integer.parseInt(request.getParameter("fnum"));
 		FileBoardDao dao = FileBoardDao.getInstance();
 		FileBoardDto dto = dao.getBoard(fnum);
 		System.out.println(dto + " 글 수정 들어갑니다!!!");		
 	%>
 		<form action="fboardUpdatePro.jsp" method="post" enctype="multipart/form-data">
 			<input type="hidden" name="pageNum" value="<%=pageNum %>">
 			<input type="hidden" name="dbfilename" value="<%=dto.getFfilename() == null ? "" : dto.getFfilename() %>">
 			<table>
 				<caption>글 수정</caption>
 				<tr>
 					<th>글 번호</th>
 					<td>
 						<input type="text" name="fnum" value="<%=dto.getFnum() %>" readonly="readonly">
 					</td>
 				</tr>
 				<tr>
 					<th>글 제목</th>
 					<td>
 						<input type="text" name="fsubject" value="<%=dto.getFsubject() %>" autofocus="autofocus" required="required">
 					</td>
 				</tr>
 				<tr>
 					<th>첨부 파일</th>
 					<td>
 						<input type="file" name="ffilename" style="width:30%;">
 						<%
 							if(dto.getFfilename() != null){
 								out.println("첨부파일 : " + dto.getFfilename());
 							} else {
 								out.println("첨부파일 없음");
 							}
 						%>
 					</td>
 				</tr>
 				<tr>
 					<th>본문</th>
 					<td>
 						<textarea row="5" cols="20" name="fcontent"><%=dto.getFcontent() %></textarea>
 					</td>
 				</tr>
 				<tr>
 					<th>삭제용 비번</th>
 					<td>
 						<input type="password" name="fpw" value="<%=dto.getFpw() %>" required="required">
 					</td>
 				</tr>
 				<tr>
 					<td colspan="2">
 						<input type="submit" value="글 수정" class="btn">
 						<input type="reset" value="글 수정 취소" onclick="history.back()" class="btn">
 						<input type="button" value="목록" onclick="location='fboardList.jsp?pageNum=<%=pageNum %>'" class="btn">
 					</td>
 				</tr>				
 			</table>
 		</form>
 	</div>
    <jsp:include page="../main/footer.jsp"/>
 </body>
</html>
