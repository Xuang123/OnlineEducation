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

<title>社区用户资料</title>

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
<script type="text/javascript">
	window.onload = function() {
		var showflag = document.getElementById("showflag").value;
		if (showflag.charAt(0) == '0') {
			$("#phone").hide();
		}
		if (showflag.charAt(1) == '0') {
			$("#email").hide();
		}
	}
</script>
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
               
					<li class="active"><s:a action="fuserinfo">
							<i class="ti-pin-alt"></i>
							<p>个人资料</p>
						</s:a></li>
					<li ><s:a action="frmsgget">
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
								</ul></li>
						</ul>
					</div>
				</div>
			</nav>

			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-4 col-md-5">
							<div class="card card-user">
								<div class="image">
									<img src="assets/img/background.jpg" alt="..." />
								</div>
								<div class="content">
									<div class="author">
										<img class="avatar border-white"
											src="assets/img/faces/face-2.jpg" alt="..." />
										<h4 class="title">
											<s:property value="fuserinfo.nickname" />
											<br /> <small id="userstatus"></small>
										</h4>
									</div>
									<p class="description text-center">
										<s:property value="fuserinfo.signature" />
									</p>
								</div>
								<hr>
								<div class="text-center">
									<div class="row">
										<div class="col-md-3 col-md-offset-1">
											<h5>
												<s:property value="fuserinfo.post" />
												<br /> <small>文章数</small>
											</h5>
										</div>
										<div class="col-md-4">
											<h5>
												<s:property value="fuserinfo.watch" />
												<br /> <small>人气</small>
											</h5>
										</div>
										<div class="col-md-3">
											<h5>
												<s:property value="fuserinfo.point" />
												<br /> <small>积分</small>
											</h5>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-8 col-md-7">
							<div class="card">
								<div class="content">
									<div class="row">
										<div class="col-md-6">
											<label>账号</label>
											<p class="well" name="regname">
												<s:property value="fuserinfo.regname" />
											</p>
										</div>
										<div class="col-md-6">
											<label>昵称</label>
											<p class="well" name="nickname">
												<s:property value="fuserinfo.nickname" />
											</p>
										</div>
									</div>
									<div class="row">
										<div class="col-md-6">
											<label>姓名</label>
											<p class="well" name="name">
												<s:property value="fuserinfo.name" />
											</p>
										</div>
										<div class="col-md-6" id="email">
											<label for="exampleInputEmail1">Email</label>
											<p class="well" name="email">
												<s:property value="fuserinfo.email" />
											</p>
										</div>
									</div>
									<div class="row" id="phone">
										<div class="col-md-6">
											<label>移动电话</label>
											<p class="well" name="telphone">
												<s:property value="fuserinfo.telphone" />
											</p>
										</div>
										<div class="col-md-6">
											<label>座机电话</label>
											<p class="well" name="phone">
												<s:property value="fuserinfo.phone" />
											</p>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-12">
											<label>地址</label>
											<p class="well" name="city">
												<s:property value="fuserinfo.city" />
											</p>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12">
											<label>关于我</label>
											<p class="well" name="content">
												<s:property value="fuserinfo.content" />
											</p>
										</div>
									</div>
									<div>
										<input type="hidden" name="showflag" id="showflag"
											value=<s:property value="fuserinfo.showflag" />>
									</div>
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
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js"></script>

<!-- Paper Dashboard Core javascript and methods for Demo purpose -->
<script src="assets/js/paper-dashboard.js"></script>

<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
<script src="assets/js/demo.js"></script>

</html>
