<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery.jqpagination.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/knockout.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	 
});
</script>
</head>
<body>
<div><a href="sign">Вход/регистрация</a></div>
<h4  align="center">Voting was created: <small>${votingDetails.createDateStr}</small></h4>
<c:choose>
    <c:when test="${votingDetails.createDate != null}">
        <h3 align="center">Days for voting termination: <small>${votingDetails.remainDaysCount}</small></h3>
    </c:when> 
    <c:otherwise>       
    </c:otherwise>   
</c:choose>
<h3 align="center">Всего проголосовавших: <small>${votingDetails.votesCount}</small></h3>
<div class="marginAuto width300">
<ul class="list-group">
  <li class="list-group-item list-group-item-success">
   <span class="badge">${votingDetails.votingResult.yesCount}</span>
     Yes
  </li>
  <li class="list-group-item list-group-item-danger">
    <span class="badge">${votingDetails.votingResult.noCount}</span>
    No
  </li>
  <li class="list-group-item list-group-item-warning">
    <span class="badge">${votingDetails.votingResult.abstainCount}</span>
    Abstain
  </li>
</ul>
</div>
<div class="marginAuto width600 questionDiv">	
	<h2>Question: <small>${votingDetails.question}</small></h2>		
	<p  class="bg-success"><input type="radio" value="radiobutton" name="radiobutton" > <span>I agree</span></p>
	<p	class="bg-danger"><input type="radio" value="radiobutton" name="radiobutton" ><span>I don't agree</span>
	<p 	class="bg-warning"><input type="radio" value="radiobutton" name="radiobutton" ><span>Abstain</span></p>
	<c:choose>
    <c:when test="${!votingDetails.votersList.contains('li')}">
        <button type="button" disabled="disabled" class="btn btn-warning">You have already voted</button>
    </c:when>
    <c:otherwise>
        <button class="btn btn-default" type="submit">Vote</button>
    </c:otherwise>
</c:choose>
	
</div>
<div class="imageDiv" align="center">
	<img src="resources/images/4.jpg"></img>
</div>


</body>

</html>