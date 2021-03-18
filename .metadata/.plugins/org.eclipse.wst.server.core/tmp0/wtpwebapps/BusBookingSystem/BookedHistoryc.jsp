<%@ include file = "header2.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%String uid=(String)session.getAttribute("uid");
    int CustomerId=(int)session.getAttribute("CustomerId");
    System.out.println(CustomerId);
   String name1=(String)session.getAttribute("fname");
   String lname=(String)session.getAttribute("lname");
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.lang.*" %>

 <HEAD>
  <TITLE> Home Page </TITLE>
    	
    	<SCRIPT LANGUAGE="JavaScript">
<!--
	function setAction(URL,Obj){
		var f = document.forms(0);
		var Route = f.Route;
		
		var ParamsList = "?";
		Obj.href=URL+ParamsList;
		var TicketId1 = document.subform.TicketId.value;
		session.setAttribute(TicketID1);
	}
//-->
</SCRIPT>

 </HEAD>

 <BODY >
 
 <div class=main-content  >
         <div class=container>	
 <div class="col-xs-12 col-sm-3 col-md-4 col-lg-3">
			   <div class="news-box">
					<h2>HomePage</h2>
					<div class="main-hr">
						<div class="color1hr"></div>
						<div class="color2hr"></div>
						<div class="color3hr"></div>
						<div class="color4hr"></div>
					</div>
					<ul class="sideNav2">
						
						<li ><a href="UserPage.jsp">Home</a></li>
						 <li><a href="VR.jsp">View Routes</a></li>
						<li><a href="SearchBus.jsp">Book Tickets</a></li>
						<li ><a href="BookedHistory.jsp">View Booked History</a></li>
						<li class="active"><a href="BookedHistoryc.jsp">Cancel Tickets</a></li>
						<li><a href="Feedback.jsp">Give Testimonials</a></li>
						<li><a href="changepass0.jsp">Change Password</a></li>
						<li><a href="LogoutUser.jsp">Logout</a></li>
						
					</ul>
					</div>
					<div class="clr"></div>
					
</div>
<div class="col-xs-12 col-sm-8">
		
		<h2><marquee behavior="alternate" scrollamount=3><FONT Face='Georgia' COLOR="#FF0099" >Welcome &nbsp <%=name1%> &nbsp <%=lname%></FONT></marquee></h2>
		</br>
		</br>
			<FORM ACTION="">
<TABLE class='notepad' align='center'>
			
<%

Connection con=null;
Statement stmt=null;
ResultSet rs=null;

try{
	con = com.balaji.travels.ConnectionPool.getConnection();
	stmt =  con.createStatement();
	stmt =  con.createStatement();
	String C1="C1";
	String Query = "Select TicketId,rFrom,rTo,JourneyDate from ticketdetails Where CustomerId= '"+CustomerId+"'";
	System.out.println(" Qry->"+Query);
	rs = stmt.executeQuery(Query);
	int count=0,NumRows=0;
	
	
	
	while(rs.next()){NumRows++;}
	rs.beforeFirst();
	if(NumRows>0){
		//Display header
		%>
			<TR class="row_title">
				<TD>Select</TD>
				<TD>Ticket Id</TD>
				<TD>From</TD>
				<TD>Booking To</TD>
				<TD>Journey DateTD</TD>
				
			</TR>	
		<%
		while(rs.next())
			{
					//Display body
					String TicketId=rs.getString(1);
					//session.setAttribute("TicketNo",TicketId);
					String from=rs.getString(2);
					String to=rs.getString(3);
					String date=rs.getString(4);
					System.out.println(TicketId);
					
					
					%>
						<TR class="<%=(count%2==0)? "row_odd" : "row_even" %>" >
							<TD><INPUT TYPE="radio" NAME="TicketId" Value="<%=TicketId%>"> </TD>
							<TD><%=TicketId%>
							<TD><%=from%>
							<TD><%=to%>
							<TD><%=date%>
							
						</TR>
					<%
				count++;
			}
			%>
			
					</TABLE>
					
			<%
	
	
	
	
	}else{
		%> <P align='CENTER'><IMG SRC="Images/error.gif" WIDTH="17" HEIGHT="13" BORDER="0" ALT=""><FONT COLOR="red" face='Georgia' size='6'><b>No tickets found. Please Book Now And Continue</b></FONT><BR>
			
		</P>
		
		<%
	}
	
}
catch(Exception e)
{System.out.println(" catch");
	System.out.println("Exception"+e);
}
%>	


</TABLE>
					
</form>
</div>
</div>
</div>
 </BODY>
</HTML>
 <%@ include file = "CancelTicket_S1.jsp" %>