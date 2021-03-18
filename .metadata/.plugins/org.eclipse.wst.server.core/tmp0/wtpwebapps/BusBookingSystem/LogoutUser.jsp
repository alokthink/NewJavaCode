
<html>
<%@ page language="java" %>
<%@ page session="true" %>
<%@page import="java.sql.*,java.io.*,java.util.Random"%>
<%
	session.removeAttribute("userr");
	session.removeAttribute("connection");
	session.removeAttribute("auth");
	session.invalidate();
	response.sendRedirect("index.jsp");
	System.out.print(session);
%>
<body class="SC">

</body>
</html>