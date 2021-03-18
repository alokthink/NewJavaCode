<%@ include file = "header2.html" %>


<HTML>

<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.lang.*" %>

<%@ page session="true" %>
<%
	String rFrom = (String)session.getAttribute("rFrom");
	String rTo = (String)session.getAttribute("rTo");
	int CustomerId= (int)session.getAttribute("CustomerId");
	String JDate = (String)session.getAttribute("JDate");
	String sBusType = (String)session.getAttribute("BusType");
	String NoPass = (String)session.getAttribute("NoPass");
	String RouteId = (String)session.getAttribute("RouteId");
	String TravelsId = (String)session.getAttribute("TravelsId");
	String BusId = (String)session.getAttribute("BusId");
	String Fare =	(String)session.getAttribute("Fare");
	String Departure =	(String)session.getAttribute("Departure");
	String Arrival =	(String)session.getAttribute("Arrival");
	String SelSeats = request.getParameter("SS");
	session.setAttribute("SelSeats",SelSeats);		
	String BPoint = request.getParameter("BPoint");	
	session.setAttribute("BPoint",BPoint);
	
	
	
	
	

%>
<head>

<script LANGUAGE="Javascript" SRC="Images/AjaxCall.js"></script>
<SCRIPT LANGUAGE="JavaScript">
<!--
var SCount = 0;

	function setAction(URL,Obj){
		var f = document.forms(0);
		var ParamsList = "?";
		
		Obj.href=URL+ParamsList;
	}
		function ChkMandatoryField(F,T){
			var val= F.value;
			if(val==""){alert(T+" is mandatory");return false;}
		}
		function ChkNumField(F,T){
			var val = F.value;
			var pattern = /^([0-9]{10})$/;
			if(!(pattern.test(val)==true)){alert("Please enter valid "+T);return false;}
		}
		function ChkAlphaNumericField(F,T){
			var val = F.value;
			var pattern = /^([a-zA-Z0-9]{1,250})$/;
			if(!(pattern.test(val)==true)){alert("Please enter alphabets or numbers for "+T);return false;}
		}
		function ChkAlphaField(F,T){
			var val = F.value;
			var pattern = /^([a-zA-Z ]{1,250})$/;
			if(!(pattern.test(val)==true)){alert("Please enter text for "+T);return false;}
		}
		function ChkEmailField(F,T){
			var val = F.value;
			var pattern = /^[a-zA-Z0-9\-\.\_ ]+\@[a-zA-Z0-9 \-\.]+\.([a-zA-Z]{2,4})$/;
			if(!(pattern.test(val)==true)){alert("Please enter valid email for "+T);return false;}
		}
		function ChkDateField(F,T)
		{
			var val = F.value;
		    var pattern = /^[0-9]{4}-[0-9]{2}-[0-9]{2}$/;
		    if(!(pattern.test(val)==true)){alert("Please enter valid date format (yyyy-mm-dd) for "+T);return false;}
		}

		function validate()
		{
			var frm = document.forms(0);
			if(ChkMandatoryField(frm.CustomerName,'Customer Name')==false) return false;
			if(ChkAlphaField(frm.CustomerName,'Customer Name')==false) return false;
			if(ChkMandatoryField(frm.PhoneNumber,'Phone Number')==false) return false;
			if(ChkNumField(frm.PhoneNumber,'Phone Number')==false) return false;
			if(ChkMandatoryField(frm.Address,'Address')==false) return false;
			if(ChkMandatoryField(frm.Location,'Location')==false) return false;
			if(ChkAlphaField(frm.Location,'Location')==false) return false;
			if(ChkMandatoryField(frm.email,'email')==false) return false;
			if(ChkEmailField(frm.email,'email')==false) return false;
			if(ChkMandatoryField(frm.Gender,'Gender')==false) return false;
			if(ChkAlphaField(frm.Gender,'Gender')==false) return false;
			Params="?CustomerName="+frm.CustomerName.value+"&PhoneNumber="+frm.PhoneNumber.value+"&Address="+frm.Address.value+"&Location="+frm.Location.value+"&email="+frm.email.value+"&Gender="+frm.Gender.value;

			fnSaveCustomer(Params);
		}
		function fnSaveCustomer(Params)
		{
			var divObj = document.getElementById("infodiv");
			URL = "SaveCustomerInfo.jsp"+Params;
			//alert(URL);
			ajaxFunction(URL,divObj);
		}
//-->
</SCRIPT>


<head>
<body>
<HR>
<B><FONT COLOR="RED" face='verdana' size="5"><center>Customer Info</center></FONT></B>
<HR>
<BR><BR>
<FORM>
<%
/*Declaration of variables*/
Connection con=null;
Statement stmt=null,stmt1=null,stmt2=null;
ResultSet rs=null,rs1=null,rs2=null;
int count=0,NumRows=0;
String TicketId="";
String uname=(String)session.getAttribute("fname");
String uemail=(String)session.getAttribute("email");
String uphone=(String)session.getAttribute("phone");
String uaddress=(String)session.getAttribute("address");
String upin=(String)session.getAttribute("pin");


System.out.print(uname+uemail+uphone);

boolean tflag=false;
try
{
	/*Connection to MySQL database is made with JDBC class one driver*/
	con = com.balaji.travels.ConnectionPool.getConnection();
	stmt =  con.createStatement();
        
        String qry = "select max(`TicketId`) from `ticketdetails`";
        
        ResultSet res_set = stmt.executeQuery(qry);
        
        //String n ="sai";
        
       // n.subs
        //out.println("rs is: "+res_set);
       System.out.println("before if"); 
        if(res_set.next())
		{
			TicketId = res_set.getString(1);
			if(TicketId == null)
				TicketId = "T-1";
		}
		else
			TicketId = "T-1";
//        out.println("TicketId is: "+TicketId);
        String no = TicketId.substring(2).trim();
        
        TicketId = "T-"+(Integer.parseInt(no)+1);
        
        session.setAttribute("TicketId",TicketId);
	String Query = "Insert into ticketdetails values('"+TicketId+"','"+RouteId+"','"+CustomerId+"','"+rFrom+"','"+rTo+"','"+JDate+"','"+Departure+"','"+Arrival+"','"+SelSeats+"','"+BPoint+"',"+Fare+",'Progress','','"+BusId+"')";
    
System.out.println("Search Qry->"+Query);
	
	int result = stmt.executeUpdate(Query);
	if( result > 0)	{
		session.setAttribute("TicketId",TicketId);
		System.out.println("Ticket saved");
		tflag=true;
	}
	else{
		session.setAttribute("TicketId","");
		System.out.println("Ticket not saved");
		tflag=false;
	}
}
catch(Exception e)
{
	out.println("Exception"+e);
	tflag=false;
}
if(tflag==true){
%>
	<TABLE width="60%" align=center>
		<TR class="row_title">
				<TH align="center" colspan=2>Provide customer details</TH>
		</TR>	
		<TR class="row_odd">
				<TH align="left">Customer Name<FONT COLOR="red" >*</FONT></TH>
				<TD><Input type=text   name='CustomerName' value=<%=uname%>></TD>
		</TR>
		<TR class="row_even">
				<TH align="left">Phone Number<FONT COLOR="red" >*</FONT></TH>
				<TD><Input type=text   name='PhoneNumber' value=<%=uphone%>></TD>
		</TR>
		<TR class="row_odd">
				<TH align="left">Address<FONT COLOR="red" >*</FONT></TH>
				<TD><textarea name=Address rows=2 cols=20 value=<%=uaddress%>></textarea></TD>
		</TR>
		<TR class="row_even">
				<TH align="left">Pin Code<FONT COLOR="red" >*</FONT></TH>
				<TD><Input type=text   name='Location' value=<%=upin%>></TD>
		</TR>
		<TR class="row_odd">
				<TH align="left">Email<FONT COLOR="red" >*</FONT></TH>
				<TD><Input type=text   name='email' value=<%=uemail%>></TD>
		</TR>
		<TR class="row_even">
				<TH align="left">Gender<FONT COLOR="red">*</FONT></TH>
				<TD><SELECT NAME="Gender">
					<OPTION VALUE="Male" SELECTED>Male
					<OPTION VALUE="Female">Female
				</SELECT></TD>
		</TR>
		

	</TABLE>
	<P align=center><FONT  COLOR="black" face='Georgia'>Fields with <FONT SIZE="" COLOR="red">*</FONT> are mandatory </FONT></P>
	<div id='infodiv'></div>
<P align=right>
	<A onclick="setAction('BookNow_S3.jsp',this)"><IMG SRC="Images/Continue1.jpg" border="0"
	onmouseout="this.src = 'Images/Continue1.jpg'" 
	onmouseover="this.src = 'Images/Continue2.jpg'"></A>
</P>
</FORM>
<%
}else{
	%>
		<P align=center><FONT  COLOR="red" face='Georgia'>An error occured. Please try again. Sorry for the inconvenience caused </FONT></P>
	<%
}
%>
</BODY>
</HTML>
