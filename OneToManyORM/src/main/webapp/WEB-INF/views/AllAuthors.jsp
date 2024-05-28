<%@page import="org.hibernate.internal.build.AllowSysOut"%>
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
<title>Details</title>
</head>
<body>
<%
List <Author> pd=(List<Author>) request.getAttribute("allusers");
Set<Book> a=null;
%>

<table style="border-collapse:collapse;width:50%;">
<thead>
<th>Author ID</th>
<th>Author Name</th>
<th>Book ID</th>
<th>Title</th>

</thead>
<%
for(Author p:pd)
	{
		System.out.println(p.getName());
		a=p.getBooks();
		System.out.println(a);
		for(Book b:a)
		{
			System.out.println(b.getTitle());
%>

<tbody>
  			<tr>
                <td><%= p.getId() %></td>
                <td><%= p.getName() %></td>
                <td><%= b.getId() %></td>
                <td><%= b.getTitle() %></td>
            </tr>
		
<%	 }
	}
%>	
</tbody>
</table>
</body>
</html>