<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	
	var error="${error}";
	if (error!=null && error!=""){
		alert("error="+"${error}");
		$("#actionError").removeClass("hidden");
	}
	
	if ("${tab}"=="registration"){
		alert("tab= registration "+"${tab}");
		$("#tabRegister").addClass("active");
		$("#liRegister").addClass("active");
	}else{
		alert("tab= login "+"${tab}");
		$("#tabLogin").addClass("active");
		$("#liLogin").addClass("active");
	}
});

function clearErrors(){
	$(".errors").hide();
}
</script>
</head>
<body>
 	<div id="signDiv" class="width600 marginAuto paddingTop20" role="tabpanel" >
		<ul class="nav nav-tabs" role="tablist">
  			<li role="presentation" id="liLogin"><a href="#tabLogin"  aria-controls="tabLogin" role="tab" data-toggle="tab">Login</a></li>
 			<li role="presentation" id="liRegister"><a href="#tabRegister" aria-controls="tabRegister" role="tab" data-toggle="tab">Register</a></li> 		
		</ul>
		<div  class="tab-content paddingTop20">
			<div  role="tabpanel" class="tab-pane" id="tabLogin">
				<form:form class="form-horizontal width600" id="loginForm" data-toggle="validator" action="signIn" role="form" method="post" commandName="signInUser">
  					<div class="form-group">
    					<label for="signInEmail" class="col-sm-2 control-label">Email</label>
    					<div class="col-sm-10">
     						<form:input type="email" path="email"  class="form-control" id="signInEmail" placeholder="Email" required="true" onclick="clearErrors();"></form:input>
   							<form:errors path="email" class="errors"/>
   							<div class="help-block with-errors"></div>
   						</div>
 					</div>
  					<div class="form-group">
    					<label for="signInPassword" class="col-sm-2 control-label">Password</label>
    					<div class="col-sm-10">
      						<form:input type="password" path="password" class="form-control" id="signInPassword" placeholder="Password" required="true" onclick="clearErrors();"></form:input>
      						<form:errors path="password" class="errors"/>  
      						<div class="help-block with-errors"></div>   						
    					</div>    					
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-default">Sign in</button>
    					</div>
  					</div>
				</form:form>
			</div>
			<div  role="tabpanel" class="tab-pane" id="tabRegister">
				<form:form class="form-horizontal width600" id="registerForm" data-toggle="validator" action="signUp" method="post" commandName="signUpUser">
  					<div class="form-group">
    					<label for="signUpEmail" class="col-sm-2 control-label">Email</label>
    					<div class="col-sm-10">
     						<form:input type="email" path="email" class="form-control" id="signUpEmail" placeholder="Email" required="true" data-remote="checkUniqueEmail" data-remote-error="such login already exists"   onclick="clearErrors();"></form:input>
     						<form:errors path="email" class="errors"/>
   							<div class="help-block with-errors"></div>
   						</div>
 					</div>
  					<div class="form-group">
    					<label for="signUpPassword" class="col-sm-2 control-label">Password</label>
    					<div class="col-sm-10">
      						<form:input type="password" path="password" class="form-control" id="signUpPassword" placeholder="Password" required="true" onclick="clearErrors();"></form:input>
      						<form:errors path="password" class="errors"/>
      						<div class="help-block with-errors"></div>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="signUpPasswordConfirm" class="col-sm-2 control-label">Confirm password</label>
    					<div class="col-sm-10">
      						<form:input type="password" path="passwordConfirm" class="form-control" id="signUpPasswordConfirm" data-match="#signUpPassword" data-match-error="Whoops, these don't match" placeholder="PasswordConfirm" required="true" onclick="clearErrors();"></form:input>
      						<form:errors path="passwordConfirm" class="errors"/>
      						<form:errors path="samePasswords" class="errors"/>
      						<div class="help-block with-errors"></div>
    					</div>
  					</div>  					
  					<div class="form-group">
    					<label for="signUpBirthDate" class="col-sm-2 control-label">BirthDate</label>
    					<div class="col-sm-10">
      						<form:input type="datetime" path="birthDate" class="form-control" id="signUpBirthDate" placeholder="MM/DD/YYYY" required="true" onclick="clearErrors();"></form:input>
      						<form:errors path="birthDate" class="errors"/>
      						<div class="help-block with-errors"></div>
    					</div>
  					</div> 					
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-default">Sign up</button>
    					</div>
  					</div>  					
				</form:form>				
			</div>
		</div>	
		<div id="actionError" class="alert alert-danger alert-dismissible hidden" role="alert">
  					<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  					<strong>${error}</strong>
		</div>
	</div>
 
	<div class="imageDiv" align="center">
	<img src="resources/images/4.jpg"></img>
</div>
</body>
</html>