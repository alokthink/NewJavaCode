

<%@ include file = "Header.html" %>



<%@ page language="java" %>
<%@ page session="true" %>
<%@ page import="java.sql.*, java.io.*, java.util.Random, com.balaji.travels.*"%>
<html>
<HEAD>


	<script LANGUAGE="Javascript" SRC="Images/validate.js"></script>


	

</HEAD>
<BODY>
<h2 align=center style="color:Red; font-family: Ariel; font-size: 250%;">Testimonials</h2>

<%

	Connection con=null;
	ResultSet rs=null;
	Statement stmt=null;
	try{
			
			
			con = ConnectionPool.getConnection();
			stmt =  con.createStatement();

			String Query = "Select Feedback from feedback order by `FId`";
			rs = stmt.executeQuery(Query);
			%><marquee direction = "up" scrollamount="3" scrollspeed="100">
						<table align="center" width="100%">
						
					<%
			int rCount=0;
			while(rs.next())
			{
					%>
					<tr class= <%=(rCount%2!=0)? "row_even" : "row_odd"%>>
						<td><%=rs.getString(1)%></td>
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
</html>
<%@ include file = "footer.html" %>