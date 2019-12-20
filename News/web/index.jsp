<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>">
		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>title</title>
		<link href="css/bootstrap-4.3.1.css" rel="stylesheet">
		<link rel="stylesheet" href="css/index.css">
		<script src="js/jquery-3.4.1.js"></script>
		<script>
			$(document).ready(function () {
				var home=$("#home");
				var well=$("#well");
				var sd=$("#sd");
				var op=$("#op");
				var go=$("#go");
				var enter=$("#enter");
				var nav_home=$("#nav-home-tab");
				var nav_profile=$("#nav-profile-tab");
				var nav_contact=$("#nav-contact-tab");
				var uid='<%=session.getAttribute("uid")%>';
				var flag='<%=session.getAttribute("flag")%>';
				home.html("未登入");
				well.hide();
				enter.show();
				sd.hide();
				op.hide();
				if(uid!='null'){
					home.html(uid);
					op.show();
					enter.hide();
					sd.show();
				}
				function send(){
					$.ajax({
						type: "POST",
						url: "index",
						dateType:"text",
						async:false,
						data:$("#enter").serialize(),
						success:function (data) {
							var str=data.toString();
							if(str.length>10){
								alert("用户名或密码错误！")
							}else {
								home.html(data);
								op.show();
								enter.hide();
								sd.show();
							}
						},
						error:function () {
							alert("登入失败，请刷新页面重试！");
						}
					});
				}
				function exit(){
					$.ajax({
						type: "GET",
						url: "userExit",
						dateType:"text",
						async:false,
						success:function (data) {
							home.html("未登入");
							well.hide();
							enter.show();
							sd.hide();
							op.hide();
						},
						error:function () {
							alert("error");
						}
					});
				}
				$("#ex").click(function () {
					exit();
				});
				go.click(function () {
					if($("#uid").val()==''||$("#pwd").val()==''){
						alert("用户名或密码不能为空");
						return false;
					}else {
						send();
					}
				});
				$("#expor").click(function () {
					$("#expor").attr("href","/jsp/login.jsp");
				});
			});

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
				<li class="nav-item dropdown" id="op">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">操作</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown" >
						<a class="dropdown-item" href="#">修改资料</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" id="ex" style="cursor: pointer;">退出登录</a>
					</div>
				</li>
				<li class="nav-item" id="sd">

					<a class="nav-link" href="/jsp/newsMager.jsp">新闻管理</a>
				</li>
			</ul>
			<form class="form-inline my-2 my-lg-0" id="enter">
					<input class="form-control mr-sm-2" type="text" placeholder="用户名" aria-label="Search" id="uid" name="uid">
					<input class="form-control mr-sm-2" type="password" placeholder="密码" aria-label="Search" id="pwd" name="pwd">
					<button class="btn btn-outline-success my-2 my-sm-0" type="button" id="go">登入</button>
			</form>
		</div>
	</nav>
	<div class="container mt-3 " id="banner">
		<div class="row">
			<div class="col-12">
				<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleControls" data-slide-to="0" class="active"></li>
						<li data-target="#carouselExampleControls" data-slide-to="1"></li>
						<li data-target="#carouselExampleControls" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<a href=""><img class="d-block w-100" src="images/1920x500.gif" alt="First slide"></a>
							<div class="carousel-caption d-none d-md-block">
								<h5>Item 1 Heading</h5>
								<p>Item 1 Description</p>
							</div>
						</div>
						<div class="carousel-item">
							<a href=""><img class="d-block w-100" src="images/jpg1/1920x500.gif" alt="Second slide"></a>
							<div class="carousel-caption d-none d-md-block">
								<h5>Item 2 Heading</h5>
								<p>Item 2 Description</p>
							</div>
						</div>
						<div class="carousel-item">
							<a href=""><img class="d-block w-100" src="images/jpg/1920x500.gif" alt="Third slide"></a>
							<div class="carousel-caption d-none d-md-block">
								<h5>Item 3 Heading</h5>
								<p>Item 3 Description</p>
							</div>
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>
		<hr>
	</div>
	<section>
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-12" id="writ">
					<h3>新闻分类</h3>
					<hr>
					<div class="row">
						<div class="col-4">
							<div class="text-center classes"> 体育 </div>
						</div>
						<div class="col-4">
							<div class="text-center classes" > 社会</div>
						</div>
						<div class="col-4">
							<div class="text-center classes" >军事 </div>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-4">
							<a href="#" id="expor"><div class="text-center classes" >探索 </div></a>
						</div>
						<div class="col-4">
							<div class="text-center classes">科技 </div>
						</div>
						<div class="col-4">
							<div class="text-center classes">健康</div>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-4">
							<div class="text-center classes"> 教育</div>
						</div>
						<div class="col-4">
							<div class="text-center classes">文化 </div>
						</div>
						<div class="col-4">
							<div class="text-center classes"> 其他</div>
						</div>
					</div>
					<hr>
				</div>
				<div class="col-md-6 col-12">
					<h3>NEWS</h3>
					<nav>
						<div class="nav nav-tabs" id="nav-tab" role="tablist">
							<a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">国内新闻</a>
							<a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">国际新闻</a>
							<a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false">娱乐新闻</a>
						</div>
					</nav>
					<div class="tab-content " id="nav-tabContent">
						<div class="tab-pane fade show active no1" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
<%--							<p class="text-center mt-2"><img src="images/jpg/3b536b.gif" alt="" ></p>--%>
<%--							<table>--%>
<%--								<c:forEach items="" var="">--%>
<%--									<tr>--%>
<%--										<td></td>--%>
<%--									</tr>--%>
<%--								</c:forEach>--%>
<%--							</table>--%>
							<a href="https://www.fmprc.gov.cn/web/fyrbt_673021/t1725676.shtml">2019年12月18日外交部发言人耿爽主持例行记者会</a><br>
							<a href="http://www.gx.xinhuanet.com/newscenter/2019-12/18/c_1125359719.htm">广西聚焦深贫地区攻难点</a><br>
							<a href="https://tech.sina.com.cn/roll/2019-12-18/doc-iihnzhfz6700119.shtml">四川资中5.2级地震 | 专家分析震区近日发生更大地震的可能性不大</a><br>
							<br><br><br><br><br><br><br><br>
						</div>
						<div class="tab-pane fade no2" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
<%--							<table>--%>
<%--								<c:forEach items="" var="">--%>
<%--									<tr>--%>
<%--										<td></td>--%>
<%--									</tr>--%>
<%--								</c:forEach>--%>
<%--							</table>--%>
							<a href="https://www.yicai.com/news/100439729.html">俄法总统通话 就俄罗斯天然气过境乌克兰等问题进行磋商</a>
						</div>
						<div class="tab-pane fade no3" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
							<a href="#">娱乐新闻</a>
<%--							<table>--%>
<%--								<c:forEach items="" var="">--%>
<%--									<tr>--%>
<%--										<td></td>--%>
<%--									</tr>--%>
<%--								</c:forEach>--%>
<%--							</table>--%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section style="position: relative;">
		<hr>
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-md-6 col-12">
					<ul class="list-unstyled">
						<li class="media">
							<img class="mr-3 rounded-circle" src="images/100X100.gif" alt="Generic placeholder image">
							<div class="media-body">
								<h5 class="mt-0 mb-1">置顶 1</h5>
								<p class="mb-0">Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.</p>
							</div>
						</li>
					</ul>
				</div>
				<div class="col-lg-4 col-md-6 col-12">
					<ul class="list-unstyled">
						<li class="media">
							<img class="mr-3 rounded-circle" src="images/100X100.gif" alt="Generic placeholder image">
							<div class="media-body ">
								<h5 class="mt-0 mb-1">置顶 2</h5>
								<p class="mb-0">Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.</p>
							</div>
						</li>
					</ul>
				</div>
				<div class="col-lg-4 d-md-none d-lg-block">
					<ul class="list-unstyled">
						<li class="media">
							<img class="mr-3 rounded-circle" src="images/100X100.gif" alt="Generic placeholder image">
							<div class="media-body">
								<h5 class="mt-0 mb-1">置顶 3</h5>
								<p class="mb-0">Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.</p>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</section>
	<hr>
	<div class="container" >

			</div>
			<hr>
			<div class=" " id="hot">
				<div class="card" id="hot-a">
					<img class="card-img-top" src="images/400X200.gif" alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">Card title</h5>
						<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn btn-primary">Go somewhere</a>
					</div>
				</div>
				<div class="row mx-0">
					<div class="col-12 card bg-light mx-auto">
						<h3 class="text-center card-header">热点新闻</h3>
						<div id="news">
<%--							<table>--%>
<%--								<c:forEach items="" var="">--%>
<%--								<tr>--%>
<%--									<td></td>--%>
<%--								</tr>--%>
<%--							</c:forEach>--%>
<%--							</table>--%>

						</div>
					</div>

				</div>
			</div>
	<hr>

	<div class="container">
		<div class="row">
			<div class="col-md-8 col-12">
				<div class="row">
					<div class="col-lg-6 col-12">
						<h3>About Us</h3>
						<hr>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Atque, consequatur neque exercitationem distinctio esse! Cupiditate doloribus a consequatur iusto illum eos facere vel iste iure maxime. Velit, rem, sunt obcaecati eveniet id nemo molestiae. In.</p>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Atque, consequatur neque exercitationem distinctio esse! Cupiditate doloribus a consequatur iusto illum eos facere vel iste iure maxime. Velit, rem, sunt obcaecati eveniet id nemo molestiae. In.</p>
					</div>
					<div class="col-lg-6 col-12">
						<h3>Latest News</h3>
						<hr>
						<div>
							<div class="media">
								<div class="media-body">
									<h4 class="mt-0 mb-1">Heading 1</h4>
									Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolorum, quod temporibus veniam deserunt deleniti accusamus voluptatibus at illo sunt quisquam. </div>
								<a href="#"><img class="ml-3" src="images/75X.gif" alt="placeholder image"></a> </div>
							<div class="media">
								<div class="media-body">
									<h4 class="mt-0 mb-1">Heading 2</h4>
									Lorem ipsum dolor sit amet, consectetur adipisicing elit. Illo, iure nemo earum quae aliquid animi eligendi rerum rem porro facilis. </div>
								<a href="#"><img class="ml-3" src="images/75X.gif" alt="placeholder image"></a> </div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-12 mt-md-0 mt-2">
				<h3>Contact Us</h3>
				<hr>
				<address>
					<strong>MyStoreFront, Inc.</strong><br>
					Indian Treasure Link<br>
					Quitman, WA, 99110-0219<br>
					<abbr title="Phone">P:</abbr> (123) 456-7890
				</address>
				<address>
					<strong>Full Name</strong><br>
					<a href="mailto:#">first.last@example.com</a>
				</address>
			</div>
		</div>
	</div>
	<footer class="text-center">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<p>Copyright © MyWebsite. All rights reserved.</p>
				</div>
			</div>
		</div>
	</footer>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap-4.3.1.js"></script>
	</body>
</html>