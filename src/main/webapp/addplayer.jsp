<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Player</title>
<style type="text/css">
.container {
    position: relative;
    border-radius: 10px;
    background-color: #f2f2f2;
    padding: 20px 15px 30px 30px;
    width: 400px;
    margin: 20px;
    margin-top: 50px;
}
</style>
</head>
<body>
	<div class="container">
	<font style="color: red;">
	
	${msg}
	</font>
		<form action="addplayer" method="post">
			<table>
				<tr>
					<td>Name</td>
					<td>
					<input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>Mobile</td>
					<td>
					<input type="text" name="mobile" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td>
					<input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>Team</td>
					<td>
					<input type="text" name="team" /></td>
				</tr>
				<td></td>
				<td><input type="submit" value="Submit"></td>
			</table>
		</form>
	</div>

</body></html>