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
<title>Insert title here</title>
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
<c:forEach items="${studentMessagelists}" var="student">
<table class="bordered">
<tr>
	<td colspan="6" style="text-align:center;">报名表</td>
</tr>
<tr>
	
	<td width="100">姓名</td>
	<td>${student.user_name }</td>
	<td>电话</td>
	<td>${student.user_phone }</td>
	<td rowspan="2">头像</td>
	<td rowspan="2"><img id="preview" src="admins/bookimg/${student.user_img}" width="100" height="100" style="diplay:none" /></td>
</tr>	 
<tr>
	<td>性别</td>
	<td>${student.studentgender.gender_name }</td>
	<td>民族</td>
	<td>${student.studentnational.national_name }</td>
</tr> 
<tr>   
	<td>身份证号</td>
	<td>${student.user_idnumber }</td>
	<td>出生日期</td>
	<td>${student.user_birthdate }</td>
	<td>政治面貌</td>
	<td>${student.user_political }</td>
</tr>   
<tr>
	<td>补充信息</td>
	<td colspan="5">
		<textarea rows="3" cols="108">
		${student.user_desc }
		</textarea>
	</td>
	</tr>
	 </c:forEach>
<tr>
	<td colspan="6" style="text-align:center;">学习经历</td>
</tr>
<tr>   
	<td>职务</td>
	
	<td colspan="2">开始时间</td>
	
	<td colspan="2">结束时间</td>
	
	<td>学习或工作经历</td>
	
</tr>
<c:forEach items="${experiencelist}" var="experience">
	<tr>
		<td>${experience.experience_position}</td>
		<td colspan="2">${experience.experience_startdate}</td>
		<td colspan="2">${experience.experience_enddate}</td>
		<td>${experience.experience_place}</td>
	</tr>
</c:forEach>




<tr>
	<td colspan="6" style="text-align:center;">家庭关系</td>
</tr>
<tr>   
	<td>姓名</td>
	
	<td colspan="2">与本人关系</td>
	
	<td colspan="2">工作单位</td>
	
	<td>联系电话</td>
	
</tr>
<c:forEach items="${relationlist}" var="relation">
<tr>
	<td>${relation.relation_name}</td>
	<td colspan="2">${relation.relation_relation}</td>
	<td colspan="2">${relation.relation_workunits}</td>
	<td>${relation.relation_telephone}</td>
	
	
	
	</tr>
</c:forEach>


<!-- <tr><td colspan="2"><input type="submit"></td></tr>    -->                                             
</table>
</body>
</html>