<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ page import="com.bean.Relation" %>
<%@ page import="java.util.ArrayList" %> 
<%@ page import="com.bean.StudentNational" %>
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
	<script type="text/javascript">
    function imgPreview(fileDom){
        //判断是否支持FileReader
        if (window.FileReader) {
            var reader = new FileReader();
        } else {
            alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
        }

        //获取文件
        var user_desc = fileDom.files[0];
        var imageType = /^image\//;
        //是否是图片
        if (!imageType.test(user_desc.type)) {
            alert("请选择图片！");
            return;
        }
        //读取完成
        reader.onload = function(e) {
            //获取图片dom
            var img = document.getElementById("preview");
            //图片路径设置为读取的图片
            img.src = e.target.result;
        };
        reader.readAsDataURL(user_desc);
    }
</script>
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

							<form action="updatestudentmessage.do" method="post" enctype="multipart/form-data">
							<c:forEach items="${studentMessagelists}" var="student">
                             
                                <h1>Log in</h1> 
                                <p> 
                                    <label for="user_name" class="uname" data-icon="u" > Your username </label>
                                    <input id="user_name" name="user_name" value=${student.user_name } required="required" type="text" placeholder="user_name"/>
                                </p>
                              <!--   <p> 
                                    <label for="userid" class="uname" data-icon="u" > Your userid </label>
                                    <input id="userid" name="userid" required="required" type="text" placeholder="userid"/>
                                </p> -->
                                <p> 
                                    <label for="user_phone" class="uname" data-icon="u" > Your telephone </label>
                                    <input id="user_phone" name="user_phone" value=${student.user_phone } required="required" type="text" placeholder="user_phone"/>
                                </p>
                                <!-- 
                                                               <p><label  class="uname" data-icon="u" > Your gender </label>
                                <input id="user_phone" name="studentgender" value=${student.studentgender.gender_name } required="required" type="text" placeholder="user_phone"/>
                                </p> -->
                                                                <p><label for="user_gender" class="uname" data-icon="u" > Your gender </label>
                                <select name="studentgender">
	                                	
	                                    <c:forEach items="${genders}" var="gender">
	                                    	<option value="${gender.gender_id}">${gender.gender_name}</option>
	                                    </c:forEach>
	                                </select>
                                </p>
                                                                 <p><label for="user_national" class="uname" data-icon="u" > Your national </label>
                                <select name="studentnational">
	                                	
	                                    <c:forEach items="${nationals}" var="national">
	                                    	<option value="${national.national_id}">${national.national_name}</option>
	                                    </c:forEach>
	                                </select>
                                </p>
                                <!-- 
                                
                                
              <p> 
                                    <label for="user_national" class="uname" data-icon="u" > Your national </label>
                                    <input id="user_national" name="user_national" value=${student.studentnational.national_name } required="required" type="text" placeholder="user_national"/>
                                </p>
                                -->
                                <p> 
                                    <label for="user_idnumber" class="uname" data-icon="u" > Your user_idnumber </label>
                                    <input id="user_idnumber" name="user_idnumber" value=${student.user_idnumber } required="required" type="text" maxlength="18" placeholder="user_idnumber"/>
                                </p>
                                <p> 
                                    <label for="user_birthdate"  data-icon="u" > Your user_birthdate </label>
                                     <input id="user_birthdate"  class="birthday" value=${student.user_birthdate } name="user_birthdate" required="required" type="text" placeholder="user_birthdate"/> 
                                	
                                </p>
                                    <script>
									$(document).on("keyup blur","#user_idnumber",function(){
    								var code=$(this).val();
    								var len=code.length;
    								if ($.trim($(this).val().length)>6)
										$("#user_birthdate").attr("value",code.substr(6,4)+'-'+code.substr(10,2)+'-'+code.substr(12,2));
       									// $(".birthday").value(code.substr(6,4)+'-'+code.substr(10,2)+'-'+code.substr(12,2));
    								else
    									$("#user_birthdate").attr("value","");
    
									});
									</script>
                               <p> 
                                    <label for="user_political" class="uname" data-icon="u" > Your user_political </label>
                                    <input id="user_political" name="user_political" value=${student.user_political } required="required" type="text" placeholder="user_political"/>
                                </p>

                                <p> 
                                    <label for="user_img" class="uname" data-icon="u" > Your user_img </label>
                                    <input id="user_img" name="user_img" required="required" value=${student.user_img } type="file" placeholder="user_desc" onchange="imgPreview(this)" "/>
                                </p>
                                
                                <p id="localImag"> 
                                <label for="user_imgpreview" class="uname" data-icon="u" >  </label>
                                    <img id="preview" src="admins/bookimg/${student.user_img}" width="100" height="100" style="diplay:none" />
                                    
                                    <!-- <img src="admins/bookimg/${carts.img}" class="img-responsive" alt=""> -->
                                </p>
                                <p> 
                                    <label for="user_desc" class="uname" data-icon="u" > Your user_desc </label>
                                    <input id="user_desc" name="user_desc" value=${student.user_desc } required="required" type="text" placeholder="user_desc"/>
                                </p>
                                </c:forEach>
                                 <p > 
                                    <input type="submit" value="保存" /> 
								</p>
<p>
<table  class="altrowstable" id="alternatecolor" align="center">
<tr><th colspan="4">家庭关系</th></tr>
<tr><th>与本人关系</th>
<th>姓名</th>
<th>工作单位</th>
<th>联系电话</th>
<!-- <th><a href="updaterelation.do">修改</a></th> -->
</tr>

<c:forEach items="${relationlist}" var="relation">
<tr>
	<td>${relation.relation_relation}</td>
	<td>${relation.relation_name}</td>
	<td>${relation.relation_workunits}</td>
	<td>${relation.relation_telephone}</td>
	
	
	</td>
	</tr>
</c:forEach>
<tr><td colspan="4"><a href="updaterelation.do">修改</a></tr>


</table>
<table  class="altrowstable" id="alternatecolor" align="center">
<tr><th colspan="4">学习经历</th></tr>
<tr><th>开始时间</th>
<th>结束时间</th>
<th>学习或工作经历</th>
<th>但任何职务</th>
<!-- <th><a href="updaterelation.do">修改</a></th> -->
</tr>

<c:forEach items="${experiencelist}" var="experience">
<tr>
	<td>${experience.experience_startdate}</td>
	<td>${experience.experience_enddate}</td>
	<td>${experience.experience_place}</td>
	<td>${experience.experience_position}</td>
	
	
	</td>
	</tr>
</c:forEach>
<tr><td colspan="4"><a href="updateexperience.do">修改</a></tr>


</table>
</p>
                                
            					
                               
                                <p class="change_link">
									Not a member yet ?
									<a href="enrollMsg.do">报名</a>
									
								</p>
                            </form>
                            
                            
                        </div>

                       
						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>