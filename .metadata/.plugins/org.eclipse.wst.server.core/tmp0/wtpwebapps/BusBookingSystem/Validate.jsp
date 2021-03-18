<!--
     File : Validate.jsp

 -->

<HTML>
<%@ page language="java" %>
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
   user_id = request.getParameter("Name");
   pass_word = request.getParameter("Pwd");
   System.out.println("user_id = "+user_id+"\t"+"pass_word = "+pass_word);


try
{
		con = com.balaji.travels.ConnectionPool.getConnection();
	System.out.println("Connection is: "+con);
	stmt =  con.createStatement();

	/*Retrives data from the database*/

	String query = "SELECT auth, userid  from Login where userid='"+user_id+"' and password='"+pass_word+"'";

	System.out.println(query);


	rs = stmt.executeQuery(query);
	System.out.println(rs);
	if(rs.next())
	{
				/*Puts the username and connection variable to session*/
				int value = rs.getInt(1);

				System.out.println(value);
				
				System.out.println(rs.getString(2));
				if(!(value<0))	{
	        	    System.out.println("User has successfully logged in...");
					session.setAttribute("auth",new Integer(value));
					System.out.println("value print" + value);
					session.setAttribute("userr",user_id);
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
		
			<jsp:forward page="AdminHome.jsp"/>
		
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
