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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/knockout.js"></script>
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
	
	function record(or,th,vt,au){
		this.orderNum= or;
		this.theme= th;
		this.voteCount= vt;
		this.author= au;
	}
	var rec1 = new record(1,"Запись 1", 2, "Li");
	var rec2 = new record(2,"Запись 2", 3, "Li");
	var someData=[rec1,rec2];
	
	function tableViewModel(data){
		var self = this;
		
		self.viewData = ko.observableArray(data);
		self.totalVoteCount = ko.computed(function(){
			return self.viewData().length;
		});
		//self.viewData = ko.observableArray([{orderNum : 1, theme: "Запись 1", voteCount: 1, author: "Я"},{orderNum : 2, theme: "Запись 2", voteCount: 5, author: "ЯЯ"}]);
		//self.orderNum = ko.observable();
		//self.theme = ko.observable();
		//self.voteCount = ko.observable();
		//self.author = ko.observable();
	}
	
	var view = new tableViewModel(someData);	
	ko.applyBindings(view);
	
	 
});
</script>
</head>
<body>
<div><a href="sign">Вход/регистрация</a></div>
<p align="center">Всего активных голосований: <span data-bind = "text: totalVoteCount"></span></p>
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
 	<tbody data-bind = "foreach: viewData">
 		<tr>
			<td data-bind = "text: orderNum">1</td>
			<td data-bind = "text: theme">Тема дня</td>
			<td data-bind = "text: voteCount">10</td>
			<td data-bind = "text: author">Автор я</td>
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