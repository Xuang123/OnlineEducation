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

	<title>考试中心</title>

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

	<!-- Calender CSS from JQuery Template -->
	<link rel="stylesheet" href="assets/css/dcalendar.picker.css"/>

	
	
    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="assets/css/themify-icons.css" rel="stylesheet">

		<script type="text/javascript" language = "JavaScript">
        function exam_search(){  	
        	var a = document.getElementsByName("name");
        	var b = document.getElementsByName("startdate");
        	var c = document.getElementsByName("enddate");
        	<!-- var d = document.getElementsByName("userId"); -->
        	//用户id,测试固为30
        	<!--alert(d[0].value);var Exam_n_s_e = "~" + d[0].value + "_~";-->
        	var Exam_n_s_e = "~30_~";
        	
        	Exam_n_s_e = Exam_n_s_e + a[0].value + "_~";
        	Exam_n_s_e = Exam_n_s_e + b[0].value + "_~";
        	Exam_n_s_e = Exam_n_s_e + c[0].value;
        	window.location.href="doSearch_exam?Exam_n_s_e=" + Exam_n_s_e;    
        }
        
        function findpaper(c){  	
        	window.location.href="doSearch_paper?Exam_id=" + c;    
        }
    </script>
	

</head>
<body>

<input type = "hide" value = <s:property value = "userId"/> name = "userId">
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
               	<li >
                    <a href="doSearch?userId=<s:property value = "userId"/>">
                        <i class="ti-panel"></i>
                        <p>考试信息总览</p>
                    </a>
                </li>
                <li class="active">
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
                    <a class="navbar-brand" href="#">考试中心</a>
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
       <div class="col-md-12">
                        <div class="card">
        <div class="header">
             <h4 class="title">查询你的考试</h4>
        </div>
       <div class = "row">
       <div class="col-md-1"></div>
        <div class="col-md-4">
            <div class="form-group">
                 <label>考试名称</label>
                      <input type="text" name = "name" class="form-control border-input" placeholder="输入考试科目查询"  value = <s:property value = "name"/> >
              </div>
        </div>
        <div class="col-md-4">
            <div class="form-group">
                 <label>考试时间</label>
                     <input type="date" name = "startdate" class="form-control border-input" value = <s:property value = "start"/>>到
              
           	  <input type="date" name = "enddate" class="form-control border-input" value = <s:property value = "end"/>>
        	</div>
        </div>
        
        </div>
        	 <div class="text-center">
                 <button type="submit" class="btn btn-info btn-fill btn-wd" onclick="exam_search()">考试查询</button>  
        </div>   
        </div>     
        </div>

        
         <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">      
       <div class="content table-responsive table-full-width">
                                <table class="table table-striped">
                                    <thead>
                                        <th>考试时间</th>
                                    	<th>考试科目</th>
                                    	<th>开始时间</th>
                                    	<th>结束时间</th>
                                    	<th>已参加次数</th>
                                    	<th> </th>
                                    </thead>
                                    </tbody>
                                    <%String value = request.getParameter("userId"); %>
									<s:iterator value="list" var="c">
										<tr>
										 <td><s:property value = "#c.takeDate"/></td>
										 <td><s:property value = "#c.TExam.name"/></td>
										 <td><s:property value = "#c.TExam.startDate"/></td>
										 <td><s:property value = "#c.TExam.endDate"/></td>
										 <td><s:property value = "#c.count"/></td>
										 <td><button type="submit" class="btn btn-default btn-block" onclick="findpaper(<s:property value = "#c.TExam.id"/>)">参加考试</button>
										</tr>
									</s:iterator>
									</tbody>
                                </table>

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
	<script src="assets/js/jquery-1.11-0.min.js" type="text/javascript"></script>           

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
	
	<!-- Calender JS -->
	<script type="text/javascript" src="assets/js/dcalendar.picker.js"></script>     

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
    	
    	$('#mydatepicker').dcalendarpicker(); //初始化日期选择器
    	$('#mydatepicker1').dcalendarpicker(); //初始化日期选择器
    	$('#mycalendar').dcalendar(); //初始化日历      
	</script>
	

</html>
