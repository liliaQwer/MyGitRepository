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
<div ><a href="sign">Вход/регистрация</a></div>
<div class="marginAuto width600 questionDiv">
<h4  align="left">Voting was created: <small>${votingDetails.createDateStr}</small></h4>
<c:choose>
    <c:when test="${votingDetails.endDate != null}">
        <h3 align="center">Days for voting termination: <small>${votingDetails.remainDaysCount}</small></h3>
    </c:when>       
</c:choose>
<div class="list-group">
  <a href="#" class="list-group-item active">${votingDetails.question}</a>
  <c:forEach items="${votingDetails.votingResult}" var="votingResult">
  	<a href="#" class="list-group-item"><c:out value="${votingResult.answer}"/><span class="badge pull-right"><c:out value="${votingResult.votesCount}"/></span></a>
  </c:forEach>  
</div>
<c:choose>
	<c:when test="${!votingDetails.enabled}">
       <h3 align="center"><span class="label label-default">This voting is finished</span></h3>
    </c:when>
    <c:otherwise>
    	<c:choose>
			<c:when test="${!votingDetails.isUserVoted(pageContext.request.userPrincipal.name)}">
				<div class="margin10" align="center"><button type="button" class="btn btn-primary">Vote</button></div>
			</c:when>
			<c:otherwise>
				<h3 align="center"><span class="label label-default">You have already voted</span></h3>
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>
</div>
<div class="imageDiv" align="center">
	<img src="resources/images/4.jpg"></img>
</div>
</body>
</html>