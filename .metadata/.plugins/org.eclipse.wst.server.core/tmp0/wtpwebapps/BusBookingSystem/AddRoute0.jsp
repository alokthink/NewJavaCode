<%@ include file = "header2.html" %>
<%@ page language="java" %>
<%@ page session="true" %>
<%@ page import="java.sql.*,java.io.*,com.balaji.travels.MyFunctions"%>

 
 <HTML>
    <HEAD>

    
    <script LANGUAGE="Javascript" >
		function ChkMandatoryField(F,T){
			var val= F.value;
			if(val==""){alert(T+" is mandatory");return false;}
		}
		function ChkNumField(F,T){
			var val = F.value;
			if(isNaN(val)==true||val==""){alert("Please enter numbers for "+T);return false;}
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
		function ChkDateField(F,T)
		{
			var val = F.value;
		    var pattern = /^[0-9]{4}-[0-9]{2}-[0-9]{2}$/;
		    if(!(pattern.test(val)==true)){alert("Please enter valid date format (yyyy-mm-dd) for "+T);return false;}
		}
		function ChkDestField(F,T){
		var f = document.forms(0);
		var rFrom = f.rFrom.options[f.rFrom.options.selectedIndex].text;
		//alert(rFrom);

		var rTo = f.rTo.options[f.rTo.options.selectedIndex].text;
		//alert(rTo);
		if(rFrom==rTo){
			alert("From and To can not be same. Please select different places");
			f.rTo.focus();
			return false;

		}
		}
	function ChkJDateField(F,T){
		var f = document.forms(0);
		var JDate = f.JDate.value;
		//alert(JDate);
		if(JDate=="") {alert("Journey date is mandatory");f.JDate.focus();return false;}
		if(validatePastDate(f.JDate)==false){
			alert("Past date is not allowed. Please select another date");
			f.JDate.focus();return false;
		}
	}

		function validate()
		{
			var frm = document.forms(0);
			if(ChkMandatoryField(frm.rFrom,'From')==false) return false;
			if(ChkMandatoryField(frm.rTo,'To')==false) return false;
			if(ChkDestField(frm.rTo,'To')==false) return false;
			if(ChkMandatoryField(frm.TravelsId,'Travels Id')==false) return false;
			if(ChkMandatoryField(frm.BusId,'Bus Id')==false) return false;
			if(ChkMandatoryField(frm.Departure,'Departure')==false) return false;
			if(validateTime(frm.Departure)==false) return false;
			if(ChkMandatoryField(frm.Arrival,'Arrival')==false) return false;
			if(validateTime(frm.Arrival)==false) return false;
			if(ChkMandatoryField(frm.Fare,'Fare')==false) return false;
			if(ChkNumField(frm.Fare,'Fare')==false) return false;
			if(ChkMandatoryField(frm.JDate,'Date')==false) return false;
			if(ChkJDateField(frm.JDate,'Date')==false) return false;
			if(ChkDateField(frm.JDate,'Date')==false) return false;
		}
		function fnBusDetails()
			{
		var frm = document.forms(0);
		var TravelsId = frm.TravelsId.value;
		if (TravelsId=='')
		{
			alert("Please Enter TravelsId to Proceed");
		}else
				{var URL = "ShowBuses.jsp?TravelsId="+TravelsId;
			fnEmpPopUp(URL,300,400);
			}
		}
	</script>
	</HEAD>
	<Body class=SC>

<div class="col-xs-12 col-sm-3 col-md-4 col-lg-3">
			   <div class="news-box">
					<h2>Add Routes</h2>
					<div class="main-hr">
						<div class="color1hr"></div>
						<div class="color2hr"></div>
						<div class="color3hr"></div>
						<div class="color4hr"></div>
					</div>
					<ul class="sideNav2">
						
						<li ><a href="AdminHome.jsp">Home</a></li>
						 <li class="active"><a href="AddRoute0.jsp">Add Routes</a></li>
						<li><a href="ViewRoutes.jsp">View Routes</a></li>
						<li><a href="DelRoute0.jsp">Delete Routes</a></li>
						<li><a href="AddTravel0.jsp">Add Travels</a></li>
						<li><a href="ViewTravels.jsp">View Travels</a></li>
						<li><a href="DelTravel0.jsp">Delete Travels</a></li>
						<li><a href="ViewCustomers.jsp">View Customers</a></li>
						<li><a href="Logout.jsp">Logout</a></li>
						
						
					</ul>
					</div>
					<div class="clr"></div>
					
</div>


<HR>
<B><FONT COLOR="#CC00CC" face='verdana'>Add Route</FONT></B>
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
<FORM ACTION="AddRoute1.jsp" onsubmit="return validate()">
   <center>
   <TABLE BORDER="0" CELLSPACING="2"  CELLPADDING="2" >
	   <TR class=row_title  ALIGN="center">
	   <TH COLSPAN="2"><font color= "#660033"> Add New Route </font></TH>
		<tr class="row_odd">
			<td><font color= "#660033">From</font></td>
			<td><font color= "#ff6666"><SELECT NAME="rFrom" class="ListBox">
				<option value="A.S.Peta">A.S.Peta</option>
				<option value="Ahmedabad">Ahmedabad</option>
				<option value="Amalapuram">Amalapuram</option>
				<option value="Ambaji">Ambaji       </option>
				<option value="Anakapalli">Anakapalli</option>
				<option value="Anantapur">Anantapur</option>
				<option value="Annavaram">Annavaram</option>
				<option value="Atmakur">Atmakur</option>
				<option value="Aurangabad">Aurangabad </option>
				<option value="Bangalore">Bangalore</option>
				<option value="Bapatla">Bapatla</option>
				<option value="Bhopal">Bhopal</option>
				<option value="Bhuj">Bhuj</option>
				<option value="Chandigarh">Chandigarh </option>
				<option value="Chennai">Chennai</option>
				<option value="Chilakaluripet">Chilakaluripet</option>
				<option value="Chirala">Chirala</option>
				<option value="Cochin">Cochin</option>
				<option selected="selected" value="Delhi">Delhi</option>
				<option value="Devarpalli">Devarpalli</option>
				<option value="Gandhidham">Gandhidham </option>
				<option value="Goa">Goa</option>
				<option value="Gokavaram">Gokavaram</option>
				<option value="Guduru">Guduru</option>
				<option value="Guntur">Guntur</option>
				<option value="Hubli">Hubli</option>
				<option  value="Hyderabad">Hyderabad</option>
				<option value="Indore">Indore </option>
				<option value="Inkollu">Inkollu</option>
				<option value="Jaggampet">Jaggampet</option>
				<option value="Jaipur">Jaipur</option>
				<option value="Jammu">Jammu</option>
				<option value="Jamnagar">Jamnagar </option>
				<option value="Jangareddy Gudem">Jangareddy Gudem</option>
				<option value="Kadapa">Kadapa</option>
				<option value="Kakinada">Kakinada</option>
				<option value="Kaligiri">Kaligiri</option>
				<option value="Karimnagar">Karimnagar</option>
				<option value="Kathipudi">Kathipudi</option>
				<option value="Katra">Katra </option>
				<option value="Kavali">Kavali</option>
				<option value="Kolhapur">Kolhapur </option>
				<option value="Kovvuru">Kovvuru</option>
				<option value="Kurnool">Kurnool</option>
				<option value="Mahabaleshwar">Mahabaleshwar</option>
				<option value="Mahabalipuram">Mahabalipuram </option>
				<option value="Manali">Manali </option>
				<option value="Mangalore">Mangalore </option>
				<option value="MountAbu">MountAbu</option>
				<option value="Mumbai">Mumbai</option>
				<option value="Naidupeta">Naidupeta</option>
				<option value="Narasaraopet">Narasaraopet</option>
				<option value="Nasik">Nasik</option>
				<option value="Nellore">Nellore</option>
				<option value="Ongole">Ongole</option>
				<option value="Palitana">Palitana </option>
				<option value="Pangidi">Pangidi</option>
				<option value="Peddapuram">Peddapuram</option>
				<option value="Ponnur">Ponnur</option>
				<option value="Pune">Pune</option>
				<option value="Railway Koduru">Railway Koduru</option>
				<option value="Raja Nagaram">Raja Nagaram</option>
				<option value="Rajampet">Rajampet</option>
				<option value="Rajamundry">Rajamundry</option>
				<option value="Rajkot">Rajkot</option>
				<option value="Rangampeta">Rangampeta</option>
				<option value="Razole">Razole</option>
				<option value="S.Konda">S.Konda</option>
				<option value="Samarla Kota">Samarla Kota</option>
				<option value="Sathenpalli">Sathenpalli</option>
				<option value="Shiridi">Shiridi</option>
				<option value="Shreenathji">Shreenathji </option>
				<option value="Srikakulam">Srikakulam</option>
				<option value="Srinagar">Srinagar </option>
				<option value="Sullurupeta">Sullurupeta</option>
				<option value="Surat">Surat</option>
				<option value="Tenali">Tenali</option>
				<option value="Thrissur">Thrissur </option>
				<option value="Tiruchirapally">Tiruchirapally </option>
				<option value="Tirupathi">Tirupathi</option>
				<option value="Tuni">Tuni</option>
				<option value="Udaipur">Udaipur</option>
				<option value="Ujjain">Ujjain</option>
				<option value="Ulavapadu">Ulavapadu</option>
				<option value="Vadodara">Vadodara</option>
				<option value="Vetapalem">Vetapalem</option>
				<option value="Vijayanagaram">Vijayanagaram</option>
				<option value="Vijayawada">Vijayawada</option>
				<option value="Vinjamoor">Vinjamoor</option>
				<option value="Vizag">Vizag</option>
				<option value="Warangal">Warangal</option>

			</select></font>
		</td>
		</tr>
		<tr class="row_even">
			<td><font color= "#660033">To</font></td>
			<td><font color= "#ff6666"><SELECT NAME="rTo" class="ListBox">
				<option value="A.S.Peta">A.S.Peta</option>
				<option value="Ahmedabad">Ahmedabad</option>
				<option value="Amalapuram">Amalapuram</option>
				<option value="Ambaji">Ambaji       </option>
				<option value="Anakapalli">Anakapalli</option>
				<option value="Anantapur">Anantapur</option>
				<option value="Annavaram">Annavaram</option>
				<option value="Atmakur">Atmakur</option>
				<option value="Aurangabad">Aurangabad </option>
				<option value="Bangalore">Bangalore</option>
				<option value="Bapatla">Bapatla</option>
				<option value="Bhopal">Bhopal</option>
				<option value="Bhuj">Bhuj</option>
				<option value="Chandigarh">Chandigarh </option>
				<option value="Chennai">Chennai</option>
				<option value="Chilakaluripet">Chilakaluripet</option>
				<option value="Chirala">Chirala</option>
				<option value="Cochin">Cochin</option>
				<option selected="selected"  value="Delhi">Delhi</option>
				<option value="Devarpalli">Devarpalli</option>
				<option value="Gandhidham">Gandhidham </option>
				<option value="Goa">Goa</option>
				<option value="Gokavaram">Gokavaram</option>
				<option value="Guduru">Guduru</option>
				<option value="Guntur">Guntur</option>
				<option value="Hubli">Hubli</option>
				<option  value="Hyderabad">Hyderabad</option>
				<option value="Indore">Indore </option>
				<option value="Inkollu">Inkollu</option>
				<option value="Jaggampet">Jaggampet</option>
				<option value="Jaipur">Jaipur</option>
				<option value="Jammu">Jammu</option>
				<option value="Jamnagar">Jamnagar </option>
				<option value="Jangareddy Gudem">Jangareddy Gudem</option>
				<option value="Kadapa">Kadapa</option>
				<option value="Kakinada">Kakinada</option>
				<option value="Kaligiri">Kaligiri</option>
				<option value="Karimnagar">Karimnagar</option>
				<option value="Kathipudi">Kathipudi</option>
				<option value="Katra">Katra </option>
				<option value="Kavali">Kavali</option>
				<option value="Kolhapur">Kolhapur </option>
				<option value="Kovvuru">Kovvuru</option>
				<option value="Kurnool">Kurnool</option>
				<option value="Mahabaleshwar">Mahabaleshwar</option>
				<option value="Mahabalipuram">Mahabalipuram </option>
				<option value="Manali">Manali </option>
				<option value="Mangalore">Mangalore </option>
				<option value="MountAbu">MountAbu</option>
				<option value="Mumbai">Mumbai</option>
				<option value="Naidupeta">Naidupeta</option>
				<option value="Narasaraopet">Narasaraopet</option>
				<option value="Nasik">Nasik</option>
				<option value="Nellore">Nellore</option>
				<option value="Ongole">Ongole</option>
				<option value="Palitana">Palitana </option>
				<option value="Pangidi">Pangidi</option>
				<option value="Peddapuram">Peddapuram</option>
				<option value="Ponnur">Ponnur</option>
				<option value="Pune">Pune</option>
				<option value="Railway Koduru">Railway Koduru</option>
				<option value="Raja Nagaram">Raja Nagaram</option>
				<option value="Rajampet">Rajampet</option>
				<option value="Rajamundry">Rajamundry</option>
				<option value="Rajkot">Rajkot</option>
				<option value="Rangampeta">Rangampeta</option>
				<option value="Razole">Razole</option>
				<option value="S.Konda">S.Konda</option>
				<option value="Samarla Kota">Samarla Kota</option>
				<option value="Sathenpalli">Sathenpalli</option>
				<option value="Shiridi">Shiridi</option>
				<option value="Shreenathji">Shreenathji </option>
				<option value="Srikakulam">Srikakulam</option>
				<option value="Srinagar">Srinagar </option>
				<option value="Sullurupeta">Sullurupeta</option>
				<option value="Surat">Surat</option>
				<option value="Tenali">Tenali</option>
				<option value="Thrissur">Thrissur </option>
				<option value="Tiruchirapally">Tiruchirapally </option>
				<option value="Tirupathi">Tirupathi</option>
				<option value="Tuni">Tuni</option>
				<option value="Udaipur">Udaipur</option>
				<option value="Ujjain">Ujjain</option>
				<option value="Ulavapadu">Ulavapadu</option>
				<option value="Vadodara">Vadodara</option>
				<option value="Vetapalem">Vetapalem</option>
				<option value="Vijayanagaram">Vijayanagaram</option>
				<option value="Vijayawada">Vijayawada</option>
				<option value="Vinjamoor">Vinjamoor</option>
				<option value="Vizag">Vizag</option>
				<option value="Warangal">Warangal</option>

			</SELECT></font></td>
		</tr>
		<tr class="row_odd">
	    <TD><font color= "#660033">Travels Id</font><FONT COLOR="red">*</FONT></TD>
	<TD><font color= "#660033"><Input type=text name='TravelsId' value=''readonly><INPUT TYPE="Button" Name="GBid" value="..." Onclick="fnEmpPopUp('ShowTravels.jsp',300,600);"></font>
		</TR>
		<tr class="row_even">
	    <TD><font color= "#660033">Bus Id</font><FONT COLOR="red">*</FONT></TD>
	<TD><font color= "#660033"><Input type=text name='BusId' value=''readonly>	<INPUT TYPE="Button" Name="GBid" value="..." Onclick="fnBusDetails()"></font>

		</TR>
		<tr class="row_odd">
	    <TD><font color= "#660033">Departure</font><FONT COLOR="red">*</FONT></TD>
				<TD><font color= "#ff6666"><Input type=text name='Departure' value=''></font><font color= "#660033">HH:MM</font></TD>
		</TR>
		<tr class="row_even">
	    <TD><font color= "#660033">Arrival</font><FONT COLOR="red">*</FONT></TD>
				<TD><font color= "#ff6666"><Input type=text name='Arrival' value=''></font><font color= "#660033">HH:MM</font></TD>
		</TR>
		<tr class="row_odd">
	    <TD><font color= "#660033">Fare</font><FONT COLOR="red">*</FONT></TD>
				<TD><font color= "#ff6666"><Input type=text name='Fare' value=''></font></TD>
		</TR>
		<tr class="row_even">
	    <TD><font color= "#660033">Journey Date</font><FONT COLOR="red">*</FONT></TD>
				<TD><font color= "#ff6666"><Input type=text name='JDate' value='' readonly><img onkeypress="fnCalendar(this)" id="imgDate" style="CURSOR: hand" onClick="fnCalendar(this)" height="16" src="Images/CalDis.gif" width="16" border="0" name="imgDate" onMouseOver="fnEnableCalLookup(this)" onMouseOut="fnDisableCalLookup(this)" ></font></TD>
		</TR>
		<TR><TH><TD><font color= "#660033"><INPUT TYPE="submit" value='Submit'></font></TD><TH><TD><font color= "#660033"><INPUT TYPE="reset" value='Clear'></font></TD></TR>
	</TABLE>
	<H6 align=center>Fields with <FONT SIZE="" COLOR="red">*</FONT> are mandatory </H6>
	
	</center>
	</FORM>
	</BODY>
<%}%>
