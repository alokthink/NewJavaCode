<%@ page language="java" %>
<%@ page session="true" %>
<%@ page import="java.sql.*,java.io.*,java.util.Random"%>
<%String RouteId=request.getParameter("RouteId");%>

<HEAD>


	<script LANGUAGE="Javascript" SRC="Images/validate.js"></script>


	<LINK href="styles.css" type="text/css" rel="stylesheet">

</HEAD>
<BODY >
<center><input type=button value=close onclick="window.close()"></center>

<HR>
<B><FONT COLOR="#CC00CC" face='verdana'>View PickUp Points</FONT></B>
<HR>
<%

	Connection con=null;
	ResultSet rs=null;
	Statement stmt=null;
	try{
		
			con = com.balaji.travels.ConnectionPool.getConnection();
			stmt =  con.createStatement();
			String Query = "Select * from routemap where RouteId='"+RouteId+"' ";
			rs = stmt.executeQuery(Query);
			System.out.println(RouteId);
			%>
						<table align="center" width="60%">
							<tr class=row_title>
							<th align="left">RouteId</th>
							<th align="left">PickupPoint</th>
							</tr>
					<%
			int rCount=0;
			while(rs.next())
			{
					%>
					
					
					<tr class= <%=(rCount%2!=0)? "row_even" : "row_odd"%>>
						<td><%=rs.getString(1)%></td>
						<td><%=rs.getString(2)%></td>
					</tr>
					
					
					<%
				rCount++;
			}
			
			if( rCount == 0)	{%><h3 align=center>Sorry No records Found</h3><% }
			rs.close();
			stmt.close();
			con.close();
		}catch(Exception e){
			rs.close();
			stmt.close();
			con.close();
			%><%=e%><%
		}
	
%>

</BODY>


