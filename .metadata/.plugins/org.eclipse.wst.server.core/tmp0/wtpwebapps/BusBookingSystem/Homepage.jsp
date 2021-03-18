<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%String name1=(String)session.getAttribute("username");
System.out.println(name1);
if(name1==null)
{
    response.sendRedirect("index.html");
}
else
{ %>
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>User</title>


<frameset cols="18%, 64%, * ">
	
		<frame src="UserOptions.html" name="leftTop"/>
		
	
	<frame src="UserPage.jsp" name="display"/>
	<frame src="VT.jsp" name = "leftBottom"/>	
	</frameset>
</head>

<body>
</body>


</html>

<% }%>