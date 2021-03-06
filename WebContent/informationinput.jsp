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
<form  action="informationinput.do" method="post"  enctype="multipart/form-data"> 

<table class="bordered">

<tr>
	
	<td width="100">姓名</td>
	<td><input id="user_name" name="user_name" autocomplete="off" required="required" type="text" placeholder="user_name"/></td>
	<td>电话</td>
	<td><input id="user_phone" name="user_phone" autocomplete="off" required="required" type="text" placeholder="user_phone"/></td>
	<td rowspan="2"><input id="user_img" name="user_img" required="required"  type="file" placeholder="user_desc" onchange="imgPreview(this)" "/></td>
	<td rowspan="2" id="localImag"><label for="user_imgpreview" class="uname" data-icon="u" >  </label>
                                    <img id="preview"  width="100" height="100" style="diplay:none" />
                                    
                                    <!-- <img src="admins/bookimg/${carts.img}" class="img-responsive" alt=""> -->
                                </p></td>
</tr>	 
<tr>
	<td>性别</td>
	<td><select name="studentgender">
	                                	
	                                    <c:forEach items="${genders}" var="gender">
	                                    	<option value="${gender.gender_id}">${gender.gender_name}</option>
	                                    </c:forEach>
	                                </select></td>
	<td>民族</td>
	<td> <select name="studentnational">
	                                	
	                                    <c:forEach items="${nationals}" var="national">
	                                    	<option value="${national.national_id}">${national.national_name}</option>
	                                    </c:forEach>
	                                </select></td>
</tr> 
<tr>   
	<td>身份证号</td>
	<td><input id="user_idnumber" name="user_idnumber" autocomplete="off" required="required" type="text" maxlength="18" placeholder="user_idnumber"/></td>
	<td>出生日期</td>
	<td><input id="user_birthdate"  class="birthday"  name="user_birthdate" required="required" type="text" placeholder="user_birthdate"/>
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
									</script></td>
	
	<td>政治面貌</td>
	<td><input id="user_political" name="user_political" autocomplete="off" required="required" type="text" placeholder="user_political"/></td>
</tr>   
<tr>
	<td>补充信息</td>
	<td colspan="5">
		<textarea rows="3" cols="108" name="user_desc">
		
		</textarea>
	</td>
	</tr>
	
<tr>
	<td colspan="6" style="text-align:center;"><input type="submit" value="保存" /> </td>
</tr>




<!-- <tr><td colspan="2"><input type="submit"></td></tr>    -->                                             
</table>
</body>
</html>