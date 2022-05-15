<%@page import="com.tutorial.demorest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// SAVE
	if (request.getParameter("inqId") != null) {	
		
		Inq Inquiry = new Inq();
		String statusMsg = "";
		
		String userId = request.getParameter("userId");
		String type = request.getParameter("type");
		String reason = request.getParameter("reason");
		
		
		if (request.getParameter("hidinqIdSave") == "") {
			statusMsg = Inquiry.insertItem(userId, type, reason);
		} else {
			statusMsg = Inquiry.updateItem(request.getParameter("hidinqIdSave"),userId, type, reason);
		}
		
		
		session.setAttribute("statusMsg", statusMsg);
	}

	// DELETE
	if (request.getParameter("hidinqIdSave") != null) {
		Inq Inquiry = new Inq();
		String statusMsg = Inquiry.deleteItem(request.getParameter("hidinqIdSave"));
		session.setAttribute("statusMsg", statusMsg);
	}
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="Views/bootstrap.min.css">
		<script src="Components/jquery-3.2.1.min.js"></script>
		<title>Inquiry Management</title>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col">
					<h1>Inquiry Management</h1>
					<form id="formItem" name="formItem" method="POST" action="Inq.jsp">
						User Id: 
						<input 
							id="userId" 
							name="userId" 
							type="text" 
							class="form-control form-control-sm"
						><br>

						Inquiry Type: 
						<input 
							id="type"
							name="type" 
							type="text" 
							class="form-control form-control-sm"
						><br>

						Reason: 
						<input 
							id="reason" 
							name="reason" 
							type="text" 
							class="form-control form-control-sm"
						><br>

						<input 
							id="btnSave" 
							name="btnSave" 
							type="button" 
							value="Add" 
							class="btn btn-primary"
						>

						<input type="hidden" name="hidItemIDSave" id="hidItemIDSave" value="">
					</form>
				
					<br>
					<div id="alertSuccess" class="alert alert-success">
						<% out.print(session.getAttribute("statusMsg")); %>
					</div>
					<div id="alertError" class="alert alert-danger"></div>
					<br>
					<%
						Inq Inquiry = new Inq(); 
						out.print(Inquiry.readItems());
					%>
				</div>
			</div>
		</div>
	</body>
</html>