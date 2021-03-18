

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
	
	String fname=request.getParameter("firstName");
	String lname=request.getParameter("lastName");
	
	//photo
	
	String mail=request.getParameter("email");
	
	String phone=request.getParameter("mob");
	String address=request.getParameter("address");
	System.out.println("address"+address);
	String pin= request.getParameter("pin");
	
	String gender= request.getParameter("gender");
	String dateinfos= request.getParameter("birthDate");
	int CustomerId=(int)session.getAttribute("CustomerId");
	
	System.out.println(CustomerId);
		
	int auth=0;	
	try{
			
			con = com.balaji.travels.ConnectionPool.getConnection();
			stmt =  con.createStatement();
	
				
			
			//String Query = "update contacts set Password='"+newpass+"' where CustomerId='"+CustomerId+"'"+"and forgotpanswer='"+forgotanswer+"'";
			String Query = "update  contacts  set first_name='"+fname+"' ,last_name='"+lname+"' ,email='"+mail+"' ,phone='"+phone+"' ,address='"+address+"' ,pin='"+pin+"' ,gender='"+gender+"' ,dateinfos='"+dateinfos+"'   where CustomerId='"+CustomerId+"'";
	
			
			int result = stmt.executeUpdate(Query);
			if( result > 0)	{
				%><P align=center><B><Font face="Georgia" color="Green">Profile Edited Successfully.</Font></B></P><%
			}
			else{
				%><P align=center><B><Font face="Georgia" color="Red">Error: Please try again</Font></B></P><% 
			}
			stmt.close();
			con.close();
						
			
			
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

