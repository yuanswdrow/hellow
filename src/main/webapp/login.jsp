<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>

<body>
	<div style="height: 100px"></div>
	
	<div style="width: 300px; margin: auto;">
	    <h2>Welcome to you !</h2>
	    <br>
		<form action="login" method="post">
			<fieldset>
				<legend>Login</legend>
				<span>username : </span><input type="text" name="username">
				<br>
                <span>username : </span><input type="password" name="password">
                <br>
				<button type="submit" class="btn">Submit</button>
				<a href="userlist"><button type="button" class="btn">No login</button></a>
			</fieldset>
		</form>
	</div>

</body>
</html>