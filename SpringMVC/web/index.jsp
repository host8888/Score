<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>">
		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
		<title>title</title>
	</head>
	<body>
    <form action="data">
      用户名：<input type="text" name="user" id="user"><br>
      密码：<input type="password" name="pass" id="pass"><br>
      <button type="submit">提交 </button>

    </form>
	</body>
</html>
