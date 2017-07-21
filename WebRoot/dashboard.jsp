<%@page import="org.hibernate.SessionFactory"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html lang="cmn">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>用户中心</title>

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

	 <script src="jquery-3.0.0.js" type="text/javascript"></script>
    <script type="text/javascript">
        function checkbox_trans(){
        	var ks_cj = "";
        	var temp = "";
        	var a = document.getElementsByName("ks_cj");
        	for(var i = 0;i < a.length;i++){
        		if(a[i].checked){
        			temp = a[i].value;
					ks_cj = ks_cj + "," + temp;
        		}
        	}
        	if(ks_cj == "") alert("请至少选择一门考试");
        	else window.location.href="doSearch_in_table?ks_cj="+ks_cj;    
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
                    你好
                </a>
            </div>

            <ul class="nav">
                <li>
                    <a href="UserMassage.jsp?id=<s:property value = "userId"/>">
                        <i class="ti-map"></i>
                        <p>个人信息</p>
                    </a>
                </li>
                <li>
                    <a href="UserManage.jsp?id=<s:property value = "userId"/>">
                        <i class="ti-user"></i>
                        <p>用户查找</p>
                    </a>
                </li>
               	<li  class="active">
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
    <div class="copyrights">Collect from <a href="http://www.cssmoban.com/"  title="ç½ç«æ¨¡æ¿">ç½ç«æ¨¡æ¿</a></div>

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
                    <a class="navbar-brand" href="#">用户主页</a>
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
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="content">
                                <div class="row">
                                    <div class="col-xs-5">
                                        <div class="icon-big icon-warning text-center">
                                            <i class="ti-server"></i>
                                        </div>
                                    </div>
                                    <div class="col-xs-7">
                                        <div class="numbers">
                                            	<p>已参加考试</p>
                                            	<s:property value = "count"/>门
                                        </div>
                                    </div>
                                </div>
                                <div class="footer">
                                    <hr />
                                    <div class="stats">
                                        <i class="ti-reload"></i> 
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="content">
                                <div class="row">
                                    <div class="col-xs-5">
                                        <div class="icon-big icon-success text-center">
                                            <i class="ti-wallet"></i>
                                        </div>
                                    </div>
                                    <div class="col-xs-7">
                                        <div class="numbers">
                                            <p>已通过考试</p>
                                            <s:property value = "pass"/>门
                                        </div>
                                    </div>
                                </div>
                                <div class="footer">
                                    <hr />
                                    <div class="stats">
                                        <i class="ti-calendar"></i> Last day
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="content">
                                <div class="row">
                                    <div class="col-xs-5">
                                        <div class="icon-big icon-danger text-center">
                                            <i class="ti-pulse"></i>
                                        </div>
                                    </div>
                                    <div class="col-xs-7">
                                        <div class="numbers">
                                            <p>通过率</p>
                                            <s:property value = "ratio"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="footer">
                                    <hr />
                                    <div class="stats">
                                        <i class="ti-timer"></i> In the last hour
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="content">
                                <div class="row">
                                    <div class="col-xs-5">
                                        <div class="icon-big icon-info text-center">
                                            <i class="ti-eye"></i>
                                        </div>
                                    </div>
                                    <div class="col-xs-7">
                                        <div class="numbers">
                                            <p>即将开始的考试</p>
                                            <s:property value = "exam_be"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="footer">
                                    <hr />
                                    	<a href = "exam.jsp">
                                        <i class="ti-target"></i> 去看看
                                        </a> 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="ti-control-stop ">tourist</h4>   
                                <p class="category"></p>
                            </div>
                            <div class = "col-md-3"></div>
                            <div class = "col-md-4"></div>
                            <div class = "col-md-3"></div>
                             <div class = "col-md-2">
									<button type="submit" class="btn btn-default btn-block" onclick="checkbox_trans()">查询成绩</button>
							</div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-striped">
                                    <thead>
                                    	<th></th>
                                        <th>考试时间</th>
                                    	<th>考试名称</th>
                                    	<th>开始时间</th>
                                    	<th>结束时间</th>
                                    	<th>得分</th>
                                    </thead>
                                    </tbody>
                                    <%String value = request.getParameter("userId"); %>
									<s:iterator value="list" var="c">
										<tr>
										<td>
										<input type = "checkbox" class = "checkboxes" name = "ks_cj" value = <s:property value = "#c.TExam.id +':'+ #c.TUser.id"/>>
										</td>
										 <td><s:property value = "#c.takeDate"/></td>
										 <td><s:property value = "#c.TExam.getName()"/></td>
										 <td><s:property value = "#c.TExam.startDate"/></td>
										 <td><s:property value = "#c.TExam.endDate"/></td>
										 <td><s:property value = "#c.kscore+#c.zscore"/></td>
										</tr>
									</s:iterator>
									</tbody>
                                </table>

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

	<script type="text/javascript">
    	$(document).ready(function(){

        	demo.initChartist();

        	$.notify({
            	icon: 'ti-gift',
            	message: "欢迎进入考试中心."

            },{
                type: 'success',
                timer: 4000
            });

    	});
	</script>

</html>
