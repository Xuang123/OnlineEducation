<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线教育系统</title>
<link href="assets/css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="assets/js/jQuery1.7.js"></script>
<script type="text/javascript" src="assets/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="assets/js/jquery1.42.min.js"></script>
<script type="text/javascript" src="assets/js/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="assets/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var $tab_li = $('#tab ul li');
	$tab_li.hover(function(){
		$(this).addClass('selected').siblings().removeClass('selected');
		var index = $tab_li.index(this);
		$('div.tab_box > div').eq(index).show().siblings().hide();
	});	
});
</script>
<script type="text/javascript">
$(function(){
	$(".screenbg ul li").each(function(){
		$(this).css("opacity","0");
	});
	$(".screenbg ul li:first").css("opacity","1");
	var index = 0;
	var t;
	var li = $(".screenbg ul li");	
	var number = li.size();
	function change(index){
		li.css("visibility","visible");
		li.eq(index).siblings().animate({opacity:0},3000);
		li.eq(index).animate({opacity:1},3000);
	}
	function show(){
		index = index + 1;
		if(index<=number-1){
			change(index);
		}else{
			index = 0;
			change(index);
		}
	}
	t = setInterval(show,8000);
	//根据窗口宽度生成图片宽度
	var width = $(window).width();
	$(".screenbg ul img").css("width",width+"px");
});
</script>
</head>
<body>
<div id="tab">
  <ul class="tab_menu">
    <li class="selected">用户登录</li>
    <li>管理员登录</li>
  </ul>
  <div class="tab_box"> 
    <!-- 学生登录开始 -->
    <div>
      <div class="stu_error_box"></div>
      <form action="LoginAction" method="post" class="stu_login_error">
        <div id="username">
          <label>用户名：</label>
          <input type="text" id="stu_username_hide" name="username" placeholder="输入用户名" nullmsg="用户名不能为空！" datatype="s3-18" errormsg="学号范围在3~18个字符之间！" sucmsg="学号验证通过！"/>
          <!--ajaxurl="demo/valid.jsp"--> 
        </div>
        <div id="password">
          <label>密&nbsp;&nbsp;&nbsp;码：</label>
          <input type="password" id="stu_password_hide" name="password" placeholder="输入密码" nullmsg="密码不能为空！" datatype="*6-16" errormsg="密码范围在6~16位之间！" sucmsg="密码验证通过！"/>
        </div>
        <div id="code">
          <label>验证码：</label>
          <input type="text" id="stu_code_hide" name="code"  placeholder="输入验证码" nullmsg="验证码不能为空！" datatype="*4-4" errormsg="验证码有4位数！" sucmsg="验证码验证通过！"/>
          <img src="assets/img/captcha.jpg" title="点击更换" alt="验证码占位图"/> </div>
        <div id="remember">
          <div>
          <span id="remem">
          <input type="checkbox" name="remember">
                                    记住密码
          </span>
          &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span><a href="NewReg.jsp">用户注册</a></span>
          </div>
        </div>
        <div id="login">
          <button type="submit">登录</button>
        </div>
      </form>
    </div>
   <!-- 学生登录结束-->
   <!-- 导师登录开始-->
    <div class="hide">
     <div class="tea_error_box"></div>
      <form action="LoginAction" method="post" class="tea_login_error">
        <div id="username">
          <label>管理员账号：</label>
          <input type="text" id="tea_username_hide" name="username" placeholder="输入管理员账号" nullmsg="管理员账号不能为空！" datatype="s3-18" errormsg="教工号范围在3~18个字符之间！" sucmsg="教工号验证通过！"/>
          <!--ajaxurl="demo/valid.jsp"--> 
        </div>
        <div id="password">
          <label>密&nbsp;&nbsp;&nbsp;码：</label>
          <input type="password" id="tea_password_hide" name="password" placeholder="输入密码" nullmsg="密码不能为空！" datatype="*6-16" errormsg="密码范围在6~16位之间！" sucmsg="密码验证通过！"/>
        </div>
       <div id="code">
          <label>验证码：</label>
          <input type="text" id="stu_code_hide" name="code"  placeholder="输入验证码" nullmsg="验证码不能为空！" datatype="*4-4" errormsg="验证码有4位数！" sucmsg="验证码验证通过！"/>
          <img src="assets/img/captcha.jpg" title="点击更换" alt="验证码占位图"/> </div>
        <div id="remember">
          <div>
          <span id="remem">
          <input type="checkbox" name="remember">
                                    记住密码
          </span>
          &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span><a href="NewReg.jsp">用户注册</a></span>
          </div>
        </div>
        <div id="login">
          <button type="submit">登录</button>
        </div>
      </form>
    </div>
     <!-- 导师登录结束-->
  </div>
</div>

<div class="screenbg">
  <ul>
    <li><a href="javascript:;"><img src="assets/img/0.jpg"></a></li>
    <li><a href="javascript:;"><img src="assets/img/1.jpg"></a></li>
    <li><a href="javascript:;"><img src="assets/img/2.jpg"></a></li>
  </ul>
</div>
</body>
</html>