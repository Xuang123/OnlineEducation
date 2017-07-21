<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ page import="java.util.*,java.sql.*,com.action.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    <link href="assets/css/ChangePassword.css" rel="stylesheet">
    <script src="assets/js/mootools.v1.11.js" type="text/javascript"></script>
    <script src="assets/js/sliding-tabs.js" type="text/javascript"></script>

</head>
<body>

<%String id=request.getParameter("id"); %>


<div class="wrapper">
	<div class="sidebar" data-background-color="white" data-active-color="danger">

    <!--
		Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
		Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
	-->

    	<div class="sidebar-wrapper">
            <div class="logo">
            <img src="assets/img/user.png" width="50" height="50"><font size="5px">&nbsp&nbsp&nbsp&nbsp你好</font>
                <a href="#" class="simple-text">
                </a>
            </div>

            <ul class="nav">
                          		<li>
                    <a href="UserMassage.jsp?id=30">
                        <i class="ti-map"></i>
                        <p>个人信息</p>
                    </a>
                </li>
                <li class="active">
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
                    <a class="navbar-brand" href="#">个人中心—密码修改</a>
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
        
           
		<div  class="content">
            <div class="container-fluid">
                <div class="card card-map">
                <s:form action="UPCAction" method="post">
					<div class="col-lg-12">
                        <div class="card">   
                        <div class="header">
                                <h4 class="title">用户密码修改</h4>
                            </div>                         
                            <div class="content">
                            <input type="hidden" class="form-control border-input" name="id"  placeholder="ID" value="<%=(request.getParameter("id")) %>" >
                                <form>                                                                    
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>原密码</label>
                                                <input type="password" class="form-control border-input" name="password" placeholder="输入原密码" value="">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">                                               
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>新密码</label>
                                                <input type="password" class="form-control border-input" name="newpassword" placeholder="输入新密码" value="">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>确认新密码</label>
                                                <input type="password" class="form-control border-input" name="confirmpassword" placeholder="再次输入新密码" value="">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                
                                            </div>
                                        </div>
                                    </div>                                                                        
                                   
                                    <div class="text-center">
                                        <button type="submit" class="btn btn-info btn-fill btn-wd">修改密码</button>
                                    </div>                             
                                </form>
                            </div>
                        </div>
                    </div>
                    </s:form>
                  </div>
               </div>
           </div>
        </div>
 </div>     
		<footer class="footer">
            <div class="container-fluid">
               
            </div>
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
