<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:useBean id="dbforum" class="dao.DBoperator" />
<!doctype html>
<html lang="en">
<head>
<link rel="apple-touch-icon" sizes="76x76"
	href="assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link href="assets/css/forum.css" rel="stylesheet">


<!-- Bootstrap core CSS     -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />

<!-- Animation library for notifications   -->
<link href="assets/css/animate.min.css" rel="stylesheet" />

<!--  Paper Dashboard core CSS    -->
<link href="assets/css/paper-dashboard.css" rel="stylesheet" />


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
					<a href="#" class="simple-text"> 互动社区 </a>
				</div>

				<ul class="nav">

					<li><a href="forum.jsp"> <i class="ti-comments"></i>
							<p>论坛首页</p>
					</a></li>


					<li class="active"><a href="newtopic.jsp"> <i
							class="ti-target"></i>
							<p>最新话题</p>
					</a></li>
					<li><s:a action="fuserinfo">
							<i class="ti-pin-alt"></i>
							<p>个人资料</p>
						</s:a></li>
					<li><s:a action="frmsgget">
							<i class="ti-email"></i>
							<p>短信中心</p>
						</s:a></li>
					<li>
					<li><a href="UserMassage.jsp?id=30"> <i
							class="ti-view-list-alt"></i>
							<p>返回用户界面</p>
					</a></li>
				</ul>
			</div>
		</div>

		<div class="main-panel">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<div class="navbar-header"></div>
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <i class="ti-user"></i>
									<p id="srname">
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

				<%
					Connection conn = dbforum.getConn();

					String sql = "select  a.nickname,b.nickname,p.name ,publishDate,viewcount,p.content,b.id"
							+ " from t_post as p,t_user as a,t_user as b where"
							+ "  userId=a.id and reUserId=b.id and p.id=p.pid order by publishDate desc limit 10";

					ResultSet rs = dbforum.Statementexcute(sql);
				%>

				<div>
					最新话题
					<table id="forum_main" cellspacing="1">
						<thead class="background:#DDDDDD">
							<tr>


								<td colspan="2" class="first_col" style="width: 620px;">话题</td>
								<td class="first_col" style="width: 60px;">发起人</td>
								<td class="first_col" style="width: 60px;">观看量</td>
								<td class="first_col" style="width: 180px;">最后发表</td>
							</tr>
						</thead>
						<tbody>
							<%
								while (rs.next()) {
									String intend = "post.jsp?name=" + rs.getString(3);
							%>


							<tr>
								<td class="read_forum"></td>
								<td class="forum_description"><a href='<%=intend%>'
									class="forumtitle"><%=rs.getString(3)%></a><br /> <%=rs.getString(6)%><br /></td>
								<td class="forum_index"><%=rs.getString(1)%></td>
								<td class="forum_index"><%=rs.getString(5)%></td>
								<td class="forum_index"><%=rs.getString(4)%><br /> <s:url
										action="fotheruserinfo" var="infourl">
										<s:param name="uid">
											<%=rs.getString(7)%>
										</s:param>
									</s:url> <s:a href="%{infourl}">
										<%=rs.getString(2)%>
									</s:a>

								</td>
							</tr>
							<%
								}
								rs.close();
							%>
						</tbody>
					</table>

				</div>




			</div>


		</div>



	</div>




	<footer class="footer">
		<div class="container-fluid">
			<nav class="pull-left"></nav>

		</div>
	</footer>

	</div>

	<%
		rs.close();
		conn.close();
	%>
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

</html>

