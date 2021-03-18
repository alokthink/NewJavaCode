

<HTML>
<%@ page language="java" %>
<%@ page import="java.io.*" %> 
<%@ page import="java.sql.*" %>
<%@ page import="java.lang.*" %>
<%@ page session="true" %>
<head>
	<LINK href="styles.css" type="text/css" rel="stylesheet">
</head>
<body Class="SC" scroll="yes">
<%! String pass_word; %>
<%! int flag=0;  %>


<%

/*Declaration of variables*/

Connection con=null;
Statement stmt=null;
ResultSet rs=null;
   user_id = request.getParameter("email");
   pass_word = request.getParameter("Pwd");
   System.out.println("user_id = "+user_id+"\t"+"pass_word = "+pass_word);


try
{
		con = com.balaji.travels.ConnectionPool.getConnection();
	System.out.println("Connection is: "+con);
	stmt =  con.createStatement();
	
	InputStream sImage;
	/*Retrives data from the database*/

	//String query = "SELECT  auth,EmailId,Password,CustomerName,PhoneNo,CustomerId,address,pin  from customermaster where EmailId='"+user_id+"' and Password='"+pass_word+"'";
	String query = "SELECT  auth,customerid,first_name,last_name,photo,email,password,phone,address,pin,forgotpquestion,forgotpanswer,gender,dateinfos  from contacts where email='"+user_id+"' and password='"+pass_word+"'";
	
	System.out.println(query);


	rs = stmt.executeQuery(query);
	System.out.println(rs);
	if(rs.next())
	{
				
				 int value = rs.getInt(1);
				int customerid= rs.getInt(2);
				String fname= rs.getString(3);
				String lname= rs.getString(4);
				
				//photo
				
				String email= rs.getString(6);
				String pwd= rs.getString(7);
				String phone= rs.getString(8);
				String address= rs.getString(9);
				String pin= rs.getString(10);
				String forgotpquestion = rs.getString(11);
				String forgotpanswer= rs.getString(12);
				String gender= rs.getString(13);
				String dateinfos= rs.getString(13);
				System.out.println(value);

				
				
				System.out.println(rs.getString(2));
				if(!(value<0))	{
	        	    System.out.println("User has successfully logged in...");
					session.setAttribute("auth",new Integer(value));
					System.out.println("value print" + value);
					
					
					 
					session.setAttribute("fname",fname);
					session.setAttribute("lname",lname);
					session.setAttribute("phone",phone);
					session.setAttribute("email",email);
					session.setAttribute("CustomerId",customerid);
					session.setAttribute("address",address);
					session.setAttribute("pin",pin);
					session.setAttribute("gender",gender);
					session.setAttribute("dateinfos",dateinfos);
					session.setAttribute("forgotpquestion",forgotpquestion);
					session.setAttribute("forgotpanswer",forgotpanswer);
					System.out.println("CustomerId"+customerid);
					session.setAttribute("connection",con); 
					
					
					
					
					
					
					
					
	        	    flag=1;
				}
	}

}
catch(Exception e)
{
	System.out.println("Exception"+e);
}

	/*If username and password is validated, then the user is redirected to homepage*/
	 if(flag==1)
	{
	flag=0; 
%>
<%! String user_id; %>	 
		
			<jsp:forward page="UserPage.jsp"/>
		
<%
	}
	else 
	{
	/*If username and password is not valid, then the user is redirected back to Loginpage*/
%>
		
		<jsp:forward page="errorLogin.jsp"/>
	
<%
	}
%>



</BODY>
</HTML>
