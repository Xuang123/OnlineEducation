<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ page import="com.entity.TUser" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
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

    <!--  Paper Dashboard core CSS    -->
    <link href="assets/css/paper-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet" />

    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="assets/css/themify-icons.css" rel="stylesheet">
</head>
<body>

<%    String id=request.getParameter("id");
%>

<div class="wrapper">
	<div class="sidebar" data-background-color="white" data-active-color="danger">

    <!--
		Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
		Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
	-->

    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="#" class="simple-text">
                                                       你好
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
                <li >
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
                    <a class="navbar-brand" href="#">在线教育系统</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="UserManage.jsp?id=<%=id %>" class="dropdown-toggle" >
                                <i class="ti-panel"></i>
								<p>查看用户信息</p>
                            </a>
                        </li>
                        <li class="dropdown">
                              <a href="UMChange.jsp?id=<%=id %>" class="dropdown-toggle" >
                                    <i class="ti-bell"></i>
									<p>修改用户信息</p>

                              </a>                              
                        </li>
                    </ul>

                </div>
            </div>
        </nav>


        <div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="header">
									<h4 class="title">用户查询</h4>
									<p class="category">Find User</p>
								</div>
								<form action = "IDSearchAction" method = "post">
								
										<div class="col-md-3">
											<div class="form-group">
												<label>用户ID</label> 
												<input name="id",type="text"
													class="form-control border-input" placeholder="请输入用户ID">
											</div>
										</div>									
										<div class="col-md-2">
											<label for="exampleInputEmail1">查找用户</label>
                                   			<button class="btn btn-default btn-block" type="submit">查询用户</button>
                                		</div>                               										
								</form>
							</div>
						</div>

                        <s:form action = "UMCAction" method="post">
                        <s:iterator value="umclist" var="user" >
						<div class="col-lg-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">用户信息</h4>
                            </div>
                            <div class="content">
                                <form>
                                    <div class="row">
                                         <input type="hidden" class="form-control border-input" name="userid"  placeholder="ID" value="<%=((TUser)request.getAttribute("umcuser")).getId() %>" >
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>登录账号</label>
                                                <input type="text" class="form-control border-input" name="regname"  placeholder="Regname" value="<%=((TUser)request.getAttribute("umcuser")).getRegname() %>">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>用户姓名</label>
                                                <input type="text" class="form-control border-input" name="name"  placeholder="Username" value="<%=((TUser)request.getAttribute("umcuser")).getName() %>">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>论坛昵称</label>
                                                <input type="text" class="form-control border-input" name="nickname"  placeholder="Nickname" value="<%=((TUser)request.getAttribute("umcuser")).getNickname() %>">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>注册时间</label>
                                                <input type="text" class="form-control border-input" name="regdate" placeholder="Regdate" value="<%=((TUser)request.getAttribute("umcuser")).getRegdate() %>">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>最后登录</label>
                                                <input type="text" class="form-control border-input" name="logdate" placeholder="Logdate" value="<%=((TUser)request.getAttribute("umcuser")).getLogdate() %>">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label >电子邮箱</label>
                                                <input type="text" class="form-control border-input" name="email" placeholder="email" value="<%=((TUser)request.getAttribute("umcuser")).getEmail() %>">
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>签名档</label>
                                                <input type="text" class="form-control border-input" name="signature" placeholder="signature" value="<%=((TUser)request.getAttribute("umcuser")).getSignature() %>">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>所在城市</label>
                                                <input type="text" class="form-control border-input" name="city" placeholder="City" value="<%=((TUser)request.getAttribute("umcuser")).getCity() %>">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>联系电话</label>
                                                <input type="text" class="form-control border-input" name="telephone" placeholder="telephone" value="<%=((TUser)request.getAttribute("umcuser")).getTelphone() %>">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>电话</label>
                                                <input type="text" class="form-control border-input" name="phone" placeholder="Phone" value="<%=((TUser)request.getAttribute("umcuser")).getPhone() %>">
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>论坛积分</label>
                                                <input type="text" class="form-control border-input" name="point" placeholder="point" value="<%=((TUser)request.getAttribute("umcuser")).getPoint() %>">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>查看数</label>
                                                <input type="text" class="form-control border-input" name="watch" placeholder="watch" value="<%=((TUser)request.getAttribute("umcuser")).getWatch() %>">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>发帖数</label>
                                                <input type="text" class="form-control border-input" name="post" placeholder="post" value="<%=((TUser)request.getAttribute("umcuser")).getPost() %>">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>自我介绍</label>
                                                <textarea rows="5" class="form-control border-input" name="content" placeholder="About youself" ><s:property value="#user.content"/></textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="text-center">
                                        <button type="submit" class="btn btn-info btn-fill btn-wd">修改信息</button>
                                    </div>                             
                                </form>
                            </div>
                        </div>
                    </div>
                    </s:iterator>
                    </s:form>


                </div>
            </div>
        </div>
						

    </div>
</div>


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
</html>