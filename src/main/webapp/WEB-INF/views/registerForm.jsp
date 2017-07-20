<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
	<form action="register" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td><label>登录名：</label></td>
				<td><input type="text" id="loginname" name="loginname"></td>
			</tr>
			<tr>
				<td><label>生日：</label></td>
				<td><input type="text" id="birthDay" name="birthDay"></td>
			</tr>
			<tr>
				<td><label>邮件：</label></td>
				<td><input type="text" id="email" name="email"></td>
			</tr>
			<tr>
				<td><label>请上传头像：</label></td>
				<td><input type="file" id="image" name="image"></td>
			</tr>
			<tr>
				<td><input type="submit" id="submit" value="登录"></td>
			</tr>
		</table>
	</form>
</body>
</html>