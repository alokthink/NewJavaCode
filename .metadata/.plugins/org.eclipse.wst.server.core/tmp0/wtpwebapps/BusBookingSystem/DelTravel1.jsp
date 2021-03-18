<%@ include file = "header2.html" %>
<%@ page language="java" %>
<%@ page session="true" %>
<%@ page import="java.sql.*,java.io.*,java.util.Random"%>

<HEAD>


	<script LANGUAGE="Javascript" SRC="Images/validate.js"></script>


</HEAD>
<BODY class=SC>
<HR>
<B><FONT COLOR="#CC00CC" face='verdana'>Delete Travels</FONT></B>
<HR>
<%

	Connection con;
	ResultSet rs=null;
	Statement stmt=null;
	String id="";
	String Value = request.getParameter("TravelsId");
	//String Value2 = request.getParameter(""RouteId"");
	try{
			
			con=(Connection)session.getAttribute("connection");
			stmt =  con.createStatement();
	
			String q="select RouteId from routemaster where TravelsId='"+Value+"'";
			ResultSet rs1 = stmt.executeQuery(q);
			
			 while(rs1.next()){
		         //Retrieve by column name
		          id  = rs1.getString("RouteId");
			 }
			 System.out.print("id="+id);
			String Query = "Delete from travelsmaster where TravelsId='"+Value+"'";
			int result = stmt.executeUpdate(Query);
			if( result > 0)	{
				
				//delete busses associated
				String Query1  = "Delete from busmaster where TravelsId='"+Value+"'";
				int res = stmt.executeUpdate(Query1);
				//delete routes associated
				String Query2  = "Delete from routemaster where TravelsId='"+Value+"'";
				int res1 = stmt.executeUpdate(Query2);
				
				
				if(res!=0){System.out.print("enter if"); 
				if(res1>0)
				{System.out.print("delete pickup");
					String Query3  = "Delete from routemap where RouteId='"+id+"'";
					int res2 = stmt.executeUpdate(Query3);
				}
					%><P align=center><font color="black"><B>Travels details deleted sucessfully</B></font></P><%
				}else
				{%>
					<P align=center><B>Travels details deleted sucessfully.....</B></FONT></P>
				<%}
					
			}
			else{
				%><P align=center><FONT COLOR="red"><B>Error in deletion..please try again</B></FONT></P>
				<center>
				<A href="DelTravel0.jsp"> Delete Travel </A>
				</center>
				<% 
			}
		}catch(Exception e){%><%=e%><%}
%>
</BODY>


