<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ page import="com.bean.Relation" %>
<%@ page import="java.util.ArrayList" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/date.css" />
		<script src="js/date.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/nongli.js" type="text/javascript" charset="utf-8"></script>
		<style type="text/css">
			#date {
				margin-left: 100px;
			}
		</style>
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
<form action="updateExperiencemessage.do" method="post" enctype="multipart/form-data">
<c:forEach items="${experiencelist}" var="experience">
<table class="bordered">
<tr>
	<td>开始时间</td>
	<td><div id='date'><input id="experience_startdate" name="experience_startdate" value=${experience.experience_startdate } required="required" autocomplete="off" type="text" placeholder="开始时间"/>
		</div>
<script type="text/javascript">
			var d1 = new DateJs({
				inputEl: "#experience_startdate",
				el: '#date',
				trigger: 'click'
			})
			console.log(d1)

		</script>
	  </td>     
</tr>
<tr>
<td>结束时间</td>
<td><div id='date2'><input id="experience_enddate" name="experience_enddate" value=${experience.experience_enddate } required="required" type="text" autocomplete="off" placeholder="experience_enddate"/>
<script type="text/javascript">
			var d2 = new DateJs({
				inputEl: "#experience_enddate",
				el: '#date2',
				trigger: 'click'
			})
			console.log(d2)
		</script></td>
</tr>	 
<tr>
<td>学习或工作经历</td>
<td><input id="experience_place" name="experience_place" value=${experience.experience_place } required="required" type="text" placeholder="experience_place"/></td>
</tr>    
<td>但任何职务</td>
<td>
<input id="experience_position" name="experience_position" value=${experience.experience_position } required="required" type="text" placeholder="experience_position"/></td>
</tr> 
<input id="experience_id" name="experience_id" value=${experience.experience_id }  type="text" style="display:none"/>
                                </c:forEach>  
<tr><td colspan="2"><input type="submit"></td></tr>                                                
</table></form>
</body>
</html>