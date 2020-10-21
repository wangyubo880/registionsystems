<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
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
                            <form  action="InformationinputServlet" method="post" /> 
                                <h1>Log in</h1> 
                                <p> 
                                    <label for="user_name" class="uname" data-icon="u" > Your username </label>
                                    <input id="user_name" name="user_name" required="required" type="text" placeholder="user_name"/>
                                </p>
                                <p> 
                                    <label for="user_phone" class="uname" data-icon="u" > Your telephone </label>
                                    <input id="user_phone" name="user_phone" required="required" type="text" placeholder="user_phone"/>
                                </p>
                                <p> 
                                    <label for="user_gender" class="uname" data-icon="u" > Your gender </label>
                                    <input id="user_gender" name="user_gender" required="required" type="text" placeholder="user_gender"/>
                                </p>
                                <p> 
                                    <label for="user_national" class="uname" data-icon="u" > Your national </label>
                                    <input id="user_national" name="user_national" required="required" type="text" placeholder="user_national"/>
                                </p>
                                <p> 
                                    <label for="user_idnumber" class="uname" data-icon="u" > Your user_idnumber </label>
                                    <input id="user_idnumber" name="user_idnumber" required="required" type="text" maxlength="18" placeholder="user_idnumber"/>
                                </p>
                                <p> 
                                    <label for="user_birthdate"  data-icon="u" > Your user_birthdate </label>
                                     <input id="user_birthdate"  class="birthday" name="user_birthdate" required="required" type="text" placeholder="user_birthdate"/> 
                                	
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
                                    <input id="user_political" name="user_political" required="required" type="text" placeholder="user_political"/>
                                </p>
                                <p> 
                                    <label for="user_img" class="uname" data-icon="u" > Your user_img </label>
                                    <input id="user_img" name="user_img" required="required" type="text" placeholder="user_img"/>
                                </p>
                                <p> 
                                    <label for="user_desc" class="uname" data-icon="u" > Your user_desc </label>
                                    <input id="user_desc" name="user_desc" required="required" type="file" placeholder="user_desc" onchange="imgPreview(this)" "/>
                                </p>
                                
                                <p id="localImag"> 
                                <label for="user_desc" class="uname" data-icon="u" >  </label>
                                    <img id="preview" width="100" height="100" style="diplay:none" />
                                </p>
                                
                               
                               
    
                                
                                
            					
                                <p class="login button"> 
                                    <input type="submit" value="Login" /> 
								</p>
                                <p class="change_link">
									Not a member yet ?
									<a href="register.jsp" class="to_register">Join us</a>
								</p>
                            </form>
                        </div>

                       
						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>