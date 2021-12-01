<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加员工</title>
</head>
<body>
<form  name="frm1" action="staff_add">
   <p>用户名：
     <label for="textfield"></label>
     <input type="text" name="username" id="textfield" />
     <input type="hidden" name="userid" id="textfield1" />
   </p>
   <p>密码：
     <input type="text" name="password" id="textfield2"  />
   </p>
   <p>部门：
     <input type="text" name="age" id="textfield3"  />
   </p>
   <p>电话：
     <input type="text" name="sex" id="textfield4" />
   </p>
   <p>邮件：
     <input type="text" name="address" id="textfield5" />
   </p>
   <p>&nbsp;</p>
   <input type="submit" value="确定"/>
</form>
</body>
</html>