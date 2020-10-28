<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ page import="com.bean.Relation" %>
<%@ page import="java.util.ArrayList" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
<tr><th>开始时间</th>
<th>结束时间</th>
<th>学习或工作经历</th>
<th>但任何职务</th>
<th>操作</th></tr>

<c:forEach items="${experiencelist}" var="experience">
<tr>
	<td>${experience.experience_startdate}</td>
	<td>${experience.experience_enddate}</td>
	<td>${experience.experience_place}</td>
	<td>${experience.experience_position}</td>
	
	<td><a href="update.do?id=${experience.experience_id}">修改</a>||
	<a href="delete.do?id=${experience.experience_id}">删除</a></td>
	</tr>
</c:forEach>

<div id='date1'>
	<td><input id="experience_startdate" name="experience_startdate"  type="text" placeholder="开始时间"/></td>
</div>
<script type="text/javascript">
			var d1 = new DateJs({
				inputEl: '#experience_startdate',
				el: '#date1'
			})
			console.log(d1)
		</script>
<div id='date2'>
	<td><input id="experience_enddate" name="experience_enddate"  type="text" placeholder="结束时间"/></td>
</div>	
<script type="text/javascript">
			var d2 = new DateJs({
				inputEl: '#experience_enddate',
				el: '#date2'
			})
			console.log(d2)
		</script>
		
</table>
</body>
</html>