<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="zxx">
<head>
	<title>Home</title>
	<!-- Meta tag Keywords -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8" />
	<meta name="keywords" content=""/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<!-- Meta tag Keywords -->
	<!-- css files -->
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<!-- Style-CSS -->
	<link rel="stylesheet" href="css/fontawesome-all.css">
	<!-- Font-Awesome-Icons-CSS -->
	<!-- //css files -->
	<!-- web-fonts -->
	<link href="http://maxcdn.bootstrapcdn.com/css?family=Josefin+Sans:100,100i,300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
	<link href="http://maxcdn.bootstrapcdn.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
	<!-- //web-fonts -->
</head>

<body>
	<!-- bg effect -->
	<div id="bg">
		<canvas></canvas>
		<canvas></canvas>
		<canvas></canvas>
	</div>
	<!-- //bg effect -->
	<!-- title -->
	<h1>Effect Login Form</h1>
	<!-- //title -->
	<!-- content -->
	<div class="sub-main-w3">
	<%
				Cookie[]  c=request.getCookies();
				if(c !=null) {
					for(Cookie  co:c) {
						if("name".equals(co.getName())) {
							String  name=co.getValue();
							request.setAttribute("name", name);
						}
						if("pwd".equals(co.getName())) {
							String  pwd=co.getValue();
							request.setAttribute("pwd", pwd);
						}
					}
				}
			%>
			${msg}
		<form:form action="tologin" method="post"   modelAttribute="user">
			<h2>Login Now
				<i class="fas fa-level-down-alt"></i>
			</h2>
			<div class="form-style-agile">
				<label>
					<i class="fas fa-user"></i>
					Username
				</label>
				<form:input path="account"   placeholder="Account" value="${name}"/><br/>
				<form:errors path="account"></form:errors><br/>
			</div>
			<div class="form-style-agile">
				<label>
					<i class="fas fa-unlock-alt"></i>
					Password
				</label>
				<form:password path="pwd"   placeholder="密码*" value="${pwd }"/><br>
				<form:errors path="pwd"></form:errors><br>
			</div>
			<!-- checkbox -->
			<div class="wthree-text">
				<ul>
					<li>
						<label class="anim">
							<input type="checkbox" class="checkbox" name="check" >
							<span>Stay Signed In</span>
						</label>
					</li>
				</ul>
			</div>
			<!-- //checkbox -->
			<input type="submit" value="Log In">
		</form:form>
	</div>
	<!-- //content -->

	<!-- copyright -->
	<div class="footer">
		<p>Copyright &copy; 2018.Company name All rights reserved.</p>
	</div>
	<!-- //copyright -->

	<!-- Jquery -->
	<script src="js/jquery-3.3.1.min.js"></script>
	<!-- //Jquery -->

	<!-- effect js -->
	<script src="js/canva_moving_effect.js"></script>
	<!-- //effect js -->

</body>

</html>