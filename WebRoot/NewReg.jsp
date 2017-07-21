<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<head>
	<meta charset="utf-8">
	<title>用户注册</title>
	<meta >
	<link rel="stylesheet" type="text/css" href="css/register-login.css">
</head>
<body>
<div id="box"></div>
<div class="cent-box register-box">
	<div class="cent-box-header">
		<h1 class="main-title hide">用户注册</h1>
		<h2 class="sub-title">在线教育系统注册</h2>
	</div>
	

	
		<form action="register" method="post">
		<div class="login form">
		
			<div class="group">
				
				<div class="group-ipt user">
					<input type="text" name="user" id="user" class="ipt" placeholder="选择一个用户名" required>
				</div>
				<div class="group-ipt user">
					<input type="text" name="nickname" id="nickname" class="ipt" placeholder="选择一个昵称" required>
				</div>
				<div class="group-ipt password">
					<input type="password" name="password" id="password" class="ipt" placeholder="设置登录密码" required>
				</div>
				<div class="group-ipt password1">
					<input type="password" name="password1" id="password1" class="ipt" placeholder="重复密码" required>
				</div>
				<div class="group-ipt user">
					<input type="text" name="name" id="name" class="ipt" placeholder="真实姓名" required>
				</div>
				<div class="group-ipt email">
					<input type="email" name="email" id="email" class="ipt" placeholder="邮箱地址" required>
				</div>
				
				<div class="group-ipt user">
					<input type="text" name="telphone" id="telphone" class="ipt" placeholder="手机号码" required>
				</div>
				<div class="group-ipt user">
					<input type="text" name="phone" id="phone" class="ipt" placeholder="办公电话" required>
				</div>
				<div class="group-ipt user">
					<input type="text" name="city" id="city" class="ipt" placeholder="居住地" required>
				</div>
				
			</div>
		</div>

		<div class="button">
			<button type="submit" class="login-btn register-btn" id="button">注册</button>
		</div>
		</form>
	</div>
</div>



<script src='js/particles.js' type="text/javascript"></script>
<script src='js/background.js' type="text/javascript"></script>
<script src='js/jquery.min.js' type="text/javascript"></script>
<script src='js/layer/layer.js' type="text/javascript"></script>
<script src='js/index.js' type="text/javascript"></script>

</body>
</html>