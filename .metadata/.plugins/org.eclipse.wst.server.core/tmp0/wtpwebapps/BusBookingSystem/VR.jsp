<%@ include file = "header2.html" %>


<%@ page language="java" %>
<%@ page session="true" %>
<%@ page import="java.sql.*,java.io.*,java.util.Random"%>
<% String RouteId="";%>

<HEAD>


	<script LANGUAGE="Javascript" SRC="Images/validate.js"></script>

<SCRIPT LANGUAGE="JavaScript">
	<!--
		function fnShowDetails(RouteId,U)
			{
				var URL = U+"?RouteId="+RouteId;
				fnEmpPopUp(URL,300,400);
			}
	//-->
	</SCRIPT>
	
</HEAD>
<BODY >
<div class="col-xs-12 col-sm-3 col-md-4 col-lg-3">
			   <div class="news-box">
					<h2>View Routes</h2>
					<div class="main-hr">
						<div class="color1hr"></div>
						<div class="color2hr"></div>
						<div class="color3hr"></div>
						<div class="color4hr"></div>
					</div>
					<ul class="sideNav2">
						
						
						 <li class="active"><a href="VR.jsp">View Routes</a></li>
						
					</ul>
					</div>
					<div class="clr"></div>
					
</div>
		
<HR>

<HR>    
<%

	Connection con=null;
	ResultSet rs=null;
	Statement stmt=null;
	try{
			
			con = com.balaji.travels.ConnectionPool.getConnection();
			stmt =  con.createStatement();
			String Query = "Select * from routemaster";
			rs = stmt.executeQuery(Query);
			%>
						<table align="center" width="100%">
							<tr class=row_title>
							
							<th align="center">From</th>
							<th align="center">To</th>
							
							<th align="center">BusId</th>
							<th align="center">Departure</th>
							<th align="center">Arrival</th>
							<th align="center">Fare</th>
							<th align="center">Date</th>
							<th align="center">Availability</th>
							<th align="center" colspan=2>PickUp Points</th>

							</tr>
					<%
			int rCount=0;
			while(rs.next())
			{   RouteId =rs.getString(1);
					%>
					<tr class= <%=(rCount%2!=0)? "row_even" : "row_odd"    %>>  <%//even odd row color %>
						
						<td align=center><%=rs.getString(2)%></td>
						<td align=center><%=rs.getString(3)%></td>
						
						<td align=center><%=rs.getString(5)%></td>
						<td align=center><%=rs.getString(6)%></td>
						<td align=center><%=rs.getString(7)%></td>
						<td align=center><%=rs.getString(8)%></td>
						<td align=center><%=rs.getString(9)%></td>
						<td align=center><%=rs.getString(10)%></td>
						 <td align=center><A style="cursor:hand" onclick="fnShowDetails('<%=RouteId%>','ViewPickupPoints.jsp')">View</A></td>
						
						
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



