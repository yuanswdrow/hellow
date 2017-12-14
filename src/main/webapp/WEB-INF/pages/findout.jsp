<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Findlist</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>

<body>

	<div style="height: 100px"></div>

	<div style="width: 500px; margin: auto">
		<h2>Find result <a href="userlist">goto Userlist</a></h2>
		<h3>${msg}${time} 毫秒</h3>
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
				<tr>
					<td>${user.id}</td>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td><a href="delete?id=${user.id}">刪除</a></td>
					<td><a href="update?id=${user.id}">更新</a></td>
				</tr>
			</tbody>
		</table>
	</div>

	<script src="js/jquery-3.2.0.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>