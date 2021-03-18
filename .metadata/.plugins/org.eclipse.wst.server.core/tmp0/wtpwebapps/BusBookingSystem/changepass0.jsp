<%String forgotpquestion=(String)session.getAttribute("forgotpquestion");%>

<%@ include file = "Header.html" %>
  <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up Form</title>
        
        
    </head>
    <body>
    
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
						<li><a href="BookedHistory.jsp">View Booked History</a></li>
						<li><a href="BookedHistoryc.jsp">Cancel Tickets</a></li>
						<li><a href="Feedback.jsp">Give Testimonials</a></li>
						<li class="active"><a href="changepass0.jsp">Change Password</a></li>
						<li><a href="LogoutUser.jsp">Logout</a></li>
						
					</ul>
					</div>
					<div class="clr"></div>
					
</div>

      <form action="changePass.jsp" method="post">
      
        <h1>Change Password</h1>
        
        <fieldset>
          <legend><span class="number"></span>Your New Password</legend>
          </br><font color="Red"> SECURITY QUESTION. </font></br>
          <label for="fpass"><font color="black"><%=forgotpquestion %> </font></label>
          </br>
          
          <label for="password"><font color="black">Your Answer:</font></label>
           <input type="text" id="text" name="answer">
           </br>
           
           <label for="password"><font color="black"> New Password:</font></label>
           
          <input type="password" id="password" name="pass">
          
          
        </fieldset>
        <button type="submit">Change Password</button>
      </form>
      
    </body>
</html>

<%@ include file = "footer.html" %>