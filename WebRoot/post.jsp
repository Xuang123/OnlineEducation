<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<jsp:useBean id="dbpost" class="dao.DBoperator" />
<!doctype html>
<html lang="en">
<head>
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
     
    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="assets/css/paper-dashboard.css" rel="stylesheet"/>

   

    <!--  Fonts and icons     -->
    
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="assets/css/themify-icons.css" rel="stylesheet">
    
    <script >

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
                <a href="#" class="simple-text">
                   互动社区
                </a>
            </div>

            <ul class="nav">
                
                      <li class="active">
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
                <li>
                    <a href="personalmsg.jsp">
                        <i class="ti-pin-alt"></i>
                        <p>个人资料</p>
                    </a>
                </li>
                <li>
                    <a href="smc.jsp">
                        <i class="ti-email"></i>
                        <p>短信中心</p>
                    </a>
                </li>
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
                   
                </div>
                <div class="collapse navbar-collapse">
                   <ul class="nav navbar-nav navbar-right">
                    <% Connection conn = dbpost.getConn();
                    String sql = "select * from t_forum where topic =\"问题答疑交流\" ";
                    ResultSet rs = dbpost.Statementexcute(sql);
  %>
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                   <p>问题答疑交流</p>
									<b class="caret"></b>
                              </a>
                              <ul class="dropdown-menu">
                              <% while(rs.next()) {
                                 
                                String s=  "forum.jsp?forumid=" +rs.getInt(1)+"&forumname=" +rs.getString(2);
                       
                            	  %>
                            	     <li><a href=' <%= s %>'><%=rs.getString(2) %></a></li>
                              <% }
                              
                              rs.close();
                              %>
                              
                              </ul>
                        </li>
                        
                                      <% 
                    sql = "select * from t_forum where topic =\"知识分享\" ";
                  rs = dbpost.Statementexcute(sql);
  %>
                        
                         <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                   <p>知识分享</p>
									<b class="caret"></b>
                              </a>
                              <ul class="dropdown-menu">
                              <% while(rs.next()) {
                            	  String s=  "forum.jsp?forumid=" +rs.getInt(1)+"&forumname="+rs.getString(2);
                            	  %>
                            	     <li><a href=' <%= s %>'><%=rs.getString(2) %></a></li>
                              <% }
                              rs.close();
                              %>
                              
                              </ul>
                        </li>
                        
                                       <% 
                    sql = "select * from t_forum where topic =\"我来说两句\" ";
                  rs = dbpost.Statementexcute(sql);
  %>
                        
                         <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                   <p>我来说两句</p>
									<b class="caret"></b>
                              </a>
                              <ul class="dropdown-menu">
                              <% while(rs.next()) {
                            	  String s=  "forum.jsp?forumid=" +rs.getInt(1)+"&forumname="+rs.getString(2) ;
                            	  %>
                            	     <li><a href=' <%= s %>'><%=rs.getString(2) %></a></li>
                              <% }%>
                              <% rs.close();%> 
                              </ul>
                        </li>
                   
                   </ul>
                       

                </div>
            </div>
        </nav>
       
   

         <div class="content" >
       
              <% 
               String path = request.getContextPath(); 
               String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
             String n= request.getParameter("name");
             String id="";
          sql ="select id from t_post where name=\""+n+"\"";
                     	  rs=dbpost.Statementexcute(sql);
                     	if(rs.next()) {
                     		 id= rs.getString(1);}
          
           sql = "select a.nickname,b.nickname,p.name ,publishDate,viewcount,p.content"+
                                 " from t_post as p,t_user as a,t_user as b where "+
                                 " userId=a.id and reUserId=b.id and p.pid ="+id+" order by publishDate asc";
           
           rs =dbpost.Statementexcute(sql);
            int i=0;
             %>
            <table>
             <tbody>
              <% if(rs.next()) { i++;%>       
         
                <tr> <td class="forum_index"><div  style="width:120px;height:200px;margin-left:60px  ">
                <img  align="middle" src="assets/img/touxiang.jpg" width="120px" height="120px" ><br/>
                <p align="center"><%=rs.getString(1) %></p></div></td>
                     <td class="forum_description"><div  style="width:600px;height:200px;border:1px #DDDDDD solid"><%=rs.getString(3) %><br/>
                &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<%=rs.getString(6) %><br/></div></td>
              </tr>
         
              <tr>
     <td colspan="2"><div  style="width:720px;height:30px;margin-left:60px;text-align:right "> <%=i %>楼&nbsp&nbsp<%=rs.getString(4) %></div></td>
              </tr>
         
                <% }%>
                
                  <% while(rs.next()) { i++;%>  
                         
                 <tr> <td class="forum_index"><div  style="width:120px;height:200px;margin-left:60px  ">
                <img  align="middle" src="assets/img/touxiang.jpg" width="120px" height="120px" ><br/>
                <p align="center"><%=rs.getString(1) %></p></div></td>
                     <td class="forum_description"><div  style="width:600px;height:200px;border:1px #DDDDDD solid">
                &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<%=rs.getString(6) %><br/></div></td>
              </tr>
         
              <tr>
     <td colspan="2"><div  style="width:720px;height:30px;margin-left:60px;text-align:right "> <%=i %>楼&nbsp&nbsp<%=rs.getString(4) %></div></td>
              </tr>
         
                <% }
                
                rs.close();
                %>
              </tbody>
          </table>
          
          <div style="margin-left:180px">
          <table>
          <tr><td>发表回复</td></tr>
          <% String dirt="post.jsp?name="+n; %>
          <tr><td><form  action="<%=dirt%>"  method="post">
          <textarea name="ta" id="ta" cols="72" rows="8" style="overflow:hidden; resize:none;"></textarea>
          
         <!--  <input type="button" value="提交" onclick="commit()"> 
         <input type="submit">--> 
        <input type="button" value="提交" onclick="this.disabled=true;this.form.submit()"> 
           
          
          </form></td></tr>
          </table></div>
          
          

    
       
                    </div>
        
        
                  <%  String userId="";
              String reUserId ="";
              String pid="";
              String content="";
              String forumId="";
              
              if(request.getParameter("ta")!=null){
           
              sql="select userId,pid ,forumId from t_post where name=\""+n+"\"";
              rs=dbpost.Statementexcute(sql);
              if(rs.next()){
            	  reUserId =rs.getString(1);
            	  pid=rs.getString(2);
            	  forumId=rs.getString(3);
              }
               sql="select id,nickname from t_user where regname=\"Qianjin\"";
              rs=dbpost.Statementexcute(sql);
              if(rs.next()){
            	  userId =rs.getString(1);
              }
              content=request.getParameter("ta");
           
           String publishDate=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
          
           
           
           sql ="insert into t_post(id,userId,pid,reUserId,content,forumId,publishDate)values(?,?,?,?,?,?,?)";
          dbpost.executeupdate(sql,null,userId,pid,reUserId,content,forumId,publishDate );
          
          sql="update t_user set point=point+3 where id=?";
          dbpost.executeupdate(sql, userId);
           }%>
        
</div>

      

  
        <footer class="footer">
            <div class="container-fluid">
                <nav class="pull-left">
                    
                </nav>
				
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

 

    <!-- Paper Dashboard Core javascript and methods for Demo purpose -->
	<script src="assets/js/paper-dashboard.js"></script>
   
</html>

