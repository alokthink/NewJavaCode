<HTML>

<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.lang.*" %>

<%@ page session="true" %>
<head>
	<style>
.button {
  border-radius: 4px;
  background-color: red;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 28px;
  padding: 20px;
  width: 250px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}
</style>
</head>

<body Class='SC'>
<!--	<H4 align=center>Menu</H4> -->
	<TABLE align="center">
	<TR>
	
	
	
	





<A HREF="AddRoute0.jsp" target="AdminBodyFrame"><button class="button"><span>Add Route </span></button>
</TR><TR></br>
<A HREF="ViewRoutes.jsp" target="AdminBodyFrame"><button class="button"><span>View Route </span></button>
</TR><TR></br>
<A HREF="DelRoute0.jsp" target="AdminBodyFrame"><button class="button"><span>Delete Route </span></button>
</TR><TR></br>
<A HREF="AddTravel0.jsp" target="AdminBodyFrame"><button class="button"><span>Add Travels </span></button>
</TR><TR></br>
<A HREF="ViewTravels.jsp" target="AdminBodyFrame"><button class="button"><span>View Travels </span></button>
</TR><TR></br>
<A HREF="DelTravel0.jsp" target="AdminBodyFrame"><button class="button"><span>Delete Travels </span></button>
</TR><TR></br>
</body>
</html>
	
	
	<form align="right" target="_parent" method="post" action="LogoutUser.jsp">
  <label>
  <input name="submit2" type="submit" id="submit2" value="log out">
  </label>
</form>
</BODY>
</HTML>
