<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加部门</title>
</head>
<body>
<form  name="frm1" action="department_add">
   <p>部门名称：
     <label for="textfield"></label>
     <input type="text" name="departmentname" id="textfield" />
     <input type="hidden" name="departmentid" id="textfield1" />
   </p>
   <p>等级：
     <input type="text" name="grade" id="textfield3"  />
   </p>
   <p>&nbsp;</p>
   <input type="submit" value="确定"/>
</form>
</body>
</html>