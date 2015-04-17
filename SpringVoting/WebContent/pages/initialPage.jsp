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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery.jqpagination.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('.pagination').jqPagination({
		max_page: 5,
		current_page: 1,
		page_string: 'Page {current_page} of {max_page}', 
   	 paged: function(page) {
  	 	    // do something with the page variable
   	 }
	});
});
</script>
</head>
<body>
<div><span>Войти</span></div>
<div class="tableDiv width850">
<table class="table table-hover" align="center">
	<thead>
		<tr>
			<td>№</td>
			<td>Тема</td>
			<td>Число проголосовавших</td>
			<td>Автор</td>
		</tr>
	</thead>
 	<tbody>
 		<tr>
			<td>1</td>
			<td>Тема дня</td>
			<td>10</td>
			<td>Автор я</td>
		</tr>
		<tr>
			<td>2</td>
			<td>Тема вечера</td>
			<td>100</td>
			<td>Автор я</td>
		</tr>
 	</tbody>
</table>
</div>
<div align="center">
<div class="pagination" >
    <a href="#" class="first" data-action="first">&laquo;</a>
    <a href="#" class="previous" data-action="previous">&lsaquo;</a>
    <input type="text" readonly="readonly" data-max-page="40" />
    <a href="#" class="next" data-action="next">&rsaquo;</a>
    <a href="#" class="last" data-action="last">&raquo;</a>
</div>
</div>
<div class="imageDiv" align="center">
	<img src="resources/images/4.jpg"></img>
</div>
</body>
</html>