<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
	<form:form modelAttribute="userInfo" action="/spring4maven/loginOrRegister/register"
		method="post" enctype="multipart/form-data">
		<table>
		
			<tr>
				<td><label>登录名：</label></td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><label>密码：</label></td>
				<td><form:input path="password" /></td>
				<td><form:errors path="password" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><label>邮件：</label></td>
				<td><form:input path="userEmail" /></td>
				<td><form:errors path="userEmail" cssStyle="color:red" /></td>
			</tr>
		
			<tr>
				<td><label>年龄：</label></td>
				<td><form:input path="age" /></td>
				<td><form:errors path="age" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><label>请上传头像：</label></td>
				<td><input id="profilePicture" name="profilePicture" /></td>
				
			</tr>
			<tr>
				<td><input type="submit" id="submit" value="注册"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>