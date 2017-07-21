<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>收信箱</title>

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
               
					<li><s:a action="fuserinfo">
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


		<div class="main-panel">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar bar1"></span> <span class="icon-bar bar2"></span>
							<span class="icon-bar bar3"></span>
						</button>
						<a class="navbar-brand">互动社区</a>
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
						<div class="col-md-12">
							<div class="card">
								<div class="content">
									<div class="row">
										<div class="col-md-12">
											<ul class="nav nav-pills">
												<li class="active"><s:a action="frmsgget">收信箱</s:a></li>
												<li><s:a action="fsmsgget">发信箱</s:a></li>
												<li><s:a href="fmsgwrite.jsp">写信</s:a></li>
											</ul>
										</div>
									</div>
								</div>
							</div>
							<div class="card card-plain">
								<div class="header">
									<h4 class="title"></h4>
								</div>
								<div class="content table-responsive table-full-width">
									<table class="table table-hover">
										<thead>
											<th></th>
											<th>发信人</th>
											<th>发信时间</th>
											<th>标题</th>
										</thead>
										<tbody>
											<s:iterator value="list" var="rmsg">
												<tr>
													<td><s:if test="#rmsg.flag == 0">
															<i id="cicon" class="ti-comment"></i>
														</s:if></td>
													<td><s:property value="#rmsg.TUserBySendId.regname" /></td>
													<td><s:property value="#rmsg.senddate" /></td>
													<td><s:url action="frmsginfo" var="infourl">
															<s:param name="msgid">
																<s:property value="#rmsg.id" />
															</s:param>
														</s:url> <s:a href="%{infourl}">
															<s:property value="#rmsg.name" />
														</s:a></td>
												</tr>
											</s:iterator>
										</tbody>
									</table>
								</div>
							</div>
							<div class="card">
								<div class="content">
									<div class="row">
										<div class="col-md-2">
											<p>
												共
												<s:property value="page.ye" />
												页/
												<s:property value="page.totel" />
												条记录
											</p>
										</div>
										<div class="col-md-3">
											<ul class="pagination">
												<li><s:url action="frmsgget" var="preurl">
														<s:param name="con">0</s:param>
														<s:param name="nowye">
															<s:property value="page.ye" />
														</s:param>
													</s:url> <s:a href="%{preurl}">
														<i class="ti-angle-left"></i>
													</s:a></li>
												<li><a href="#"><s:property value="page.ye" /></a></li>
												<li><s:url action="frmsgget" var="nexturl">
														<s:param name="con">1</s:param>
														<s:param name="nowye">
															<s:property value="page.ye" />
														</s:param>
													</s:url> <s:a href="%{nexturl}">
														<i class="ti-angle-right"></i>
													</s:a></li>
											</ul>
										</div>
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
