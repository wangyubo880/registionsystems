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
<title>login</title>
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

<script type="text/javascript">
function altRows(id){
	if(document.getElementsByTagName){  
		
		var table = document.getElementById(id);  
		var rows = table.getElementsByTagName("tr"); 
		 
		for(i = 0; i < rows.length; i++){          
			if(i % 2 == 0){
				rows[i].className = "evenrowcolor";
			}else{
				rows[i].className = "oddrowcolor";
			}      
		}
	}
}

window.onload=function(){
	altRows('alternatecolor');
}
</script>


<!-- CSS goes in the document HEAD or added to your external stylesheet -->
<style type="text/css">
table.altrowstable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #a9c6c9;
	border-collapse: collapse;
}
table.altrowstable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
table.altrowstable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
.oddrowcolor{
	background-color:#d4e3e5;
}
.evenrowcolor{
	background-color:#c3dde0;
}
td  
{  
    text-align:center;  
}  
</style>
		<link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
		<script src="js/uploadPreview.js"></script>
		<script src="http://apps.bdimg.com/libs/jquery/1.8.3/jquery.min.js"></script>

</head>
<body>
<div class="container">
            <div class="codrops-top">
              <div class="clr"></div>
            </div>
            <header>
                <h1>Login and Registration Form <span>with HTML5 and CSS3</span></h1>
				<nav class="codrops-demos">
				<!--  	<span>Click <strong>"Join us"</strong> to see the form switch</span> -->
					
				</nav>
            </header>
            <section>				
                <div id="container_demo" >
                   
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">


<p>
<table  class="altrowstable" id="alternatecolor" align="center">
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
	
	<td><a href="showUpdateExperienceById.do?id=${experience.experience_id}">修改</a>||
	<a href="deleteExperienceById.do?id=${experience.experience_id}">删除</a></td>
	</tr>
</c:forEach>

<tr>

<form action="experienceinput.do" method="post" >
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
	<td><input id="experience_position" name="experience_position" autocomplete="off"  type="text" placeholder="但任何职务"/></td>
	<td><input type="submit" value="保存" />
	</td>
	</form>
</tr>


</table>
</p>
                                
         
         
		<!--  
		<div id='date2'>
			<input type="text" value='' placeholder="点击选择时间" id="inputdate2" />
		</div>
		<div>请点击输入框查看效果</div>

		<script type="text/javascript">
			var d2 = new DateJs({
				inputEl: "#inputdate2",
				el: '#date2'
			})
			console.log(d2)
		</script>
         -->
            					
                               
                                <p class="change_link">
									<a href="informationlistNew.do">返回</a>
									
								</p>
                         
                        </div>

                       
						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>