<%@ include file = "header2.html" %>
<%@ page language="java" %>
<%@ page session="true" %>
<%@ page import="java.sql.*,java.io.*,com.balaji.travels.MyFunctions"%>

<HEAD>


	<script LANGUAGE="Javascript" SRC="Images/validate.js"></script>

</HEAD>
<BODY class=SC>
<HR>
<B><FONT COLOR="#CC00CC" face='verdana'>Add Route</FONT></B>
<HR>
<%

	Connection con=null;
	ResultSet rs=null;
	Statement stmt=null;
	String RouteId = request.getParameter("RouteId");	
	//MyFunctions MF = new MyFunctions();
	//RouteId = com.balaji.travels.MyFunctions.genNextID("routemaster","RouteId","R");
	
	
	
	String rFrom = request.getParameter("rFrom");	
	String rTo = request.getParameter("rTo");
	String TravelsId = request.getParameter("TravelsId");
	String BusId = request.getParameter("BusId");
	String Departure = request.getParameter("Departure");
	String Arrival = request.getParameter("Arrival");	
	String Fare = request.getParameter("Fare");
	String JDate = request.getParameter("JDate");	
	int Availability = 40;	
	try{
			
			con = com.balaji.travels.ConnectionPool.getConnection();
			stmt =  con.createStatement();
	
			
			

		String qry = "select max(`RouteId`) from `routemaster`";
        
        ResultSet rs1 = stmt.executeQuery(qry);
        
        
        
        rs1.next();
        
       String RId = rs1.getString(1);
       if(RId==null)
       {System.out.print("enter if -blank id found");
    	   RId="T0"; 
       }
        String no = RId.substring(1).trim();
        
        RouteId = "R"+(Integer.parseInt(no)+1);

			
			String Query = "Insert into routemaster values('"+RouteId+"','"+rFrom+"','"+rTo+"','"+TravelsId+"','"+BusId+"','"+Departure+"','"+Arrival+"','"+Fare+"','"+JDate+"',"+Availability+")";
			int result = stmt.executeUpdate(Query);
			if( result > 0)	{
				%><P align=center><B><Font face="Georgia" color="Green">Route added Successfully</Font></B></P>
				<% 
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
</BODY>


