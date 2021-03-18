<%@ include file = "header2.html" %>

<HTML>

<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.lang.*" %>
<%@ page session="true" %>
<%
	String rFrom = (String)session.getAttribute("rFrom");
	String rTo = (String)session.getAttribute("rTo");
	String JDate = (String)session.getAttribute("JDate");
	String sBusType = (String)session.getAttribute("BusType");
	String NoPass = (String)session.getAttribute("NoPass");
	int iNoPass=0;
	if(NoPass!=null){
		iNoPass= Integer.parseInt(NoPass);
	}
	String RouteId = (String)session.getAttribute("RouteId");
	String TravelsId = (String)session.getAttribute("TravelsId");
	String Travels = (String)session.getAttribute("Travels");
	String BusId = (String)session.getAttribute("BusId");
	String Fare =	(String)session.getAttribute("Fare");
	String Departure =	(String)session.getAttribute("Departure");
	String Arrival =	(String)session.getAttribute("Arrival");
	String SelSeats =  (String)session.getAttribute("SelSeats");		
	String BPoint = (String)session.getAttribute("BPoint");
	int CustomerId = (int)session.getAttribute("CustomerId");
	String TicketId =(String)session.getAttribute("TicketId");
	String PaymentId = (String)session.getAttribute("PaymentId");
%>
<head>

<script LANGUAGE="Javascript" SRC="Images/AjaxCall.js"></script>
<script LANGUAGE="Javascript" SRC="Images/validate.js"></script>

<SCRIPT LANGUAGE="JavaScript">
<!--
var SCount = 0;

	function setAction(URL,Obj){
		var f = document.forms(0);
		var ParamsList = "?";
		
		Obj.href=URL+ParamsList;
	}
	function fnSavePaymentDetails(Params)
	{
		var divObj = document.getElementById("infodiv");
		URL = "CreateTicket.jsp"+Params;
		//alert(URL);
		ajaxFunction(URL,divObj);
	}
//-->
</SCRIPT>


<head>
<body >
<HR>
<B><FONT COLOR="RED" face='verdana'><center>Confirmation</center></FONT></B>
<HR>
<BR><BR>
<FORM>
<%
/*Declaration of variables*/
Connection con=null;
Statement stmt=null,stmt1=null,stmt2=null;
ResultSet rs=null,rs1=null,rs2=null;
int count=0,NumRows=0;
boolean tflag=false;
try
{
	/*Connection to MySQL database is made with JDBC class one driver*/
	con = com.balaji.travels.ConnectionPool.getConnection();
	stmt =  con.createStatement();
	String Query = "update ticketdetails set CustomerId='"+CustomerId+"', PaymentId='"+PaymentId+"', Status='Booked' where TicketId='"+TicketId+"'";
	System.out.println("Final Qry->"+Query);
	int result = stmt.executeUpdate(Query);
	if( result > 0)	{
		System.out.println("Ticket saved");
		tflag=true;
		String Query1 = "update routemaster set availability = availability - "+iNoPass+" where RouteId='"+RouteId+"' and BusId='"+BusId+"'";
		System.out.println("Final Qry->"+Query1);
		int result1 = stmt.executeUpdate(Query1);
		if( result1 > 0)	{
			System.out.println("routemaster updated");
			tflag=true;
		}
		else{
			System.out.println("routemaster not updated");
			tflag=false;
		}
	}
	else{
		System.out.println("Ticket not saved");
		tflag=false;
	}
	
}
catch(Exception e)
{
	System.out.println("Exception"+e);
}
if(tflag==true){
%>
	
	<TABLE align=center width="50%">
	<TR class='row_title'>
		<TD colspan=2 align=center>Travel details</TD>
	</TR>
	<TR class='row_odd'>
		<TD>From</TD>
		<TD><%=rFrom%></TD>
	</TR>
	<TR class='row_odd'>
		<TD>To</TD>
		<TD><%=rTo%></TD>
	</TR>
	<TR class='row_odd'>
		<TD>Journey Date</TD>
		<TD><%=JDate%></TD>
	</TR>
	<TR class='row_odd'>
		<TD>Travels Name</TD>
		<TD><%=Travels%></TD>
	</TR>
	<TR class='row_odd'>
		<TD>Start Time</TD>
		<TD><%=Departure%></TD>
	</TR>
	<TR class='row_odd'>
		<TD>Reach Time</TD>
		<TD><%=Arrival%></TD>
	</TR>
	<TR class='row_odd'>
		<TD>No. of Passengers</TD>
		<TD><%=NoPass%></TD>
	</TR>
	<TR class='row_odd'>
		<TD>Seats</TD>
		<TD><%=SelSeats%></TD>
	</TR>
	<TR class='row_odd'>
		<TD>Boarding Point</TD>
		<TD><%=BPoint%></TD>
	</TR>
	<TR class='row_odd'>
		<TD>Net Ammount</TD>
		<TD>Rs. <%=Fare%></TD>
	</TR>
	</TABLE>
	

	<P align=center> <font color="black" size="4">PRINT TICKETS  >>> </font>
		<A onclick="fnEmpPopUp('PrintTicket.jsp?TicketId=<%=TicketId%>&Travels=<%=Travels%>',400,400)" ><IMG SRC="Images/printer.gif" border="0"
		onmouseout="this.src = 'Images/printer.gif'" 
		onmouseover="this.src = 'Images/printer.gif'"></A>
	</P>
	<P align=center>
		<A onclick="fnEmpPopUp('sendemail.jsp?TicketId=<%=TicketId%>&Travels=<%=Travels%>',400,400)" ><IMG SRC="Images/sendmail.png" border="0"
		onmouseout="this.src = 'Images/sendmail.png'" 
		onmouseover="this.src = 'Images/sendmail.png'"></A>
	</P>

<p align= left>
<center><a href="UserPage.jsp">HOME</a></center>

<%
	}
%>
</FORM>
</BODY>
</HTML>
