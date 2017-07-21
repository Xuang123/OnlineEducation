<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>山东大学在线教育平台</title>

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
	<style>
	ul.pagination {
		display: inline-block;
		padding: 0;
		margin: 0;
	}
	
	ul.pagination li {
		display: inline;
	}
	
	ul.pagination li a {
		color: black;
		float: left;
		padding: 8px 16px;
		text-decoration: none;
		transition: background-color .3s;
		border: 1px solid #ddd;
		font-size: 18px;
	}
	
	ul.pagination li a.active {
		background-color: #eee;
		color: black;
		border: 1px solid #ddd;
	}
	
	ul.pagination li a:hover:not (.active ) {
		background-color: #ddd;
	}
	div.center {text-align: center;}
	</style>
	<script type="text/javascript" src="jquery.1.4.2-min.js"></script>
	<script type="text/javascript">
// 		function addConfirm(cid){
// 			var msg="是否确定从所有课程中增加该课程?";
// 			if(confirm(msg)==true){
// 				window.location.href="AMCaction.action?cid="+cid;
				
// 				alert(s);
// 				if(s=="0"){
// 					alert("添加课程成功");
// 				}else if(s=="1"){
// 					alert("课程已经存在");
// 				}
									
// 			}else{
// 				location.href="DMCaction.action?cid=";
// 				return false;
// 			}
// 		}
		function addConfirm(cid){
			$.ajax({
				type:"post",
				url:"EDU/ACCaction",
				data:"cid="+cid,
				success:function(msg){
					if(msg=="exist"){
						alert("课程已经存在");
					}else{
						var msg="是否确定从所有课程中增加该课程?";
						if(confirm(msg)==true){
							window.location.href="AMCaction.action?cid="+cid;
							alert("添加课程成功");
						}
					}
				}
				,error:function(){
					alert("error");
				}
			});
		}
	</script>
	
</head>
<body>

<div class="wrapper">
	<div class="sidebar" data-background-color="white" data-active-color="danger">

    <!--
		Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
		Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
	-->

  <div class="sidebar-wrapper">
            <div class="logo">
                <a href="/EDU/dashboard.jsp" class="simple-text">
                  假装这里有logo
                </a>
            </div>

            <ul class="nav">
                       		<li>
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
                <li class="active">
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
                    <a class="navbar-brand" >山东大学在线教育平台-课程中心</a>
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
							<div class="card" id = "searchDiv">
								<div class="header">
									<h4 class="title">选择课程</h4>
									<p class="category">Search Lessons</p>
								</div>
								<s:form action = "SSCaction" namespace="/">
								
										<div class="col-md-3">
											<div class="form-group">
												<label>课程名称</label> 
												<input name="name",type="text"
													class="form-control border-input" placeholder="请输入课程号">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label>发布单位</label> 
												<input name ="company",type="text"
													class="form-control border-input" placeholder="请输入课程发布单位">
											</div>
										</div>
										<div class="col-md-3">
											<div class="form-group">
												<label for="exampleInputEmail1">课程类型</label> 
												<input	name="type",type="email" class="form-control border-input"
													placeholder="课程类型">
											</div>
										</div>
										<div class="col-md-2">
											<label for="exampleInputEmail1">查找课程</label>
                                   			<button class="btn btn-default btn-block" id="searchButton">搜索课程</button>
                                		</div>
									
								</s:form>
							</div>
						</div>



						<div class="col-md-12">
							<div class="card card-plain">
								<div class="header">
									<h4 class="title">搜索结果</h4>
									<p class="category">Search Results</p>
								</div>
								<div class="content table-responsive table-full-width">
									<table class="table table-hover">
										<thead>
											<th>课程名称</th>
											<th>课程类型</th>
											<th>创建者名称</th>
											<th>发布单位</th>
											<th>发布时间</th>
											<th>添加</th>
										</thead>
										<tbody>
										<s:iterator value="list" var="course" >
											<tr>
												<td><s:property value="#course.name"/></td>
												<td><s:property value="#course.type"/></td>
												<td><s:property value="#course.author"/></td>
												<td><s:property value="#course.company"/></td>
												<td><s:date name="#course.distributeDate" format="yyyy-MM-dd"/></td>
												<td><a href="#" onclick="addConfirm(<s:property value="#course.id"/>)"><span class="ti-check"/></a></td>
											</tr>
										</s:iterator>
										</tbody>
										
									</table>
									<div class="center">
										<ul class="pagination">
											<s:iterator value="pagelist" var="page">
												<li>
													<s:if test="#page == currentPage">
														<a href="PGCaction.action?pno=<s:property value="#page"/>" class="active"><s:property value="#page"/></a>
													</s:if>
													<s:else>
<!-- 														<a herf="<s:url action="PGCaction.action"> <s:param name="pno" value="#page"/></s:url>"><s:property value="#page"/></a> -->
														<a href="PGCaction.action?pno=<s:property value="#page"/>"><s:property value="#page"/></a>
													</s:else>
												</li>
											</s:iterator>
										</ul>
									</div>
									
								</div>
							</div>
						</div>
						

					</div>
				</div>
			</div>

				</div>
			</div></body>

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
