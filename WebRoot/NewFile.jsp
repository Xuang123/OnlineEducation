<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
		<script type="text/javascript" language = "JavaScript">
        function exam_search(){
        	alert('123');
        	var a = document.getElementsById("sdf").value;
        	window.location.href="doSearch_exam";    
        }
    </script>
</head>
<body>
<input type="text" id = "sdf"  placeholder="输入考试科目查询">
<button type="submit" onclick="exam_search()">考试查询</button>  
</body>
</html>