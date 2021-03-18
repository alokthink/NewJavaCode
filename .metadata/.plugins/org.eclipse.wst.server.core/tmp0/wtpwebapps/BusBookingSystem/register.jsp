<%@ page language="java" %>
<%@ page session="true" %>
<%@ page import="java.sql.*,java.io.*,com.balaji.travels.MyFunctions"%>

<HEAD>


	<script LANGUAGE="Javascript" SRC="Images/validate.js"></script>


	<LINK href="styles.css" type="text/css" rel="stylesheet">

</HEAD>
<BODY class=SC>
<HR>
<B><FONT COLOR="#CC00CC" face='verdana'>Add User</FONT></B>
<HR>
<%

	Connection con=null;
	ResultSet rs=null;
	Statement stmt=null;
	//String CustomerId = request.getParameter("UId");
	String cname = request.getParameter("cname");
	/* MyFunctions MF = new MyFunctions();
	BusId = MF.genNextID("busmaster","BusId","B"); */
	String upass = request.getParameter("pass");	
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	String pin = request.getParameter("pin");
	String phone = request.getParameter("phone");	
	int auth=0;	
	try{
			
			con = com.balaji.travels.ConnectionPool.getConnection();
			stmt =  con.createStatement();
	
			

			String qry = "select max(`CustomerId`) from `customermaster`";
	        
	        ResultSet res_set = stmt.executeQuery(qry);
	       
	        
			 res_set.next();
		        
		       String CustomerId = res_set.getString(1);
			String no = CustomerId.substring(1).trim();
			CustomerId= "C"+(Integer.parseInt(no)+1);
			
			String Query = "Insert into customermaster values('"+CustomerId+"','"+cname+"','"+upass+"','"+email+"','"+phone+"','"+auth+"','"+address+"','"+pin+"')";
			int result = stmt.executeUpdate(Query);
			if( result > 0)	{
				%><P align=center><B><Font face="Georgia" color="Green">user added Successfully. Please Login to continue</Font></B></P><%
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
<form method="get" action="index.jsp">
   <center> <button type="submit">Continue</button></center>
</form>
</BODY>


