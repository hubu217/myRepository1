<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>  
	<head>  
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
		<title>Insert title here</title>  
	</head>  
	  
	<body>  
	  	
	  	
	
 	
 		<form method="post">
				<table class="table table-hover table-condensed">
					<tr>
						<th>登录名</th>
						<td><input name="name" type="text" placeholder="请输入登录名" class="easyui-validatebox" data-options="required:true" value="孙宇"></td>
					</tr>
					<tr>
						<th>密码</th>
						<td><input name="pwd" type="password" placeholder="请输入密码" class="easyui-validatebox" data-options="required:true" value="123456"></td>
					</tr>
				</table>
		</form>
 	
	  	
	  	
	  	
	</body> 
 
</html>  