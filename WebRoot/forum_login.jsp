<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="assets/css/login_1.css">
<title>论坛登陆</title>
</head>
<body>
<div class="container">
		<section id="content">
	<s:actionerror />
	<form action="forumlogin">
		<p>
			用户名:<input type="text" name="regname">
		</p>
		<p>
			密码:<input type="password" name="password">
		</p>
		<button type="submit">登陆</button>
	</form>
	</section>
	</div>
</body>
</html>