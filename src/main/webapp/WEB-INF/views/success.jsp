<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %> 
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${mgs}; 登录名：${requestScope.user.loginname }
	<br> 生日：
	<fmt:formatDate value="${requestScope.user.birthDay }"
		pattern="yyyy年MM月dd日" />
		<br>
		邮件：${requestScope.user.email }
</body>
</html>