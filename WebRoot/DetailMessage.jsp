<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户详细信息</title>
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
<%    String id=request.getParameter("id");
      if(request.getAttribute("T_flag")==null) 
          response.sendRedirect("UDMShowAction.action?id="+id);
%>
          <s:iterator value="list" var="user" >
                <div id="message">
					<div id="leftmessage" >
                        <p><label> 用户姓名:</label><s:property value="#user.name"/></p>
                        <p><label> 登录账号:</label><s:property value="#user.regname"/></p>
                        <p><label>注册邮箱:</label><s:property value="#user.email"/></p>
                        <p><label> 注册时间:</label><s:property value="#user.regdate"/></p>
                        <p><label> 联系电话:</label><s:property value="#user.telphone"/></p>
                        <p><label> 发&nbsp&nbsp帖&nbsp&nbsp数:</label><s:property value="#user.post"/></p>
                        <p><label> 所在城市:</label><s:property value="#user.city"/></p>
                    </div>
                    <div id="rightmessage">
                        <p><label> 用户头像:</label><img src=""></p>
                        <p><label> 论坛昵称:</label><s:property value="#user.nickname"/></p>
                        <p><label>联系电话:</label><s:property value="#user.telphone"/></p>
                        <p><label> 最后登录:</label><s:property value="#user.logdate"/></p>
                        <p><label> 论坛积分:</label><s:property value="#user.point"/></p>
                        <p><label> 查&nbsp&nbsp看&nbsp&nbsp数:</label><s:property value="#user.watch"/></p>
                        <p><label> 电&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp话:</label><s:property value="#user.phone"/></p>
                    </div>
                    <div id="cmessage">
                        <p><label> 签&nbsp&nbsp名&nbsp&nbsp档:</label><s:property value="#user.signature"/></p>
                    </div>
                    <div id="cmessage">
                        <p><label> 自我介绍:</label><s:property value="#user.content"/></p>
                    </div>
                </div>
          </s:iterator>
</body>
</html>