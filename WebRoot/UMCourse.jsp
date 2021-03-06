<%@page import="com.entity.TUserCourse"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户课程信息</title>
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
    <link href="assets/css/popwindow.css" rel="stylesheet">
</head>
<body>

<%    
      String id=request.getParameter("id");
      if(request.getAttribute("T_flag")==null) 
          response.sendRedirect("UCShowAction.action?id="+id);
%>


<div id="UMCtable">
	<table border="1" class="table table-hover">
		<thead>
			<th>课程编号</th>
			<th>课程名</th>
			<th>下载次数</th>
			<th>学习次数</th>										
		</thead>
		<tbody>
	    <s:iterator value="list" var="course">	    
		    <tr>
				<td><s:property value="#course.id"/></td>
				<td><s:property value="#course.name"/></td>
				<td><s:property value="#course.loadCount"/></td>
				<td><s:property value="#course.learnCount"/></td>												
			</tr>
		</s:iterator>
		</tbody>
     </table>
</div>
</body>
</html>