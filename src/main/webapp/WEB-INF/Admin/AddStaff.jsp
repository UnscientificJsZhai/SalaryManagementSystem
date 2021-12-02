<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加员工</title>
<style type="text/css">
.content {
	        position: absolute;
            top: 10%;
            bottom: 0;
            left: 40%;
            right: 0;
            margin: auto;
}
.adds{
text-align:center;
}

</style>
</head>
<body style="background:gray">
    <div class="adds">
    <p style="color:blue">添加员工</p>
    </div>
     
	<div class="content">
		<form name="frm1" action="/administrator/addStaff">
			<p>
				I&nbsp;&nbsp;&nbsp;D： <input type="text" name="id" id="textfield" /> 
			</p>
			<p>
				姓名： <input type="text" name="name" id="textfield1" />
			</p>
			<p>
				密码： <input type="password" name="password" id="textfield2" />
			</p>
			<p>
				部门： <input type="text" name="department" id="textfield3" />
			</p>
			<p>
				电话： <input type="text" name="phone" id="textfield4" />
			</p>
			<p>
				邮件： <input type="text" name="email" id="textfield5" />
			</p>
			<p>&nbsp;</p>
			  <input type="submit" value="确定" style="height:40px; vertical-align:middle;" />
		</form>
	</div>
</body>
</html>