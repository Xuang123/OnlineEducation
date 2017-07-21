<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.sql.*,com.action.*,com.entity.TUser" %>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 导入Java类包 -->
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Paper Dashboard by Creative Tim</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="assets/css/animate.min.css" rel="stylesheet"/>
    <link href="assets/css/animate-custom.css" rel="stylesheet" />

    <!--  Paper Dashboard core CSS    -->
    <link href="assets/css/paper-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet" />

    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="assets/css/themify-icons.css" rel="stylesheet">
    <link href="assets/css/usermessage.css" rel="stylesheet">
    <script src="assets/js/mootools.v1.11.js" type="text/javascript"></script>
    <script src="assets/js/sliding-tabs.js" type="text/javascript"></script>
</head>
<body>


<%    String id=request.getParameter("id");
      if(request.getAttribute("T_flag")==null) 
          response.sendRedirect("UMShowAction.action?id=30");
%>
<div class="wrapper">
	<div class="sidebar" data-background-color="white" data-active-color="danger">

    <!--
		Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
		Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
	-->

<!-- Java代码 -->




    	<div class="sidebar-wrapper">
            <div class="logo">
            <img src="assets/img/user.png" width="50" height="50"><font size="5px">&nbsp&nbsp&nbsp&nbsp你好</font>
                <a href="#" class="simple-text">
                </a>
            </div>

            <ul class="nav">
               <li class="active">
                    <a href="UserMassage.jsp?id=30">
                        <i class="ti-map"></i>
                        <p>个人信息</p>
                    </a>
                </li>
                <li >
                    <a href="UserManage.jsp?id=30">
                        <i class="ti-user"></i>
                        <p>用户查找</p>
                    </a>
                </li>
               <li>
                    <a href="doSearch?userId=<s:property value = "userId"/>">
                        <i class="ti-panel"></i>
                        <p>考试信息总览</p>
                    </a>
                </li>
                <li>
                   <a href="doSearch_exam?Exam_n_s_e=~<s:property value = "userId"/>_~_~_~&userId=<s:property value = "userId"/>">
                        <i class="ti-text"></i>
                        <p>参加考试</p>
                    </a>
                </li>
                <li>
                    <a href="SSCaction.action">
                        <i class="ti-pencil-alt2"></i>
                        <p>选择课程</p>
                    </a>
                </li>
                <li>
                    <a href="SMCaction.action">
                        <i class="ti-view-list-alt"></i>
                        <p>我的课程</p>
                    </a>
                </li>
                <li>
                    <a href="forum_login.jsp">
                        <i class="ti-view-list-alt"></i>
                        <p>论坛首页</p>
                    </a>
                </li>
            </ul>
    	</div>
    </div>


    
    <div class="main-panel">
         <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar bar1"></span>
                        <span class="icon-bar bar2"></span>
                        <span class="icon-bar bar3"></span>
                    </button>
                    <a class="navbar-brand" href="#">个人中心</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul id="messagebuttons" class="nav navbar-nav navbar-right">
                        <li>
                            <a href="UserMassage.jsp?id=30" >
                                <i class="ti-panel"></i>
								<p>查看个人信息</p>
                            </a>
                        </li>
                        <li class="dropdown">
                              <a href="UserMessageChange.jsp?id=30" >
                                    <i class="ti-bell"></i>
                                    <p class="notification"></p>
									<p>修改个人信息</p>
                              </a>
                              
                        </li>
						<li>
                            <a href="ChangePassword.jsp?id=30">
								<i class="ti-settings"></i>
								<p>修改密码</p>
                            </a>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>       
        
<!-- 用户信息显示区 -->           
		<div  class="content">
            <div class="container-fluid">
                <div class="card card-map">
					<div class="header">
                        <h4 class="title">个人信息</h4>                       
                    </div>
                    <s:iterator value="list" var="user" >
                <div id="message">
					<div id="leftmessage" >
                        <p><label> 用户姓名:</label><s:property value="#user.name"/></p>
                        <p><label> 登录账号:</label><s:property value="#user.regname"/></p>
                        <p><label>注册邮箱:</label><s:property value="#user.email"/></p>
                        <p><label> 注册时间:</label><s:property value="#user.regdate"/></p>
                        <p><label> 签名档:&nbsp&nbsp&nbsp&nbsp</label><s:property value="#user.signature"/></p>
                        <p><label> 发帖数:&nbsp&nbsp&nbsp&nbsp</label><s:property value="#user.post"/></p>
                        <p><label> 所在城市:</label><s:property value="#user.city"/></p>
                    </div>
                    <div id="rightmessage">
                        <p><label> 用户头像:</label><img src=""></p>
                        <p><label> 论坛昵称:</label><s:property value="#user.nickname"/></p>
                        <p><label>联系电话:</label><s:property value="#user.telphone"/></p>
                        <p><label> 最后登录:</label><s:property value="#user.logdate"/></p>
                        <p><label> 论坛积分:</label><s:property value="#user.point"/></p>
                        <p><label> 查看数:&nbsp&nbsp&nbsp&nbsp</label><s:property value="#user.watch"/></p>
                        <p><label> 电话:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label><s:property value="#user.phone"/></p>
                    </div>
                    <div id="cmessage">
                        <p><label> 自我介绍:</label><s:property value="#user.content"/></p>
                    </div>
                </div>
                </s:iterator>
                  </div>
               </div>
           </div>
        </div>
 </div>     
		<footer class="footer">
            <div class="container-fluid"></div>
        </footer>        
</body>

    <!--   Core JS Files   -->
    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="assets/js/bootstrap-checkbox-radio.js"></script>

	<!--  Charts Plugin -->
	<script src="assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

    <!-- Paper Dashboard Core javascript and methods for Demo purpose -->
	<script src="assets/js/paper-dashboard.js"></script>

	<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
	<script src="assets/js/demo.js"></script>

    <script>
        $().ready(function(){
            demo.initGoogleMaps();
        });
    </script>

</html>
