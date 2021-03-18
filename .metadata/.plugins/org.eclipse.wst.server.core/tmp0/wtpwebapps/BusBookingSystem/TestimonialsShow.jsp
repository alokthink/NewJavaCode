<%@ page language="java" %>
<%@ page session="true" %>
<%@ page import="java.sql.*,java.io.*,java.util.Random,com.balaji.travels.ConnectionPool"%>

<HEAD>


	<link href='stylehead.css' rel='stylesheet' type='text/css'>

	<script LANGUAGE="Javascript" SRC="Images/validate.js"></script>


	<LINK href="styles.css" type="text/css" rel="stylesheet">

</HEAD>
<BODY>
<h5 align=center>Testimonials</h5>

<tr align="center">
    <td> <div class="bg">
		
		<a href="User.html" class="button">Return Back</a>

<marquee scrollamount="1"  direction='up' scrolldelay='4'>
<table  width="100%">

<%

	Connection con=null;
	ResultSet rs=null;
	Statement stmt=null;
	try{
			
			//Class.forName("com.mysq.jdbc.Driver");
			con = com.balaji.travels.ConnectionPool.getConnection();
			stmt =  con.createStatement();
			String Query = "Select * from feedback order by `FId`";
			rs = stmt.executeQuery(Query);
			%>
						
							
			<%
			int rCount=0;
			while(rs.next())
			{
					%>
					
						<tr class= "row_odd">
							<th align="left"><%=rs.getString(2)%></th>
						</tr>
						<tr class="row_even">
							<td><%=rs.getString(3)%></td>
						</tr>
						</br>
					<%
				rCount++;
			}
			if( rCount == 0)	{%><P align=center color= "white"><I><B>No Testimonials</B></I></P><% }
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

</table>
</marquee>


			
			
		</div>
	</div></td>
  </tr>
</BODY>
