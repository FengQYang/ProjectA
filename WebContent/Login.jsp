<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登录页面</title>
		<script type="text/javascript" src="static/jquery-3.4.1.min.js"></script>
		
		<script type="text/javascript">
			$(function() {
				$("#put1").blur(function() {
					if( ($("#put1").val()).length == 0  ){
						$("#s1").html("账号不能为空").css("color","red")
					}
				$("#put2").blur(function() {
					if(  ($("#put2").val()).length == 0 ){
						$("#s2").html("密码不能为空").css("color","red")
					}
				})
			})
		})
		</script>
		<style type="text/css">
			#div2{
				width: 800px;
				height:400px;
				border: solid 1px red;
				background-color: #3AE1B9;
				margin:auto;
				margin-top: 100px;
			}
			#div1{
				width: 40%;
				height: 350px;
				margin-left:400px;
				margin-top:150px;
				
			}
			#zc{
				width: 150px;
				height:30px;
				background-color: #48BDF3;
				color: white;
				border: white;
			}
			#cz{
				width: 150px;
				height:30px;
				background-color: #C9D6E1;
				color: white;
				border: white;
			}
			h1{
				margin-top: -350px;
				margin-left: 20px;
			}
		</style>
	</head>
	<body>
	<div id="div2">
		<form action="${pageContext.request.contextPath}/user?method=Login" method="post">
		<div id="div1">
			<p>账号:<input id="put1" type="text" name="nickName" placeholder="请输入账号"><span id="s1"></span><br />
			<p>密码:<input id="put2" type="password" name="nickPassword" placeholder="请输入密码"></p>
			<input id="zc" type="submit" value="登录">
			<input id="cz" type="reset" value="重置">
		</div>	
		</form>
	<h1><font size="15">欢&nbsp迎&nbsp登&nbsp录</font></h1>
</div>
	</body>
</html>