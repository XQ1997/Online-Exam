<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>《数据库原理与应用》考试网站--用户信息</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ include file="include/css.jsp" %>
<style type="text/css">
body {
	font-family: Roboto, "Microsoft YaHei";
}

.mytable {
	border-collapse: collapse;
	border-bottom: 2px solid #ddd;
}

.mytable td {
	padding: 5px 10px;
}

.namelink a {
	text-decoration: none;
}

.namelink a:LINK {
	color: #12f;
}

.namelink a:VISITED {
	color: #a2e;
}

.namelink a:HOVER {
	color: #17f;
}
</style>
<s:head/>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	<div id="main">
		<div class="container" style="height: 350px;">
			<div class="divider"  style="height:40px;background:#fff"></div>
			<table class="table">
				<tbody>
					<tr>
						<td class="text-muted text-center"><i>用户姓名:</i></td>
						<td>${user.name}</td>
						<td class="text-muted text-center"><i>性别:</i></td>
						<td>${user.sex}</td>
					</tr>
					<tr>
						<td class="text-muted text-center"><i>学号/教师工号:</i></td>
						<td>${user.stuNumber}</td>
						<td class="text-muted text-center"><i>角色:</i></td>
						<td>${user.role}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<%@ include file="include/footer.jsp" %>
	<%@ include file="include/js.jsp" %>
</body>
</html>