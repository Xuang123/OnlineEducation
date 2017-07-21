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
	
	<script type="text/javascript" language="javascript">
		
		function deltConfirm(cid){
			var msg="是否确定从已选课程中删除该课程？删除操作不可恢复 ";
			if(confirm(msg)==true){
				window.location.href="DMCaction.action?cid="+cid;
				alert("删除课程成功");
			}else{
// 				location.href="DMCaction.action?cid=";
				return false;
			}
		}
		function openCourse(dataurl){
			OpenWindow=window.open("courseVedio", "", "height=500, width=850,left=50,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no")
			OpenWindow.document.write("<title>课程视频</title>");
    		OpenWindow.document.write("<body >");
    
		    OpenWindow.document.write("<div>");
		    OpenWindow.document.write("<embed src='"+dataurl+"' allowFullScreen='true' quality='high' width='800' height='450' align='middle' allowScriptAccess='always' type='application/x-shockwave-flash'></embed>");
		    OpenWindow.document.write("</div>");
		    OpenWindow.document.write("</body>");
		    
		    OpenWindow.document.write("</html>");
		    
		    OpenWindow.document.close();
		    
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
                <li>
                    <a href="SSCaction.action">
                        <i class="ti-pencil-alt2"></i>
                        <p>选择课程</p>
                    </a>
                </li>
                <li class="active">
                    <a href="SMCaction.action">
                        <i class="ti-view-list-alt"></i>
                        <p>我的课程</p>
                    </a>
                </li>
                <li>
                    <a href=forum_login.jsp>
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
									<h4 class="title">我的课程</h4>
									<p class="category">My Courses</p>
								</div>
								<s:form action = "SMCaction" namespace="/">
								
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
                                   			<button class="btn btn-default btn-block" id="searchButton">查找已选课程</button>
                                		</div>
									
								</s:form>
							</div>
						</div>



						<div class="col-md-12">
							<div class="card card-plain">
								<div class="header">
									<h4 class="title">已选课程</h4>
									<p class="category">Chosen Courses</p>
								</div>
								<div class="content table-responsive table-full-width">
									<table class="table table-hover">
										<thead>
											<th>课程名称</th>
											<th>课程类型</th>
											<th>创建者名称</th>
											<th>发布单位</th>
											<th>考试时间</th>
											<th>删除</th>
										</thead>
										<tbody>
										<s:iterator value="mylist" var="course" >
											<tr>
												<td><a href="#" onclick="openCourse('<s:property value="#course.dataurl"/>');"><s:property value="#course.name"/></a></td>
												<td><s:property value="#course.type"/></td>
												<td><s:property value="#course.author"/></td>
												<td><s:property value="#course.company"/></td>
												<td><a href="#" onclick="" ><s:date name="#course.distributeDate" format="yyyy-MM-dd"/></a></td>
												<td><a href="#" onclick="deltConfirm(<s:property value="#course.id"/>);"><span class="ti-close"/></a></td>
											</tr>
											
										</s:iterator>
										</tbody>
										
									</table>
									<div class="center">
										<ul class="pagination">
											<s:iterator value="pagelist" var="page">
												<li>
													<s:if test="#page == currentPage">
														<a href="MPGaction.action?pno=<s:property value="#page"/>" class="active"><s:property value="#page"/></a>
													</s:if>
													<s:else>
<!-- 														<a herf="<s:url action="PGCaction.action"> <s:param name="pno" value="#page"/></s:url>"><s:property value="#page"/></a> -->
														<a href="MPGaction.action?pno=<s:property value="#page"/>"><s:property value="#page"/></a>
													</s:else>
												</li>
											</s:iterator>
										</ul>
									</div>
									
								</div>
							</div>
						</div>
<!-- 						<div class="col-md-12"> -->
<!-- 							<div class="card card-plain"> -->
<!-- 								<div class="header"> -->
<!-- 									<h4 class="title">已选课程</h4> -->
<!-- 									<p class="category">Chosen Lessons</p> -->
<!-- 								</div> -->
<!-- 								<div class="content table-responsive table-full-width"> -->
<!-- 									<table class="table table-hover"> -->
<!-- 										<thead> -->
<!-- 											<th>课程名称</th> -->
<!-- 											<th>课程类型</th> -->
<!-- 											<th>创建者名称</th> -->
<!-- 											<th>发布单位</th> -->
<!-- 											<th>操作</th> -->
<!-- 										</thead> -->
<!-- 										<tbody> -->
<!-- 										<s:iterator value="mylist" var="course" > -->
<!-- 											<tr> -->
<!-- 												<td><s:property value="#course.name"/></td> -->
<!-- 												<td><s:property value="#course.type"/></td> -->
<!-- 												<td><s:property value="#course.author"/></td> -->
<!-- 												<td><s:property value="#course.company"/></td> -->
<!-- 												<td><span class="ti-close"></span></td> -->
<!-- 											</tr> -->
<!-- 										</s:iterator> -->
<!-- 										</tbody> -->
<!-- 									</table> -->
<!-- 									<div class="center"> -->
<!-- 										<ul class="pagination"> -->
<!-- 										<s:iterator value="{'1','2'}" var="page"> -->
<!-- 											<li><a href="#"> -->
<!-- 											<s:property value="#page"/></a></li> -->
<!-- 										</s:iterator> -->
<!-- 										</ul> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->

					</div>
				</div>
			</div>

<!-- 			<footer class="footer"> -->
<!-- 						<div class="container-fluid"> -->
<!-- 							<nav class="pull-left"> -->
<!-- 								<ul> -->

<!-- 									<li><a href="#"> Creative Tim </a></li> -->
<!-- 									<li><a href="http://blog.creative-tim.com"> Blog </a></li> -->
<!-- 									<li><a href="#/license"> Licenses </a></li> -->
<!-- 								</ul> -->
<!-- 							</nav> -->
<!-- 							<div class="copyright pull-right"> -->
<!-- 								&copy; -->
<%-- 								<script>document.write(new Date().getFullYear())</script> --%>
<!-- 								, made with <i class="fa fa-heart heart"></i> by <a href="#">Creative -->
<!-- 									Tim</a>. More Templates <a href="http://www.cssmoban.com/" -->
<!-- 									target="_blank" title="æ¨¡æ¿ä¹å®¶">æ¨¡æ¿ä¹å®¶</a> - Collect -->
<!-- 								from <a href="http://www.cssmoban.com/" title="ç½é¡µæ¨¡æ¿" -->
<!-- 									target="_blank">ç½é¡µæ¨¡æ¿</a> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</footer> -->


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
