<%@page import="java.util.Random"%>
<%@page import="java.io.BufferedReader"%>
<%@page import ="java.io.IOException" %>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URLConnection"%> 
<%@page import=" java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name=request.getParameter("name");
String email=request.getParameter("email");
String phone=request.getParameter("phone");
session.setAttribute("name",name); 
session.setAttribute("email",email);
session.setAttribute("phone",phone); 
//String authkey = "67e3765cdf034f438a432eacb88d0c14";
//Multiple mobiles numbers separated by comma
String mobiles = phone;
Random rand = new Random();
int otp = rand.nextInt(900000) + 100000;
session.setAttribute("otp",otp);
//Sender ID,While using route4 sender id should be 6 characters long.
String senderId = "SMSHUB";
//Your message to send, Add URL encoding here.
String message = "Your OTP is "+otp;
//define route
String route="4";
//Prepare Url
URLConnection myURLConnection=null;
URL myURL=null;
BufferedReader reader=null;
//encoding message 
String encoded_message=URLEncoder.encode(message);
//Send SMS API
String mainUrl="http://cloud.smsindiahub.in/vendorsms/pushsms.aspx?user="+"marwari"+"&password="+"abhishek"+"&msisdn="+mobiles+"&sid="+senderId+"&msg="+encoded_message+"&fl=0";

//String mainUrl="http://cloud.smsindiahub.in/vendorsms/pushsms.aspx?user=abc&password=xyz&msisdn=919898xxxxxx&sid=senderId&msg=message&fl=0 &gwid=2";

//Prepare parameter string 
StringBuilder sbPostData= new StringBuilder(mainUrl);
//sbPostData.append("authkey="+authkey); 
//sbPostData.append("&mobiles="+mobiles); 
//sbPostData.append("&message="+encoded_message);
//sbPostData.append("&route="+route);
//sbPostData.append("&sender="+senderId);
//final string
mainUrl = sbPostData.toString();
try
{
//prepare connection
myURL = new URL(mainUrl);
myURLConnection = myURL.openConnection();
myURLConnection.connect();
reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
String success="Your message sent sucessfully";
System.out.print("Your message sent sucessfully");
response.sendRedirect("otp.jsp");
//finally close connection
reader.close(); 
}
catch (IOException e)
{
e.printStackTrace();
}
%>
</body>
</html>