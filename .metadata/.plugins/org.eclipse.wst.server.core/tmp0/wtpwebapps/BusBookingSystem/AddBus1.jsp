<%@ page language="java" %>
<%@ page session="true" %>
<%@ page import="java.sql.*,java.io.*,com.balaji.travels.MyFunctions"%>

<HEAD>


	<script LANGUAGE="Javascript" SRC="Images/validate.js"></script>


	<LINK href="styles.css" type="text/css" rel="stylesheet">

</HEAD>
<BODY class=SC>
<HR>
<B><FONT COLOR="#CC00CC" face='verdana'>Add Bus</FONT></B>
<HR>
<%

	Connection con=null;
	ResultSet rs=null;
	Statement stmt=null;
	String BusId = request.getParameter("BusId");
	/* MyFunctions MF = new MyFunctions();
	BusId = MF.genNextID("busmaster","BusId","B"); */
	String BusType = request.getParameter("BusType");	
	String BusNumber = request.getParameter("BusNumber");	
	String Capacity = request.getParameter("Capacity");	
	String TravelsId = request.getParameter("TravelsId");	
	try{
			
			con = com.balaji.travels.ConnectionPool.getConnection();
			stmt =  con.createStatement();
	
			String qry = "select max(`TravelsId`) from `travelsmaster`";
	        
	        ResultSet res_set = stmt.executeQuery(qry);
	       
	        
			 res_set.next();
		        
		       String TicketId = res_set.getString(1);
			String no = TicketId.substring(1).trim();
			BusId= "B"+(Integer.parseInt(no)+1);
			
			String Query = "Insert into busmaster values('"+BusId+"','"+BusType+"','"+BusNumber+"','"+Capacity+"','"+TravelsId+"')";
			int result = stmt.executeUpdate(Query);
			if( result > 0)	{
				%><P align=center><B><Font face="Georgia" color="Green">Bus added Successfully</Font></B></P><%
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
<center><input type=button value=close onclick="window.close()"></center>

</BODY>


