<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Userlist</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>

<body>

	<div style="height: 100px"></div>

	<div style="width: 500px; margin: auto">
		<h2>This is userlist</h2>
		<br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>id</th>
					<th>username</th>
					<th>password</th>
					<th><a href="findpage">查询</a></th>
					<th><a href="addpage">添加</a></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.username}</td>
						<td>${user.password}</td>
						<td><a href="delete?id=${user.id}">刪除</a></td>
						<td><a href="update?id=${user.id}">更新</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		
		<form class="form-search" action="find" method="post">
			Username : <input type="text" name="username" class="input-medium search-query">
			<button type="submit" class="btn">普通查詢</button>
		</form>
		<br>
		
		<form class="form-search" action="redisfind" method="post">
			Username : <input type="text" name="username" class="input-medium search-query">
			<button type="submit" class="btn">redis查詢</button>  第二次以後相同才有效
		</form>
	</div>


</body>
</html>