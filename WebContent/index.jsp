<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
	<h1 align="center">欢迎<font color="blue">${sessionScope.username.username}</font>登录,当前在线
	<font color="blue">${applicationScope.count}</font>人</h1>
</body>
</html>