<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 <%@ page import="com.sanju.model.sanjanadept187,java.util.*" %>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Departments List through Spring ORM</title>

</head>

 <BODY BGCOLOR="green">

       <H1>Dept List from Spring ORM </H1>



      <TABLE BORDER="1">

      <TR>

      <TH>Dept No</TH>

      <TH>Dept Name</TH>

      <TH>Location</TH>

      </TR>

      <% 

      	

        List<sanjanadept187> dlist=(List<sanjanadept187>)request.getAttribute("dlist");

		for(sanjanadept187 d:dlist){

	  %>

      	<TR>

       		  <TD> <%= d.getDeptNo() %></td>

     		  <TD> <%= d.getDName() %></TD>

      		  <TD> <%= d.getLocation() %></TD>

      </TR>

      <% 

      	} 

      %>

     </TABLE>

     </BODY>

</html>

