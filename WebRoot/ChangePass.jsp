<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title> 个人前台-密码修改</title>

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
     <link href="assets/css/ChangePass.css" rel="stylesheet">

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
                <a href="/EDU/dashboard.jsp" class="simple-text">
                    这里是logo
                </a>
            </div>

            <ul class="nav">
                <li >
                    <a href="dashboard.jsp">
                        <i class="ti-panel"></i>
                        <p>课程中心</p>
                    </a>
                </li>
                
            	<li class="active">
                    <a href="user.jsp">
                        <i class="ti-user"></i>
                        <p>个人信息</p>
                    </a>
                    </li>
           
                <li>
                    <a href="table.jsp">
                        <i class="ti-view-list-alt"></i>
                        <p>选择课程</p>
                    </a>
                </li>
                <li>
                    <a href="typography.jsp">
                        <i class="ti-text"></i>
                        <p>Typography</p>
                    </a>
                </li>
                <li>
                    <a href="icons.jsp">
                        <i class="ti-pencil-alt2"></i>
                        <p>Icons</p>
                    </a>
                </li>
                <li>
                    <a href="maps.jsp">
                        <i class="ti-map"></i>
                        <p>Maps</p>
                    </a>
                </li>
                <li>
                    <a href="notifications.jsp">
                        <i class="ti-bell"></i>
                        <p>Notifications</p>
                    </a>
                </li>
				<li class="active-pro">
                    <a href="upgrade.jsp">
                        <i class="ti-export"></i>
                        <p>Upgrade to PRO</p>
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
                    <a class="navbar-brand" href="table.jsp">山东大学在线教育平台——修改密码</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="ti-panel"></i>
								<p>Stats</p>
                            </a>
                        </li>
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="ti-bell"></i>
                                    <p class="notification">5</p>
									<p>个人中心</p>
									<b class="caret"></b>
                              </a>
                              <ul class="dropdown-menu">
                                <li><a href="#">Notification 1</a></li>
                                <li><a href="#">Notification 2</a></li>
                                <li><a href="#">Notification 3</a></li>
                                <li><a href="#">Notification 4</a></li>
                                <li><a href="#">Another notification</a></li>
                              </ul>
                        </li>
						<li>
                            <a href="#">
								<i class="ti-settings"></i>
								<p>设置</p>
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
                                <h4 class="title">密码修改</h4>
                            </div>
                            <div class="content">
                              
                                <s:form action="ChangePass" mehod="post">
									<input type="hidden" class="form-control border-input" name="id"  placeholder="ID" value="20" >
               						<div class="Content-ChangPass">
                                    <div class="row">
                                         <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="exampleInputEmail1">初始密码</label>
                                                <input type="text" name="password"class="form-control border-input" placeholder="请输入原密码">
                                            </div>
                                        </div>
                                    </div>
                                
                                    <div class="row">
                                    
                                    
                                         <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="exampleInputEmail1">新密码</label>
                                                <input type="password" name="newpassword" class="form-control border-input" placeholder="请输入新密码">
                                            </div>
                                        </div>
                                    </div>
                                   
                                      <div class="row">
                                         <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="exampleInputEmail1">确认新密码</label>
                                                <input type="password" name="confirmpassword" class="form-control border-input" placeholder="请确认新密码">
                                            </div>
                                        </div>
                                    </div>
                                    </div>
                                  
                                    <div class="text-center">
                                        <button type="submit" class="btn btn-info btn-fill btn-wd">确认修改</button>
                                    </div>
                                
                                    <div class="clearfix"></div>
                                </s:form>
                            </div>
                        </div>
                    </div>


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
