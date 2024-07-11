<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.gn.user.vo.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정</title>
<link href='../../resources/css/user/edit.css' rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="../include/header.jsp"%>
	<%@ include file="../include/nav.jsp"%>
	<% User u = (User)request.getAttribute("user"); %>
	<section>
		<div id="section_wrap">
			<div class="word">
				<h3>회원 정보 수정</h3>
			</div>
			<br>
			<div class="modify_account_form">
				<form action='/user/editEnd' name="modify_account_form" method="post">
					<input type="hidden" name="user_no" value=<%=user.getUser_no()%>>
					<input type="text" name="user_id" value=<%=user.getUser_id() %> readonly disabled> <br>
					<input type="password" name="user_pw" placeholder="수정 비밀번호"> <br> 
					<input type="password" name="user_pw_check" placeholder="수정 비밀번호 확인"> <br> 
					<input type="text" name="user_name" value="" placeholder="닉네임"> <br> 
					<input type="button" value="정보수정" onclick="editUserForm();"> 
					<input type="reset" value="초기화">
				</form>
			</div>
		</div>
	</section>
	<script type="text/javascript">
		function editUserForm() {
				const form = document.modify_account_form;
				
				if(!form.user_pw.value) {
					alert("비밀번호를 입력하세요!");
					form.user_pw.focus();
				} else if(!form.user_pw_check.value) {
					alert("비밀번호 확인을 입력하세요!");
					form.user_pw_check.focus();
				} else if(form.user_pw.value != form.user_pw_check.value) {
					alert("비밀번호가 일치하는 지 확인하세요!");
					form.user_pw.focus();
				} else if(!form.user_name.value) {
					alert("닉네임을 입력하세요!");
					form.user_name.focus();
				} else {
					form.submit();
				}
				
		}
	</script>
</body>
</html>