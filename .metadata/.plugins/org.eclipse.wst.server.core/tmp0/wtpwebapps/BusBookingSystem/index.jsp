<%@ include file = "Header.html" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page language="java" %>
<%@ page session="true" %>
<%@ page import="java.sql.*, java.io.*, java.util.Random, com.balaji.travels.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

<body>

                     
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


                     
                 

<!-- Start About Section -->
<section class="about">
  <div class="container">
    <ul class="row our-links">
      <li class="col-sm-4 apply-online clearfix equal-hight">
        <div class="icon"><img src="Images/apply-online-ico.png" class="img-responsive" alt=""></div>
        <div class="detail">
          <h2><font color="#FFFFFF">User Login</font></h2>
          <!--<p>Lorem Ipsum is simply dummy text of the printing...</p>-->
          <a href="UserLogin.jsp" class="more"></a> </div>
      </li>
      <li class="col-sm-4 prospects clearfix equal-hight">
        <div class="icon"><img src="Images/prospects-ico.png" class="img-responsive" alt=""></div>
        <div class="detail">
          <h2><font color="#FFFFFF">Admin Login</font></h2>
          <!--<p>Lorem Ipsum is simply dummy text of the printing...</p>-->
          <a href="AdminLogin.jsp" class="more"><i class="fa fa-angle-right" aria-hidden="true"></i></a> </div>
      </li>
      <li class="col-sm-4 certification clearfix equal-hight">
        <div class="icon"><img src="Images/certification-ico.png" class="img-responsive" alt=""></div>
        <div class="detail">
          <h2><font color="#FFFFFF">User Register</font></h2>
          <!--<p>Lorem Ipsum is simply dummy text of the printing...</p>-->
          <a href="UserRegisterPage.jsp" class="more"><i class="fa fa-angle-right" aria-hidden="true"></i></a> </div>
      </li>
    </ul>

</section>
<!-- End About Section --> 

 <div id="portfolio-wrapper" style="background:url(Images/blurbg.jpg) no-repeat fixed">
		<div id="portfolio" class="container">
			<div class="title">
				<center><h2><strong>UNIQUE ONLINE BUS BOOKING PLATFORM </strong></h2></center>
				</br>
				<span class="byline"><font family="Times New Roman" size="4">"This is largest online bus ticketing platform, trusted by over many Indians. With a sale of over ***** Bus tickets via web, mobile, and our bus agents, our portal stands at the top of the game in bus ticketing. This operates on over many routes and is associated with 2300 reputed bus operators. Try the bookingfor better experience today."</font>
				</br></br></br>
				
				
</span> 



<%
	String comments[]=new String[100];
	int i=0;
	String Uname[]=new String[100];
	int j=0;
	Connection con=null;
	ResultSet rs=null;
	Statement stmt=null;
	try{
			
			
			con = ConnectionPool.getConnection();
			stmt =  con.createStatement();

			String Query = "Select UserId,Feedback from feedback order by `FId`";
			rs = stmt.executeQuery(Query);
			
			int rCount=0;
			while(rs.next())
			{	Uname[j++]=rs.getString(1);
				comments[i++]=	rs.getString(2);
				rCount++;
			}
			if( rCount == 0)	{%><h3 align=center>Sorry No records Found</h3><% }
			rs.close();
			stmt.close();
			con.close();
		}catch(Exception e){
// 			rs.close();
// 			stmt.close();
// 			con.close();
			%><%=e%><%
		}
	
%>


<!-- Start Testimonial -->
<div class=testimonial-bg>
         <div class=container>
            <div class=row>
               <div class="">
                  <h2>User's Comments and Testimonials</h2>
                  <div class=main-hr>
                     <div class=color1hr></div>
                     <div class=color2hr></div>
                     <div class=color3hr></div>
                     <div class=color4hr></div>
                  </div>
                  <div class=alumniBox>
                     <div class="carousel slide"id=carousel-id data-ride=carousel>
                        <div class=carousel-inner>
                           <div class="item active">
                              
                              <font color="black"><p>
                              
                              <%
                              
                              for(int k=0;k<i;k++)
                              {
                            	  %><marquee behavior="alternate"   scrollamount="3" scrollspeed="5"><b><font color="red" size=3"><%=Uname[k]%></b></font></br><%=comments[k]%></br></marquee><%
                              }
                              %>
                              </p></font>
                           </div>
                        </div>
                     </div>
                     <p class=text-center style=margin-bottom:0><a href="VT.jsp" class="btn btn-info alumniBtn">View All <i class="fa fa-angle-right"></i></a>
                     <div class=clr></div>
                  </div>
               </div>
               </div>
               </div>
               </div>
               </div>
</div>  
</div>
<!-- End Testimonial --> 

</BODY>
</HTML>
<%@ include file = "footer.html" %>