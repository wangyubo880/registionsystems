<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

		<title>日期选择器</title>
		<link rel="stylesheet" type="text/css" href="css/date.css" />
		<script src="js/date.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/nongli.js" type="text/javascript" charset="utf-8"></script>
		<style type="text/css">
			#date {
				margin-left: 100px;
			}
		</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id='date'>
			<input type="text" value='' placeholder="点击选择时间" id='inputdate' />
		</div>
		<div>请点击输入框查看效果</div>

		<script type="text/javascript">
			var d = new DateJs({
				inputEl: '#inputdate',
				el: '#date'
			})
			console.log(d)
		</script>
		
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
</body>
</html>