<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <content tag="local_link_boardlogin"> -->
	<link rel="stylesheet"
	href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<link rel="stylesheet"
	href="resources/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
	<link rel="stylesheet"
	href="resources/bootstrap-3.3.7-dist/css/itschool.css">
	<link rel="stylesheet"
	href="resources/bootstrap-3.3.7-dist/css/font-awesome.min.css">
<!-- </content> -->
<!-- <content tag="local_script_boardlogin1"> -->
	<script src="resources/js/jquery-3.1.1.min.js"></script>
	<script src="resources/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	<script src="resources/bootstrap-3.3.7-dist/js/parsley.min.js"></script>
<!-- </content> -->
</head>

<body class="div-bgcolor-gray">
<form id="login_form" name="login_form"  class="form-horizontal" enctype="multipart/form-data" action="loginup" method="POST" role="form" data-parsley-validate="true">
	<div class="contatiner">
<!-- 	  <span class="text-success text-center"><h1>L O G I N </h1></span> -->
	  <br><br>
		<div class="row">
			<div class="col-md-4"><span></span></div>
			<div class="col-md-3">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user" aria-hidden="true"></i></span>
					<input id="email" name="email" class="form-control" type="text" size="16" placeholder="email" autocomplete="off"
					required="" data-parsley-error-message="please insert your Email" data-parsley-errors-container="div[id='validateEmail']" />
				</div>
				<div id="validateEmail" style="color:#ff0000"></div>
				<br>
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-unlock-alt" aria-hidden="true"></i></span>
					<input name="password" id="password" class="form-control" type="password" size="16" placeholder="PASSWORD" autocomplete="off"
					required="true" data-parsley-error-message="please insert your PASSWORD" data-parsley-errors-container="div[id='validatePassword']" />
				</div>
				<div id="validatePassword" style="color:#ff0000"></div>
				
			</div>
			<button id="login" name="login" type="submit" style="WIDTH: 60pt; HEIGHT: 65pt" class="btn btn-primary">Login</button>
		</div>
<!-- 		</div> -->
		<br>
		<div class="row">
			<div class="col-md-4"><span></span></div>
			<div class="col-md-3">
					<label>
					<input type="checkbox" value=""> 아이디 기억하기
					</label>
					</div>
					
					 <div class="col-md-offset-2">
					<button id="" name="" type="button" class="btn btn-success">회원가입</button>
					</div>
			</div>
			</div>
		
</form>	
</body>
</html>