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
<BODY  scroll=yes>
<div class="col-xs-12 col-sm-3 col-md-4 col-lg-3">
			   <div class="news-box">
					<h2>View Customers</h2>
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
						<li ><a href="DelRoute0.jsp">Delete Routes</a></li>
						<li><a href="AddTravel0.jsp">Add Travels</a></li>
						<li ><a href="ViewTravels.jsp">View Travels</a></li>
						<li ><a href="DelTravel0.jsp">Delete Travels</a></li>
						<li class="active"><a href="ViewCustomers.jsp">View Customers</a></li>
						<li><a href="Logout.jsp">Logout</a></li>
						
						
					</ul>
					</div>
					<div class="clr"></div>
					
</div>

<HR>
<B><FONT COLOR="#CC00CC" face='verdana'>View Customers (USERS)</FONT></B>
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
			String Query = "Select CustomerID,first_name,last_name,email,password from contacts";
			rs = stmt.executeQuery(Query);
			%>
						
						<table align="center" width="60%" >
							<tr class=row_title><font color="black">
							<th ><center>Customer Id</center></th>
							<th ><center>Customer Name</center></th>
							<th ><center></center></th>
							<th><center>Email Id</center></th>
							<th><center>Password</center></th>
							
							</font>
							</tr>
					<%
			int rCount=0;
			while(rs.next())
			{   RouteId =rs.getString(1);
					%>
					<tr class= <%=(rCount%2!=0)? "row_even" : "row_odd"%>>
						
						<td align=center><%=rs.getString(1)%></td>
						<td align=center><%=rs.getString(2)%></td>
						<td align=center><%=rs.getString(3)%></td>
						<td align=center><%=rs.getString(4)%></td>
						<td align=center><%=rs.getString(5)%></td>
						
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

