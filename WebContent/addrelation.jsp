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
<title>修改家庭关系</title>

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
	<th>与本人关系</th>
	<th>姓名</th>
	<th>工作单位</th>
	<th>联系电话</th>
	<th>操作</th>
</tr>
<c:forEach items="${relationlist}" var="relation">
<tr>
	<td>${relation.relation_relation}</td>
	<td>${relation.relation_name}</td>
	<td>${relation.relation_workunits}</td>
	<td>${relation.relation_telephone}</td>
	
	<td><a href="showUpdateRelationById.do?id=${relation.relation_id}">修改</a>||
	<a href="deleteRelationById.do?id=${relation.relation_id}">删除</a></td>
	</tr>
</c:forEach>

<tr>
<form action="relationinput.do" method="post" >
	<td><input id="relation_relation" name="relation_relation"  type="text" placeholder="与本人关系"/></td>
	<td><input id="relation_name" name="relation_name"  type="text" placeholder="姓名"/></td>
	<td><input id="relation_workunits" name="relation_workunits"  type="text" placeholder="工作单位"/></td>
	<td><input id="relation_telephone" name="relation_telephone"  type="text" placeholder="联系电话"/></td>
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