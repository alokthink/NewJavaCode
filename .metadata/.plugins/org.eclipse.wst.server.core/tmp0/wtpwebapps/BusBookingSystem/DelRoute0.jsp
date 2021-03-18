<%@ include file = "header2.html" %>

<%@ page language="java" %>
<%@ page session="true" %>
<%@ page import="java.sql.*,java.io.*,java.util.Random"%>

<HEAD>

<script LANGUAGE="Javascript" SRC="Images/validate.js"></script>
<script LANGUAGE="Javascript">

function fnShowDetails()
			{
				var frm = document.forms(0);
				var RouteId = frm.RouteId.value;
				
				if (RouteId=='')
				{
					alert("Please select RouteId to Proceed");
				}else{
					var URL = "ShowRoutes.jsp?RouteId="+RouteId;
					fnEmpPopUp(URL,300,400);
				}
			}
	function validate()
		{
			var frm = document.forms(0);
			var RouteId = frm.RouteId.value;

			if (RouteId=='')
				{
					alert("Please select RouteId to Proceed");
				}
				

		}


</script>
</HEAD>

<BODY class=SC>
<div class="col-xs-12 col-sm-3 col-md-4 col-lg-3">
			   <div class="news-box">
					<h2>Delete Routes</h2>
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
						<li class="active"><a href="DelRoute0.jsp">Delete Routes</a></li>
						<li><a href="AddTravel0.jsp">Add Travels</a></li>
						<li ><a href="ViewTravels.jsp">View Travels</a></li>
						<li ><a href="DelTravel0.jsp">Delete Travels</a></li>
						<li><a href="#">View Customers</a></li>
						<li><a href="Logout.jsp">Logout</a></li>
						
						
					</ul>
					</div>
					<div class="clr"></div>
					
</div>
<HR>
<B><FONT COLOR="#CC00CC" face='verdana'>Delete Route</FONT></B>
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

	Connection con;
	ResultSet rs=null;
	Statement stmt=null;
	String Condition = "RouteId";
	String[] ConValues = new String[2000];
	int ConCount=0,i=0;
	String Query1="";
%>
<FORM Name='DelForm' METHOD=POST ACTION="DelRoute1.jsp" onsubmit="return validate()">
			<CENTER><B><FONT face="verdana" color="black"> Select a route to delete from database </FONT></B></CENTER><BR><BR>
		 <center>
   <TABLE BORDER="0" CELLSPACING="2"  CELLPADDING="2" >
	<TR class=row_title ALIGN="center"> <TH COLSPAN="2"> Delete Route</TH>
		<TR class=row_odd>
			<TH><%=Condition.replace('`',' ').toUpperCase()%></TH>
			<TD><SELECT NAME="<%=Condition%>">
			<OPTION Value="">Select</OPTION>

<%
	try{
			
			con = com.balaji.travels.ConnectionPool.getConnection();
			stmt =  con.createStatement();

			if(Condition.trim().equalsIgnoreCase("undefined")){
				System.out.println("in if");
				Query1 = "Select * from routemaster";
			}
			else{
				System.out.println("in else");
				Query1 = "Select "+Condition+" from routemaster";
			}
			String str="";
			System.out.println(Query1);
			rs = stmt.executeQuery(Query1);
			int rCount=0;
				while(rs.next()){
					String x = rs.getString(1);
					ConValues[i]=x;
					%><OPTION Value=<%=ConValues[i]%>><%=ConValues[i]%></OPTION><%
					i++;
				}
		}catch(Exception e){%><%=e%><%}
%>
		</SELECT></TD>
		</TR>
		<TR class =row_odd><TD align=center><Input type='Submit' name='submit' value='Delete'></TD>
		<TD align=center><input type="button" ID='Item' value="ShowDetails" onclick="fnShowDetails()"></TD>
		</TR>
		</TABLE>
</FORM>
</BODY>
<%
}
%>
