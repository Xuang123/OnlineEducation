<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.entity.TUser,java.util.*"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>消息内容</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />


<!-- Bootstrap core CSS     -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />

<!-- Animation library for notifications   -->
<link href="assets/css/animate.min.css" rel="stylesheet" />

<!--  Paper Dashboard core CSS    -->
<link href="assets/css/paper-dashboard.css" rel="stylesheet" />

<!--  CSS for Demo Purpose, don't include it in your project     -->
<link href="assets/css/demo.css" rel="stylesheet" />

<!--  Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Muli:400,300'
	rel='stylesheet' type='text/css'>
<link href="assets/css/themify-icons.css" rel="stylesheet">
</head>
<body>
	<div class="wrapper">
		<div class="sidebar" data-background-color="white"
			data-active-color="danger">

			<!--
		Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
		Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
	-->

			<div class="sidebar-wrapper">
				<div class="logo">
					<a href="/EDU/dashboard.jsp" class="simple-text"> 这里是logo </a>
				</div>

				<ul class="nav">
										<li >
                    <a href="forum.jsp">
                        <i class="ti-comments"></i>
                        <p>论坛首页</p>
                    </a>
                </li>
             
              
                <li>
                    <a href="newtopic.jsp">
                        <i class="ti-target"></i>
                        <p>最新话题</p>
                    </a>
                </li>
               
					<li ><s:a action="fuserinfo">
							<i class="ti-pin-alt"></i>
							<p>个人资料</p>
						</s:a></li>
					<li class="active"><s:a action="frmsgget">
							<i class="ti-email"></i>
							<p>短信中心</p>
						</s:a></li>
					 <li>
                    <a href="UserMassage.jsp?id=30">
                        <i class="ti-view-list-alt"></i>
                        <p>返回用户界面</p>
                    </a>
                </li>
				</ul>
			</div>
		</div>
		<div class="copyrights">
			Collect from <a href="http://www.cssmoban.com/" title="edu">edu</a>
		</div>

		<div class="main-panel">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar bar1"></span> <span class="icon-bar bar2"></span>
							<span class="icon-bar bar3"></span>
						</button>
						<p class="navbar-brand">互动社区</p>
					</div>
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <i class="ti-user"></i>
									<p>
										<s:property value="#session.forumuser.regname" />
									</p> <b class="caret"></b>
							</a>
								<ul class="dropdown-menu">
									<li><s:a action="fuserinfoedit">修改资料</s:a></li>
									<li><s:a action="loginout">退出</s:a></li>
						</ul>
					</div>
				</div>
			</nav>

			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-8 col-md-7">
							<div class="card">
								<div class="content">
									<div class="row">
										<div class="col-md-12">
											<ul class="nav nav-pills">
												<li><s:a action="frmsgget">收信箱</s:a></li>
												<li class="active"><s:a action="fsmsgget">发信箱</s:a></li>
												<li><s:a href="fmsgwrite.jsp">写信</s:a></li>
											</ul>
										</div>
									</div>
								</div>
							</div>
							<div class="card">
								<div class="content">
									<form action="fmsgdelete">
										<div class="row">
											<div class="col-md-12">
												<label>收信人</label>
												<p class="well" name="regname">
													<s:property value="fmsginfo.TUserByReceiveId.regname" />
												</p>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12">
												<label>发信时间</label>
												<p class="well" name="senddate">
													<s:property value="fmsginfo.senddate" />
												</p>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12">
												<label>标题</label>
												<p class="well" name="name">
													<s:property value="fmsginfo.name" />
												</p>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12">
												<label>内容</label>
												<p class="well" name="content">
													<s:property value="fmsginfo.content" />
												</p>
											</div>
										</div>
										<div>
											<input type="hidden" name="id"
												value=<s:property value="fmsginfo.id" />>
											<input type="hidden" name="wei"
												value=<s:property value="0" />>
										</div>
										<div class="text-center">
											<button type="submit" class="btn btn-info btn-fill btn-wd">删除</button>
										</div>
										<div class="clearfix"></div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>


			<footer class="footer">
				<div class="container-fluid">
				</div>
			</footer>

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
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js"></script>

<!-- Paper Dashboard Core javascript and methods for Demo purpose -->
<script src="assets/js/paper-dashboard.js"></script>

<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
<script src="assets/js/demo.js"></script>

</html>
