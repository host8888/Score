<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>">
		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
		<title>title</title>
        <link href="../css/bootstrap-4.3.1.css" rel="stylesheet">
        <script src="../js/jquery-3.4.1.js"></script>
        <link rel="stylesheet" href="../css/newsMager.css">
        <script>
            $(document).ready(function () {
               var home= $("#home");
               var user='<%=session.getAttribute("uid")%>';
               home.html(user);
               var nadd=$("#newsadd");
               var nedit=$("#newsedit");
               //主要操作
               var addnw=$("#addnw");
               var editnw=$("#editnw");
               var addst=$("#addst");
               var editst=$("#editst");
               nedit.hide();
               addnw.click(function () {
                   nedit.hide();
                   nadd.show();
               });
                editnw.click(function () {
                  nadd.hide();
                  nedit.show();
                })
            })
        </script>
	</head>
	<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark" id="navbar">
        <a class="navbar-brand" href="#" id="well">欢迎：</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto" >
                <li class="nav-item active">
                    <%--					用户名--%>
                    <a class="nav-link" id="home" ><span class="sr-only">(current)</span></a>
                </li>
                <a class="nav-link" id="go" href="userExit" >退出</a>
            </ul>
        </div>
    </nav>
    <div id="util">
        <span class="pad" id="addnw">添加新闻</span><br>
        <span class="pad" id="editnw">编辑新闻</span><br>
        <span class="pad" id="addst">添加主题</span><br>
        <span class="pad" id="editst">编辑主题</span><br>
    </div>
    <div id="newsadd">
        <h3>新闻添加</h3>
        <form action="newsAdd" method="post" enctype="multipart/form-data">
            <label>
                主题：
                <select name="subject">
                    <option value="体育">体育</option>
                    <option value="政治">政治</option>
                    <option value="娱乐">娱乐</option>
                    <option value="国际">国际</option>
                    <option value="军事">军事</option>
                    <option value="科技">科技</option>
                    <option value="探索">探索</option>
                     </select>
            </label><br>
            标题：<input type="text" name="title" id="title"><br><br>
            作者：<input type="text" name="writer" id="writer"><br><br>
            摘要：<textarea id="des" name="des" ></textarea><br><br>
            内容：<textarea name="msg" id="msg"></textarea><br><br>
            文件上传：<input type="file" id="file" name="file"><br><br>
            <button type="submit">提交</button><button type="reset">重置</button>
        </form>
    </div>
        <div id="newsedit">
            <h3>编辑新闻</h3>
            <form action="" method="post" enctype="multipart/form-data">
                <label>
                    主题：
                    <select name="subject">
                        <option value="体育">体育</option>
                        <option value="娱乐">娱乐</option>
                        <option value="军事">军事</option>
                        <option value="科技">科技</option>
                        <option value="探索">探索</option>
                    </select>
                </label><br>
                标题：<input type="text" name="title" id="edtitle"><br><br>
                作者：<input type="text" name="writer" id="edwriter"><br><br>
                摘要：<textarea id="eddes" name="des" ></textarea><br><br>
                内容：<textarea name="msg" id="edmsg"></textarea><br><br>
                文件上传：<input type="file" id="edfile" name="file"><br><br>
                <button type="submit">提交</button><button type="reset">重置</button>
            </form>
        </div>
	</body>
</html>