<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<content tag="local_link_memberinsert">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Member Page</title>

	<link rel="stylesheet" href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="resources/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="resources/bootstrap-3.3.7-dist/css/itschool.css">
	<link rel="stylesheet" href="resources/bootstrap-3.3.7-dist/css/font-awesome.min.css">
<!-- </content> -->
<!-- <content tag="local_script_memberinsert1"> -->
	<script src="resources/js/jquery-3.1.1.min.js"></script>
	<script src="resources/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	<script src="resources/bootstrap-3.3.7-dist/js/parsley.min.js"></script>
</content>
</head>
<content tag="local_script_memberinsert2">
<script type="text/javascript">
	function doReset() {
		document.insert_form.id.value = "";
		document.insert_form.password.value = "";
		document.insert_form.repassword.value = "";
		document.insert_form.name.value = "";
		document.insert_form.phone2.value = "";
		document.insert_form.phone3.value = "";
		document.insert_form.zipcode.value = "";
		document.insert_form.addr1.value = "";
		document.insert_form.addr2.value = "";
		document.insert_form.email.value = "";
		document.insert_form.email_domain.value = "";
		document.insert_form.cardno.value = "";
		document.insert_form.job.value = "";
	}
	$(document).ready(function() {
	
		$('#save').click(function(){
			if($('#confirm_check').val()=='no'){
				alert("ID중복 체크하세요");
				return;
			}
			$('#insert_form').submit();
		});
		
		$('#confirm').click(function(){
			var id = $('#id').val();
			if( id == "") {
				alert("ID를 입력하세요!");
				return;
			}
			$.ajax({
				type : 'POST',
				data : "id="+ id,
				dataType : 'json',
				url : 'idconfirm',
				success : function(data) {
					if(data==0){
						alert("사용가능한 ID입니다");
						$('#confirm_check').attr('value','yes');
					} else {
						alert("중복된 ID입니다");
					}
					return false;
				}
			});
		});
		
	});
</script>
</content>

<body class="div-bgcolor-gray" onload="doReset();">
<form id="insert_form" name="insert_form"  class="form-horizontal" enctype="multipart/form-data" action="memberInsert" method="POST" role="form" data-parsley-validate="true">
	<div class="contatiner">
	  <span class="text-success text-center"><h1>회 원 가 입 </h1></span>
	  <br><br>
		<div class="row">
			<div class="col-md-4"><span></span></div>
			<div class="col-md-3">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-envelope-o fa-fw" aria-hidden="true"></i></span>
					<input id="id" name="id" class="form-control" type="text" size="16" autofocus placeholder="@example.com" autocomplete="off"/>
					<span class="input-group-btn">
						<button id="confirm" type="button" class="btn btn-primary" >중복검사</button>
						<input id="confirm_check" type="hidden" value="no"/>
					</span>
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-key fa-fw" aria-hidden="true"></i></span>
					<input name="password" id="password" class="form-control" type="password" size="16" placeholder="PASSWORD" autocomplete="off"
					required="true" data-parsley-error-message="please insert your PASSWORD" data-parsley-errors-container="div[id='validatePassword']" />
				</div>
				<div id="validatePassword" style="color:#ff0000"></div>
				
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-key fa-fw" aria-hidden="true"></i></span>
					<input name="repassword" class="form-control" type="password" size="16" placeholder="REPASSWORD" autocomplete="off"
					required="true" data-parsley-error-message="please check Password and Repassword" data-parsley-equalto="#password" 
					data-parsley-errors-container="div[id='validateRePassword']" />
				</div>
				<div id="validateRePassword" style="color:#ff0000"></div>
				
				<br>
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user" aria-hidden="true"></i></span>
					<input name="name" class="form-control" type="text" size="30" placeholder="Insert NickName" autocomplete="off"/>
				</div>
				
				<br>
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-calendar" aria-hidden="true"></i></span>
					<input name="name" class="form-control" type="text" size="4" placeholder="Year" autocomplete="off"/>
					<span class="input-group-addon"><i class="fa fa-calendar" aria-hidden="true"></i></span>
					<input name="name" class="form-control" type="text" size="4" placeholder="Month" autocomplete="off"/>
					<span class="input-group-addon"><i class="fa fa-calendar" aria-hidden="true"></i></span>
					<input name="name" class="form-control" type="text" size="4" placeholder="Day" autocomplete="off"/>
				</div>
				
				<br>
				<div align="center">
					<button id="save" name="save" type="button" class="btn btn-success">회원가입</button>
					<span>&nbsp;&nbsp;</span>
					<span>&nbsp;&nbsp;</span>
					<button type="button" name="cancel" class="btn btn-default">취소</button>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
		
	</div>
</form>
</body>
</html>