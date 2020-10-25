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
<tr><th>与本人关系</th>
<th>姓名</th>
<th>工作单位</th>
<th>联系电话</th>
<th>操作</th></tr>

<c:forEach items="${relationlist}" var="relation">
<tr>
	<td>${relation.relation_relation}</td>
	<td>${relation.relation_name}</td>
	<td>${relation.relation_workunits}</td>
	<td>${relation.relation_telephone}</td>
	
	<td><a href="update.do?id=${relation.relation_id}">修改</a>||
	<a href="delete.do?id=${relation.relation_id}">删除</a></td>
	</tr>
</c:forEach>

</table>
</body>
</html>