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
List <Products> pd=(List <Products>)request.getAttribute("allproducts");
%>

<table style="border-collapse:collapse;width:50%;">
<thead>
<th>Item No</th>
<th>Item Name</th>
</thead>
<%
for(Products p:pd)
	{
%>

<tbody>
  			<tr>
                <td><%= p.getItemID() %></td>
                <td><%= p.getItemName() %></td>
            </tr>
		
<% } %>	
</tbody>
</table>
</body>
</html>