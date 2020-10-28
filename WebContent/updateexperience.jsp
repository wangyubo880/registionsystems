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

							<form action="updateExperiencemessage.do" method="post" enctype="multipart/form-data">
							<c:forEach items="${experiencelist}" var="experience">
							
                                <h1>Update</h1> 
                                <p> 
                                    <label for="experience_startdate" class="uname" data-icon="u" > 开始时间 </label>
                                    <input id="experience_startdate" name="experience_startdate" value=${experience.experience_startdate } required="required" type="text" placeholder="experience.experience_startdate"/>
                                </p>
                                <p> 
                                    <label for="experience_enddate" class="uname" data-icon="u" > 结束时间 </label>
                                    <input id="experience_enddate" name="experience_enddate" value=${experience.experience_enddate } required="required" type="text" placeholder="experience_enddate"/>
                                </p>
                                                                <p> 
                                    <label for="experience_place" class="uname" data-icon="u" > 学习或工作经历 </label>
                                    <input id="experience_place" name="experience_place" value=${experience.experience_place } required="required" type="text" placeholder="experience_place"/>
                                </p>
                                                                <p> 
                                    <label for="experience_position" class="uname" data-icon="u" > 但任何职务</label>
                                    <input id="experience_position" name="experience_position" value=${experience.experience_position } required="required" type="text" placeholder="experience_position"/>
                                </p>
                             	<input id="experience_id" name="experience_id" value=${experience.experience_id }  type="text" style="display:none"/>
                                </c:forEach>
                                 <p > 
                                    <input type="submit" value="保存" /> 
								</p>


</table>
</p>
                                
            					
                               
                                <p class="change_link">
									Not a member yet ?
									
								</p>
                            </form>
                        </div>

                       
						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>