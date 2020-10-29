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
<p><label for="user_gender" class="uname" data-icon="u" > Your gender </label>
                                <select name="user_gender">
	                                	<option value="0">请选择</option>
	                                    <c:forEach items="${genders}" var="gender">
	                                    	<option value="${gender.gender_id}">${gender.gender_name}</option>
	                                    </c:forEach>
	                                </select>
                                </p>
</body>
</html>