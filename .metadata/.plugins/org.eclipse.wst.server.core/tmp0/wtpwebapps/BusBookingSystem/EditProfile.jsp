<%@ include file = "Header.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
  
    <%@ page language="java" %>
<%@ page import="java.io.*" %> 
<%@ page import="java.sql.*" %>
<%@ page import="java.lang.*" %>
<%@ page session="true" %>

<html>
	<head>
	<script LANGUAGE="Javascript" SRC="Images/validate.js"></script>
  <script LANGUAGE="Javascript" SRC="Images/calender.js"></script>

		



		<style type="text/css">
.Title {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}

.Title1 {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}
</style> </head>
		<body>
	
	
	<%
	String name1=(String)session.getAttribute("fname");
	int CustomerId=(int)session.getAttribute("CustomerId");
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	String fname=null;
	String lname=null;
	
	//photo
	
	String mail=null;
	
	String phone=null;
	String address=null;
	String pin= null;
	
	String gender= null;
	String dateinfos= null;
	try
{
		con = com.balaji.travels.ConnectionPool.getConnection();
	System.out.println("Connection is: "+con);
	stmt =  con.createStatement();
	
	InputStream sImage;
	/*Retrives data from the database*/

	//String query = "SELECT  auth,EmailId,Password,CustomerName,PhoneNo,CustomerId,address,pin  from customermaster where EmailId='"+user_id+"' and Password='"+pass_word+"'";
	String query = "SELECT  first_name,last_name,email,phone,address,pin,gender,dateinfos  from contacts where first_name='"+name1+"' and CustomerId='"+CustomerId+"'";
	
	System.out.println(query);


	rs = stmt.executeQuery(query);
	System.out.println(rs);
	if(rs.next())
	{
				
				
				 fname= rs.getString(1);
				  lname= rs.getString(2);
				
				//photo
				
				  mail= rs.getString(3);
				
				  phone= rs.getString(4);
				  address= rs.getString(5);
				  pin= rs.getString(6);
				
				  gender= rs.getString(7);
				  dateinfos= rs.getString(8);
				

				
				
				
	}

}
catch(Exception e)
{
	System.out.println("Exception"+e);
}
			
%>		
<h1>Edit Profile</h1>
      <form action="Updaterofile.jsp" method="post">
        
        <fieldset>
          <legend><span class="number"></span>Your basic info</legend>
          <font color= "black"><label for="name" >Email Id:</label>
           <input type="email" name="email" value= <%= mail %> readonly="readonly">
								
								
										
									
									<label>Address:</label>
          <input type="address" id="under_13"  name="address" value=<%=address%>><br>
          <textarea rows = "5" cols = "50" name = "address" value=<%=address%>>
            
         </textarea>
        

								
								
											<label>First Name :</label>
										

									
										<input type="text" name="firstName" value=<%=fname%>>
									
									<label>Last Name :</label>

									
										<input type="text" name="lastName" value=<%=lname%> size="20" />
									<label>Birth Date :</label>
										

									
										<input type="text" name="birthDate" value= <%=dateinfos%> size="20"
											readonly="readonly" />
										
											<center><img onkeypress="fnCalendar(this)" id="imgDate" style="CURSOR: hand" onClick="fnCalendar(this)" height="16" src="Images/CalDis.gif" width="16" border="0" name="imgDate" onMouseOver="fnEnableCalLookup(this)" onMouseOut="fnDisableCalLookup(this)" >
									</center>
										</br>
											
								

										<label>Gender</label>
											 &nbsp<%= gender %>
									
										<select name="gender"  > 
											<option value=<%=gender %> selected="true">
												<font size="3" face="Verdana">Change </font>
											</option>
											<option value="Male">
												<font size="3" face="Verdana">Male</font>
											</option>
											<option value="Female">
												<font size="3" face="Verdana">Female</font>
											</option>
										</select>
									
											<label> Pin Code </label>

										
											<input type="text" name="pin" value=<%= pin %> size="20" />
										

											<label> Mobile Number :</label>


										
											<input type="text" name="mob" value=<%=phone%> size="20" />
										
</font></fieldset>


									
											<button type="submit" name="register">Edit</button>
											</br>
											
												 
										
			</form>

			
			
		</body>
</html>
