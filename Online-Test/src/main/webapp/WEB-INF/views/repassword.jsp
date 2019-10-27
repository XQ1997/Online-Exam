<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>《数据库原理与应用》考试网站--用户更改密码</title>
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
.message{
	display:block;margin:10px auto;height:45px;width:300px;font-size:20px;font-weight:600;color:red;line-height:45px;padding:0 12px;border-radius:16px;background-color:yellow
}
</style>
<s:head/>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	<c:if test="${not empty message}">
		<div class="alert alert-success text-center message">${message}</div>
	</c:if>
	<div id="main">
		<div class="container" style="height: 350px;">
			<div class="divider"  style="height:40px;background:#fff"></div>
			<form id="repass" method="post">
            	<div class="row">
					<div class="input-field col s11" style="margin: 10px auto;">
						<i class="fas fa-user fa-3x prefix material-icons">vpn_key</i>
						<input type="password" placeholder="输入原密码" name="oldpass" class="validate" style="font-size:large" autocomplete="off" autofocus>
						<label>原密码</label>
					</div>
					<div class="input-field col s11" style="margin: 10px auto;">
						<i class="fas fa-user fa-3x prefix material-icons">vpn_key</i>
						<input type="password" placeholder="输入新密码" name="newpass" class="validate" style="font-size:large" autocomplete="off">
						<label>新密码</label>
					</div>
					<div class="divider" style="height: 10px; background-color: #fff;"></div>
					<div class="col s12">
						<button class="teal darken-4 waves-effect waves-teal btn-flat"type="submit">
							<span class="yellow-text text-lighten-1">确定 <i class="material-icons right">send</i></span>
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="include/footer.jsp" %>
	<%@ include file="include/js.jsp" %>
</body>
</html>