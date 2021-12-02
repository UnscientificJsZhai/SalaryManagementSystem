<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员界面</title>
<style type="text/css">

.head{
position:absolute;
left:30px;
top:35px;
width:20%;
height:10%;
background-color:gray;
text-align:center;
line-height:60px;
}

.btn {
  background: #eb94d0;
  /* 创建渐变 */
  background-image: -webkit-linear-gradient(top, #eb94d0, #2079b0);
  background-image: -moz-linear-gradient(top, #eb94d0, #2079b0);
  background-image: -ms-linear-gradient(top, #eb94d0, #2079b0);
  background-image: -o-linear-gradient(top, #eb94d0, #2079b0);
  background-image: linear-gradient(to bottom, #eb94d0, #2079b0);
  /* 给按钮添加圆角 */
  -webkit-border-radius: 28;
  -moz-border-radius: 28;
  border-radius: 28px;
  text-shadow: 3px 2px 1px #9daef5;
  -webkit-box-shadow: 6px 5px 24px #666666;
  -moz-box-shadow: 6px 5px 24px #666666;
  box-shadow: 6px 5px 24px #666666;
  font-family: Arial;
  color: #fafafa;
  font-size: 27px;
  padding: 19px;
  text-decoration: none;
  text-align:center;

}
.log{
background-color:gray;
    position: fixed;
	top: 40%;
	left:42%;
	width: 200px;
	height:100px;
	text-align:center;

}
.logout {
	text-align: right;
	display: flex;
	justify-content: flex-end;
	padding-right: 50px;
}

</style>

</head>
<body style="background: url(adminview.jpg); background-size: cover">
<div class="head">
<%
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(d);
	%>
	
	当前时间：<%=time %>
</div>
    <div class="logout">
		<a href="/Login">退出登录</a>
	</div>
<div class="btn">
    <a href="/administrator/showStaff">员工信息></a>
	<a href="/administrator/showDepartment">部门信息</a>
</div>

<div class="log">
<p>欢迎登录！</p>
</div>

<script type="text/javascript">


</script>
	
</body>
</html>