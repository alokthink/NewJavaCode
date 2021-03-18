<%@ include file = "header2.html" %>
<%@ page language="java" %>
<%@ page session="true" %>
<%@ page import="java.sql.*,java.io.*,java.util.Random"%>
<% String TravelsId="";%>

<HEAD>


	<script LANGUAGE="Javascript" SRC="Images/validate.js"></script>


	<SCRIPT LANGUAGE="JavaScript">

	function fnShowDetails(TravelsId,U)
		{
			var URL = U+"?TravelsId="+TravelsId;
			fnEmpPopUp(URL,300,700);
		}
	
	</SCRIPT>
<SCRIPT LANGUAGE="JavaScript">
	
	</SCRIPT>
</HEAD>
<BODY >

<div class="col-xs-12 col-sm-3 col-md-4 col-lg-3">
			   <div class="news-box">
					<h2>View Travels</h2>
					<div class="main-hr">
						<div class="color1hr"></div>
						<div class="color2hr"></div>
						<div class="color3hr"></div>
						<div class="color4hr"></div>
					</div>
					<ul class="sideNav2">
						
						<li ><a href="AdminHome.jsp">Home</a></li>
						 <li ><a href="AddRoute0.jsp">Add Routes</a></li>
						<li ><a href="ViewRoutes.jsp">View Routes</a></li>
						<li><a href="DelRoute0.jsp">Delete Routes</a></li>
						<li><a href="AddTravel0.jsp">Add Travels</a></li>
						<li class="active"><a href="ViewTravels.jsp">View Travels</a></li>
						<li ><a href="DelTravel0.jsp">Delete Travels</a></li>
						<li><a href="#">View Customers</a></li>
						<li><a href="Logout.jsp">Logout</a></li>
						
						
					</ul>
					</div>
					<div class="clr"></div>
					
</div>
<HR>
<B><FONT COLOR="#CC00CC" face='verdana'>View Travels</FONT></B>
<HR>
<%
	Integer IAuth =(Integer)session.getAttribute("auth");
	int auth=-1;
	if(IAuth!=null){ auth= IAuth.intValue();}
	System.out.println("===Authentication=="+auth);
if(auth!=0){
	%><P align=center><IMG SRC="Images/error.gif" WIDTH="17" HEIGHT="13" BORDER="0" ALT=""><B><FONT COLOR="red">You are not authorized to access this page</FONT></B></P><%
}
else{
%>
<%

	Connection con=null;
	ResultSet rs=null;
	Statement stmt=null;
	
	try{
			
			con = com.balaji.travels.ConnectionPool.getConnection();
			stmt =  con.createStatement();
			String Query = "Select * from travelsmaster order by `TravelsId`";
			rs = stmt.executeQuery(Query);
			%>
	<table class=notebook align=center>
							<tr class=row_title>
							<th align="center">TravelsId</th>
							<th align="center">Travels </th>
							<th align="center">Location</th>
							<th align="center">Address</th>
							<th align="center">AgentName</th>
							<th align="center">PhoneNumber</th>
							<th align="center" colspan=2>Bus Details</th>

							</tr>
					<%
			int rCount=0;
			while(rs.next())
			{
						TravelsId=rs.getString(1);
					%>
					<tr class= <%=(rCount%2!=0)? "row_even" : "row_odd"%>>
						<td align=center><%=TravelsId%></td>
						<td align=center><%=rs.getString(2)%></td>
						<td align=center><%=rs.getString(3)%></td>
						<td align=center><%=rs.getString(4)%></td>
						<td align=center><%=rs.getString(5)%></td>
						<td align=center><%=rs.getString(6)%></td>
					    <td align=center><A style="cursor:hand" onclick="fnShowDetails('<%=TravelsId%>','ViewBuses.jsp')">View</A></td>
						<td align=center><A style="cursor:hand" onclick="fnShowDetails('<%=TravelsId%>','AddBus0.jsp')">Add</A></td>
						
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

<%}%>
