<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>媒体下载页面</title>
</head>
<body>
	<h3>欢迎 ${ sessionScope.userInfo.username } 访问</h3>
	<table border="1">
		<tr>
			<th>名称</th>
			<th>类型</th>
			<th>大小</th>
		</tr>
		<c:forEach items="${ requestScope.mediaList }" var="media">
			<tr>
				<td height="60"><a href="fileDwonload/?filename=${ media.mediaName }">${ media.mediaName }</a>
				<td>${ media.mediaType }
				<td>
				<td>${ media.mediaSize }
				<td>
			</tr>

		</c:forEach>

	</table>

</body>
</html>