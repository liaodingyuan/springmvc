<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<form action="/spring4maven/upload" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td><label>文件描述：</label></td>
				<td><input type="text" id="description" name="description" ></td>
			</tr>
			<tr>
				<td><label>请选择文件：</label></td>
				<td><input type="file" id="file" name="file"></td>
			</tr>			
			<tr>
				<td><input type="submit" id="submit" value="上传"></td>
			</tr>
		</table>
	</form>
</body>
</html>