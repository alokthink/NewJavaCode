<%@ include file = "header2.html" %>

<%@ page language="java" %>
<%@ page session="true" %>
<%@ page import="java.sql.*,java.io.*,java.util.Random"%>

<HEAD>



	<script LANGUAGE="Javascript" SRC="Images/validate.js"></script>


</HEAD>
<BODY class=SC>
<HR>
<B><FONT COLOR="#CC00CC" face='verdana'>Delete Route</FONT></B>
<HR>
<%

	Connection con;
	ResultSet rs=null;
	Statement stmt=null;
	String Value = request.getParameter("RouteId");
	try{
			
			con=(Connection)session.getAttribute("connection");
			stmt =  con.createStatement();
	
			
			String Query = "Delete from routemaster where RouteId='"+Value+"'";
			int result = stmt.executeUpdate(Query);
			if( result > 0)	{
				
				
					//delete busses associated
					String Query1  = "Delete from routemap where RouteId='"+Value+"'";
					int res = stmt.executeUpdate(Query1);
					if(res!=0){System.out.print("enter if"); 
					%><P align=center><B>Route deleted sucessfully</B></P><%
				}else
				{%>
				<P align=center><FONT color="black"><B>Route deleted sucessfully.....</B></FONT></P>
			<%}
				
			}
			else{
				%><P align=center><B>Error in deletion..please try again</B></P>
				<center>
				<A href="DelRoute0.jsp"> Delete Route </A>
				</center>
				<% 
			}
		}catch(Exception e){%><%=e%><%}
%>
</BODY>


