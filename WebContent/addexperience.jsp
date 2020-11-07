<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ page import="com.bean.Relation" %>
<%@ page import="java.util.ArrayList" %> 
<%@ page import="com.bean.StudentNational" %>
<%@ page import="java.util.ArrayList" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改经历</title>
<link rel="stylesheet" type="text/css" href="css/date.css" />
		<script src="js/date.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/nongli.js" type="text/javascript" charset="utf-8"></script>
		<style type="text/css">
			#date {
				margin-left: 100px;
			}
		</style>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="../favicon.ico"> 
<style>
table {
    *border-collapse: collapse; /* IE7 and lower */
    border-spacing: 0;
    width: 60%;    
    margin:auto;
}
a:link{
color:#bdc0b8;
text-decoration:none;
}
a:hover{
color:#FF8247;
text-decoration:underline;
}
a:visited{
color:#bdc0b8;
text-decoration:none;
}
.bordered {
    border: solid #ccc 1px;
    -moz-border-radius: 6px;
    -webkit-border-radius: 6px;
    border-radius: 6px;
    -webkit-box-shadow: 0 1px 1px #ccc; 
    -moz-box-shadow: 0 1px 1px #ccc; 
    box-shadow: 0 1px 1px #ccc;         
}

.bordered tr:hover {
    background: #fbf8e9;
    -o-transition: all 0.1s ease-in-out;
    -webkit-transition: all 0.1s ease-in-out;
    -moz-transition: all 0.1s ease-in-out;
    -ms-transition: all 0.1s ease-in-out;
    transition: all 0.1s ease-in-out;     
}    
    
.bordered td, .bordered th {
    border-left: 1px solid #ccc;
    border-top: 1px solid #ccc;
    padding: 10px;
    text-align: left;  
    padding-right:1px;  
}

.bordered th {
    background-color: #dce9f9;
    background-image: -webkit-gradient(linear, left top, left bottom, from(#ebf3fc), to(#dce9f9));
    background-image: -webkit-linear-gradient(top, #ebf3fc, #dce9f9);
    background-image:    -moz-linear-gradient(top, #ebf3fc, #dce9f9);
    background-image:     -ms-linear-gradient(top, #ebf3fc, #dce9f9);
    background-image:      -o-linear-gradient(top, #ebf3fc, #dce9f9);
    background-image:         linear-gradient(top, #ebf3fc, #dce9f9);
    -webkit-box-shadow: 0 1px 0 rgba(255,255,255,.8) inset; 
    -moz-box-shadow:0 1px 0 rgba(255,255,255,.8) inset;  
    box-shadow: 0 1px 0 rgba(255,255,255,.8) inset;        
    border-top: none;
    text-shadow: 0 1px 0 rgba(255,255,255,.5); 
}

.bordered td:first-child, .bordered th:first-child {
    border-left: none;
}

.bordered th:first-child {
    -moz-border-radius: 6px 0 0 0;
    -webkit-border-radius: 6px 0 0 0;
    border-radius: 6px 0 0 0;
}

.bordered th:last-child {
    -moz-border-radius: 0 6px 0 0;
    -webkit-border-radius: 0 6px 0 0;
    border-radius: 0 6px 0 0;
}

.bordered th:only-child{
    -moz-border-radius: 6px 6px 0 0;
    -webkit-border-radius: 6px 6px 0 0;
    border-radius: 6px 6px 0 0;
}

.bordered tr:last-child td:first-child {
    -moz-border-radius: 0 0 0 6px;
    -webkit-border-radius: 0 0 0 6px;
    border-radius: 0 0 0 6px;
}

.bordered tr:last-child td:last-child {
    -moz-border-radius: 0 0 6px 0;
    -webkit-border-radius: 0 0 6px 0;
    border-radius: 0 0 6px 0;
}
</style>
</head>
<body>
<br/><br/><br/><br/>
<table class="bordered">
<tr>   
	<th>职务</th>
	
	<th>开始时间</th>
	
	<th>结束时间</th>
	
	<th>学习或工作经历</th>
	
	<th>操作</th>
	
</tr>
<c:forEach items="${experiencelist}" var="experience">
	<tr>
		<td>${experience.experience_position}</td>
		<td >${experience.experience_startdate}</td>
		<td >${experience.experience_enddate}</td>
		<td>${experience.experience_place}</td>
		<td><a href="showUpdateExperienceById.do?id=${experience.experience_id}">修改</a>||
	<a href="deleteExperienceById.do?id=${experience.experience_id}">删除</a></td>
	</tr>
	
</c:forEach>

<tr>

<form action="experienceinput.do" method="post" >
<td><input id="experience_position" name="experience_position" autocomplete="off"  type="text" placeholder="但任何职务"/></td>
<div id='date'>
	<td><input id="experience_startdate" name="experience_startdate"  autocomplete="off" type="text" placeholder="开始时间"/></td>
</div>
 
<script type="text/javascript">
			var d1 = new DateJs({
				inputEl: "#experience_startdate",
				el: '#date',
				trigger: 'click'
			})
			console.log(d1)
			
			
		</script>
		

	<td><div id='date2'><input id="experience_enddate" name="experience_enddate" autocomplete="off"  type="text" placeholder="结束时间"/></div></td>
	

		<script type="text/javascript">
			var d2 = new DateJs({
				inputEl: "#experience_enddate",
				el: '#date2',
				trigger: 'click'
			})
			console.log(d2)
		</script>
	<td><input id="experience_place" name="experience_place" autocomplete="off"  type="text" placeholder="学习或工作经历"/></td>
	
	<td><input type="submit" value="保存" />
	</td>
	</form>
</tr>
<tr>
	<td colspan="5"><a href="informationlistNew.do">返回</a></td>
</tr>
<p class="change_link">
									
									
								</p>


</body>
</html>