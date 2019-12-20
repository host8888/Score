
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>">
		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
		<title>title</title>
		<script src="/js/jquery-3.4.1.js"></script>
		<script>
			$(document).ready(function () {
				$("#sub").click(function () {
					var uid=$("#uid").val();
					if(uid==''){
						alert("用户名或密码不能为空！");
						return false;
					}else{
						return true;
					}
				});
			});
		</script>
		<style>
			.log{
				height:280px;
				width:350px;
				background-color:#6CF;
				margin:0 auto;
				position: relative;
				top:200px;
				font-size: 20px;
				border: 1px  antiquewhite;
			}

			/*body{*/
			/*	background-size: 1000px,600px;*/
			/*	background-image:url(/images/longin.jpg);*/
			/*}*/
		</style>
	</head>
	<body>
<%--	<div class="log" style="text-align:center">--%>
<%--		<form action="index" method="post">--%>
<%--			<h3>新闻系统登录</h3>--%>
<%--			UserID :<input type="text" name="uid" id="uid"><br/><br/>--%>
<%--			password:<input type="password" name="pwd" id="pwd"><br/><br/>--%>
<%--			<input type="submit" value="登录" id="sub">--%>
<%--			<input type="reset" value="重置">--%>
<%--		</form>--%>
<%--		<p style="color: red;font-size: 16px">${msg}</p>--%>
<%--	</div>--%>
<img src="${pageContext.request.contextPath}/images/tea.jpg" alt="">

	</body>
</html>