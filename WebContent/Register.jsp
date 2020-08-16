<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>注册页面</title>
		<script type="text/javascript" src="static/jquery-3.4.1.min.js"></script>
		<script type="text/javascript">
			$(function() {
				//检验用户名是否存在 
				$("#put1").focusout(function() {
					$.ajax({
						type:"POST",
						url:"${pageContext.request.contextPath}/checkname",
						data:"nickName="+$("#put1").val(),
						success: function(msg) {
							//alert(typeof(msg) + msg);
							if(msg == "false"){
								//alert(msg);
								$("#sp").html("该用户已存在").css("color","red")
							}
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
				margin-top:50px;
				
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
				margin-top: -250px;
				margin-left: 20px;
			}
		</style>
</head>
<body>
	
	<div id="div2">
		<form action="" method="post">
		<div id="div1">
		<p>账号:<input id="put1" type="text" name="nickName" placeholder="请输入账号"><span id="sp"></span></p>
		<p>密码:<input id="put2" type="password" name="nickPassword" placeholder="请输入密码"></p>
		<p>邮箱:<input id="put3" type="email" name="nickEmail" placeholder="请输入邮箱"></p>
		<p>手机号:<input type="text" name="Phone" placeholder="请输入手机号"></p>
		<p>性别:<input type="radio" name="gender" value="男" checked="checked"/>男<input type="radio" name="gender" value="女"/>女</p>
		<input id="zc" type="submit" value="注册">
		<input id="cz" type="reset" value="重置">
		</div>	
	</form>
	<h1><font size="15">欢&nbsp迎&nbsp注&nbsp册</font></h1>
	</div>
	
</body>
</html>