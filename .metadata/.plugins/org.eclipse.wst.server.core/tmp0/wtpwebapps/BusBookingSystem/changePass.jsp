

<%@ include file = "Header.html" %>

<%@ page language="java" %>
<%@ page session="true" %>
<%@ page import="java.sql.*,java.io.*,com.balaji.travels.MyFunctions"%>

<HEAD>


	<script LANGUAGE="Javascript" SRC="Images/validate.js"></script>


</HEAD>
<BODY class=SC>
<HR>
<B>
<HR>
<%

	Connection con=null;
	ResultSet rs=null;
	Statement stmt=null;
	//String CustomerId = request.getParameter("UId");
	String newpass = request.getParameter("pass");
	int CustomerId=(int)session.getAttribute("CustomerId");
	String forgotanswer=(String)session.getAttribute("forgotpanswer");
	String fanswer = request.getParameter("answer");
	System.out.println(CustomerId);
	System.out.println("fanswer="+fanswer);
	System.out.println("forgotanswer="+forgotanswer);
	
	int auth=0;	
	try{
			
			con = com.balaji.travels.ConnectionPool.getConnection();
			stmt =  con.createStatement();
	
			
			if (forgotanswer.equalsIgnoreCase(fanswer))
				
		
			{	
			
			String Query = "update contacts set Password='"+newpass+"' where CustomerId='"+CustomerId+"'"+"and forgotpanswer='"+forgotanswer+"'";
			
			
			int result = stmt.executeUpdate(Query);
			if( result > 0)	{
				%><P align=center><B><Font face="Georgia" color="Green">Password Changed Successfully.</Font></B></P><%
			}
			else{
				%><P align=center><B><Font face="Georgia" color="Red">Error: Please try again</Font></B></P><% 
			}
			stmt.close();
			con.close();
						
			}else{
				%><P align=center><B><Font face="Georgia" color="red">Wrong Security Answer. Please Try again</Font></B></P><%
			}
			
		}catch(Exception e){
			stmt.close();
			con.close();
			%><%=e%><%
		}
	
	
	
%>
<form method="get" action="UserPage.jsp">
   <center> <button type="submit">Continue</button></center>
</form>
</BODY>

