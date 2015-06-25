<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	
	function tableViewModel(){
		var self = this;
		self.hasError = ko.observable(false);
		self.paginationVisible = ko.observable(false);
		self.viewData = ko.observableArray();
		self.totalVoteCount = ko.observable();
		self.getData = function (page){
			$.getJSON("ajax/getActiveVoting",{page: page}, function(data){
				if (data){
					self.viewData(data.votingList);
					if(data.maxPage > 0){
						self.paginationVisible(true);
						initPagination(data.maxPage, data.currentPage);
					}else{
						self.paginationVisible(false);
					}					
				}		
			}).fail(function(){
				self.hasError(true);				
			});
		};
		self.getTotalCount = function(){
			$.getJSON("ajax/getTotalVoting", function(data){				
				self.totalVoteCount(data);				
			}).fail(function(){
				self.hasError(true);				
			});
		};				
		self.getTotalCount();
		
		self.getData(1);
	}
	
	var view = new tableViewModel();
	ko.applyBindings(view);
	
	function initPagination(maxPage, currentPage){
		debugger;
		$('.pagination').jqPagination({
			max_page: maxPage || 0,
			current_page: currentPage || 0,
			page_string: 'Page {current_page} of {max_page}', 
	   	 	paged: function(page) {
	   	 		view.getData(page);
	   	 }
		});
	}
});
</script>
</head>
<body>
<c:choose>
	<c:when test="${pageContext.request.userPrincipal.name != null}">
		<div class="margin10"><a href="<c:url value="/j_spring_security_logout" />" > Logout</a> </div>
	</c:when>
	<c:otherwise>
		<div class="margin10"><a href="sign">Sign in/Sign up</a></div>
	</c:otherwise>	   
</c:choose>

<a href="<c:url value="/ajax/test?email='li'&password='111'" />" > Test</a>

<p align="center">Total vote count: <span data-bind = "text: totalVoteCount"></span></p>

<div class="tableDiv width850">
<table class="table table-bordered table-hover" align="center">
	<thead>
		<tr>
			<td class="text-center">Vote</td>
			<td class="text-center">Theme</td>
			<td class="text-center">Vote count</td>
			<td class="text-center">Author</td>
		</tr>
	</thead>
 	<tbody data-bind = "foreach: viewData">
 		<tr>
			<td  class="text-center"><a data-bind="attr: {href: 'votingDetails/?' + id}"> <img src="resources/images/voteLink.png"/></a> </td>
			<td data-bind = "text: question"></td>
			<td data-bind = "text: voteCount"></td>
			<td data-bind = "text: owner"></td>
		</tr>		
 	</tbody>
</table>
</div>
<div align="center">
	<div class="pagination" data-bind="css : {hidden: !paginationVisible()}" >
   	 	<a href="#" class="first" data-action="first">&laquo;</a>
    	<a href="#" class="previous" data-action="previous">&lsaquo;</a>
    	<input type="text" readonly="readonly" data-max-page="40" />
    	<a href="#" class="next" data-action="next">&rsaquo;</a>
    	<a href="#" class="last" data-action="last">&raquo;</a>
	</div>
	<div id="errorDiv" data-bind = "css: {hidden: !hasError()}" class="alert alert-danger alert-dismissible  width850"   role="alert">
  		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  		<strong id="errorSpan">Something went wrong</strong>
	</div>
</div>
<div class="imageDiv" align="center">
	<img src="resources/images/4.jpg"></img>
</div>

</body>
</html>