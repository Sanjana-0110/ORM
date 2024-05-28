<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,com.spring.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
th{
	justify-content: center;
}
td{
padding:5px; 
  text-align: center;
}
</style>
<title>All Products</title>
</head>
<body>
<%
List <User> pd=(List <User>)request.getAttribute("allusers");
Address a;
%>

<table style="border-collapse:collapse;width:50%;">
<thead>
<th>User ID</th>
<th>User Name</th>
<th>Street</th>
<th>City</th>
</thead>
<%
for(User p:pd)
	{
		a=p.getAddress();
%>

<tbody>
  			<tr>
                <td><%= p.getId() %></td>
                <td><%= p.getName() %></td>
                <td><%= a.getCity() %></td>
                <td><%= a.getStreet() %></td>
            </tr>
		
<% } %>	
</tbody>
</table>
</body>
</html>