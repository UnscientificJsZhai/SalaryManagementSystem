<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加部门</title>
<style>
.content {
	position: absolute;
	top: 10%;
	bottom: 0;
	left: 40%;
	right: 0;
	margin: auto;
}

.adds {
	text-align: center;
}

</style>
</head>
<body style="background: url(adddepart.jpg); background-size: cover">

	<div class="adds">
		<p style="color: blue">添加部门</p>
	</div>
	<div class="content">
		<form name="frm1" action="/administrator/addDepartment">
			<p>
				部门&nbsp;&nbsp;&nbsp;ID： <input type="text" name="did" id="textfield" />
			</p>
			<p>
				部门名称： <input type="text" name="dname" id="textfield1" />
			</p>
			<p>
				部门父级： <input type="text" name="dparent" id="textfield2" />
			</p>
			<p>
				部门等级： <input type="text" name="grade" id="textfield3" />
			</p>
			<p>&nbsp;</p>
			<input type="submit" value="确定" />
			
		</form>
	</div>
</body>
</html>