<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	<form:form ModelAttribute ="userInfo" action="userlogin" method="post">
		<table>
			<tr>
				<td><label>登录名：</label></td>
				<td><form:input path="username" /></td>
				<td><form:errors path="usernanme"></form:errors></td>
			</tr>
			<tr>
				<td><label>密码：</label></td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td><label>生日：</label></td>
				<td><form:input path="birthDay"/></td>
			</tr>
			<tr>
				<td><label>年龄：</label></td>
				<td><input type="text" id="birthDay" name="birthDay"></td>
			</tr>
			<tr>
				<td><label>电话：</label></td>
				<td><input type="text" id="email" name="email"></td>
			</tr>
			<tr>
				<td><label>邮箱地址：</label></td>
				<td><input type="text" id="email" name="email"></td>
			</tr>
			<tr>
				<td><input type="submit" id="submit" value="登录"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>