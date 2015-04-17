<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/resources/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/> 
<link href="${pageContext.request.contextPath}/resources/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/jquery-ui-1.10.4.custom.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/jqpagination.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-1.10.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-ui-1.10.4.custom.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/validator.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery.jqpagination.js"></script>
<script type="text/javascript">

$(function() {
	$("#loginForm").validator({
		delay:100,
		disable:true		
	});
	
	$("#registerForm").validator({
		delay:100,
		disable:true		
	});
		
});
</script>
</head>
<body>
 	<div id="signDiv" class="width600 marginAuto paddingTop20" role="tabpanel" >
		<ul class="nav nav-tabs" role="tablist">
  			<li role="presentation" class="active"><a href="#tabLogin"  aria-controls="tabLogin" role="tab" data-toggle="tab">Login</a></li>
 			<li role="presentation"><a href="#tabRegister" aria-controls="tabRegister" role="tab" data-toggle="tab">Register</a></li> 		
		</ul>
		<div  class="tab-content paddingTop20">
			<div  role="tabpanel" class="tab-pane active" id="tabLogin">
				<form class="form-horizontal width600" id="loginForm" data-toggle="validator" action="signIn" role="form" method="post">
  					<div class="form-group">
    					<label for="inputEmail" class="col-sm-2 control-label">Email</label>
    					<div class="col-sm-10">
     						<input type="email" name="email"  data-error="My data error for email" class="form-control" id="inputEmail" placeholder="Email" required>
   							<div class="help-block with-errors"></div>
   						</div>
 					</div>
  					<div class="form-group">
    					<label for="inputPassword" class="col-sm-2 control-label">Password</label>
    					<div class="col-sm-10">
      						<input type="password" name="password" class="form-control" id="inputPassword" placeholder="Password" required>   
      						<div class="help-block with-errors"></div>   						
    					</div>    					
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-default">Sign in</button>
    					</div>
  					</div>
				</form>
			</div>
			<div  role="tabpanel" class="tab-pane" id="tabRegister">
				<form class="form-horizontal width600" id="registerForm" data-toggle="validator" action="signUp" method="post">
  					<div class="form-group">
    					<label for="inputEmail" class="col-sm-2 control-label">Email</label>
    					<div class="col-sm-10">
     						<input type="email" name="email" class="form-control" id="inputEmail" placeholder="Email" required>
   							<div class="help-block with-errors"></div>
   						</div>
 					</div>
  					<div class="form-group">
    					<label for="inputPassword" class="col-sm-2 control-label">Password</label>
    					<div class="col-sm-10">
      						<input type="password" name="password" class="form-control" id="inputPassword" placeholder="Password" required>
      						<div class="help-block with-errors"></div>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="inputBirthDate" class="col-sm-2 control-label">BirthDate</label>
    					<div class="col-sm-10">
      						<input type="datetime" name="birthDate" class="form-control" id="inputBirthDate" placeholder="MM/DD/YYYY" required>
      						<div class="help-block with-errors"></div>
    					</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-default">Sign up</button>
    					</div>
  					</div>
				</form>
			</div>
		</div>	
	</div>
 
	<div class="imageDiv" align="center">
	<img src="resources/images/4.jpg"></img>
</div>
</body>
</html>