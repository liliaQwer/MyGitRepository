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
	
	function testModel(){
		var self=this;
		self.viewData=ko.observable();
		self.error=ko.observable();
		self.getData=function(){
			$.ajax({
		        url: "test",
		        type: "GET",
		         
		        beforeSend: function(xhr) {
		            xhr.setRequestHeader("Accept", "application/json");
		            xhr.setRequestHeader("Content-Type", "application/json");
		        },
		        success: function(data) {
		        	//debugger;
		        	alert (data.name);
		        	if(!data.error){
		        		alert (data.surname);
						self.viewData(data);
					}else{
						self.error(data.error);
					}      
		        }
		    });
			
		};
		self.getData();
	}
	var view = new testModel();
	ko.applyBindings(view);
	
	 
});
</script>
</head>
<body>
<div>
<table>
	<tr>
		<td>Name:</td>
		<td><span data-bind="text: viewData.name"></span></td>
	</tr>
	<tr>
		<td>Surname:</td>
		<td><span data-bind="text: viewData.name"></span></td>
	</tr>
	<tr>
		<td>Age:</td>
		<td><span data-bind="text: viewData.age"></span></td>
	</tr>
</table>
<span data-bind="text: error"></span>
</div>

</body>

</html>