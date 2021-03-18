<%@ include file = "Header.html" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>  
    <%
    
    String name=null;
    String name1=null;
  name1=(String)session.getAttribute("fname");
  String lname=(String)session.getAttribute("lname");
    name=(String)session.getAttribute("userr");
System.out.println(name1);
System.out.println(name);
if(name1==null && name==null)
{
    response.sendRedirect("index.jsp");
}
else if(name!=null && name1==null)
{
	response.sendRedirect("AdminHome.jsp");
}
else 

{ %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
 
 <body bgcolor="##ccffff">
  <div class="w3-content w3-section" style="max-width:1500px">
  <img class="mySlides" src="Images/bus1.jpg" style="width:100%" height=422>
  <img class="mySlides" src="Images/bus2.jpg" style="width:100%" height=422>
  <img class="mySlides" src="Images/bus3.jpg" style="width:100%" height=422>
  <img class="mySlides" src="Images/bus4.jpg" style="width:100%" height=422>
  <img class="mySlides" src="Images/bus5.jpg" style="width:100%" height=422>
</div>
 
<script>
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 2000); // Change image every 2 seconds
}
</script>
 
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
						
						<li class="active"><a href="UserPage.jsp">Home</a></li>
						 <li><a href="VR.jsp">View Routes</a></li>
						<li><a href="SearchBus.jsp">Book Tickets</a></li>
						<li><a href="BookedHistory.jsp">View Booked History</a></li>
						<li><a href="BookedHistoryc.jsp">Cancel Tickets</a></li>
						<li><a href="Feedback.jsp">Give Testimonials</a></li>
						<li><a href="changepass0.jsp">Change Password</a></li>
						<li><a href="EditProfile.jsp">Edit Profile</a></li>
						<li><a href="LogoutUser.jsp">Logout</a></li>
						
					</ul>
					</div>
					<div class="clr"></div>
					
</div>
		
		
					
					<div class="col-xs-12 col-sm-8">
					
		&nbsp<marquee behavior="alternate" scrollamount=3><FONT Face='Georgia' COLOR="RED" size="5"><b>Welcome &nbsp <%=name1%> &nbsp <%=lname%></b></FONT></marquee>
		</br>
		
		
			<%-- <%       Blob image = null;
		Connection con = null;
		byte[] imgData = null ;
		Statement stmt = null;
		ResultSet rs = null;
	
		
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travels","root","pass");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select photo from contacts where  first_name  ='"+name1+"'");
			if (rs.next()) {
				image = rs.getBlob(1);
				imgData = image.getBytes(1,(int)image.length());
			} else {
				System.out.println("Display Blob Example");
				System.out.println("image not found for given id>");
				return;
			}

			// display the image
          response.setContentType("image/gif");
         OutputStream o = response.getOutputStream();
         o.write(imgData) ;
         
               %> --%>
               
               
               
		</br></br><H5>Salient Features</H5>
			<UL>
				<font color="#003366"><LI>Book Bus tickets to more than 200 cities.
				<LI>Cancellation is possible on the net.
				<LI>Pay using Major Credit/Debit Card
			</UL></font>

</div></div></div></div></div>
<div>
 <div id="portfolio-wrapper" style="background:url(Images/blurbg.jpg) no-repeat fixed">
		<div id="portfolio" class="container">
			<div class="title">
				<center><h2><strong><font color="white">UNIQUE ONLINE BUS BOOKING PLATFORM </font></strong></h2></center>
				</br>
				<span class="byline"><font color="#ffffcc" size=4>"This is largest online bus ticketing platform, trusted by over many Indians. With a sale of over ***** Bus tickets via web, mobile, and our bus agents, our portal stands at the top of the game in bus ticketing. This operates on over many routes and is associated with 2300 reputed bus operators. Try the bookingfor better experience today."</font>
				</br></br></br>
				
				
</span></div>
</div>   
</div>

 </BODY>
</HTML>

<%} %>
<%@ include file = "footer.html" %>