<%@ include file = "header2.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%String uid=(String)session.getAttribute("uid");
    String CustomerId=(String)session.getAttribute("CustomerId");
    System.out.println(CustomerId);
   String name1=(String)session.getAttribute("username");
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
		var ch = document.getElementsByName('TicketNo');

		for (var i = ch.length; i--;) {
		    ch[i].onchange = function() {
		        alert(this.value);
		    }
		}
		
	}
//-->
</SCRIPT>

 </HEAD>

 <BODY >
		<BR>
		<H4>Welcome to BALAJI travels: Online bus reservation.</H4>
		<marquee behavior="alternate" scrollamount=3><FONT Face='Georgia' COLOR="#FF0099">Welcome <%=name1%></FONT></marquee>
		<H5>Salient Features</H5>
			<UL><font color="black">
				<LI>Book Bus tickets to more than 200 cities.
				<LI>Cancellation is possible on the net.
				<LI>Pay using Major Credit/Debit Card
			</font></UL>
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
	String Query = "Select TicketId,rFrom,rTo,JourneyDate from ticketdetails Where CustomerId= '"+C1+"'";
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
							<TD><INPUT TYPE="radio" NAME="TicketNo" Value="<%=TicketId%>"> </TD>
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
					<P align=right>
						<A onclick="setAction('ViewTicket.jsp',this)"><IMG SRC="Images/Continue1.jpg" border="0"
						onmouseout="this.src = 'Images/Continue1.jpg'" 
						onmouseover="this.src = 'Images/Continue2.jpg'"></A>
					</P>
			<%
	
	
	
	
	}else{
		%> <P align='CENTER'><IMG SRC="Images/error.gif" WIDTH="17" HEIGHT="13" BORDER="0" ALT=""><FONT COLOR="red" face='Georgia'>No tickets found.Please provide valid Ticket Id</FONT><BR>
			<A HREF="ViewMyTicket.jsp">&lt;&lt; Back</A>
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
 </BODY>
</HTML>
 