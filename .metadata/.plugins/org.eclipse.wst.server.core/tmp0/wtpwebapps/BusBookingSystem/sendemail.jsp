<%@ page language="java" contentType="text/html; charset=ISO-8859-1"                                                                        
    pageEncoding="ISO-8859-1"%>                                                                                                             
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">                                      
<%@page import="java.util.Properties"%>                                                                                                     
<%@page import="javax.mail.Session"%>                                                                                                       
<%@page import="javax.mail.Authenticator"%>                                                                                                 
<%@page import="javax.mail.PasswordAuthentication"%>                                                                                        
<%@page import="javax.mail.Message"%>                                                                                                       
<%@page import="javax.mail.internet.MimeMessage"%>                                                                                          
<%@page import="javax.mail.internet.InternetAddress"%>                                                                                      
<%@page import="javax.mail.Transport"%>     
<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.lang.*" %>

<%@ page session="true" %>
<% 
	//String TicketId = request.getParameter("TicketId");
String TicketId =(String)session.getAttribute("TicketNo");
String uname1 =(String)session.getAttribute("fname");
String uname2 =(String)session.getAttribute("lname");
String uname=uname1+uname2;
System.out.println("final tId"+TicketId);
	String Travels = request.getParameter("Travels");	
	String email= (String)session.getAttribute("email");
%>
<head>
	<LINK href="styles.css" type="text/css" rel="stylesheet">
	<script LANGUAGE="Javascript" SRC="Images/AjaxCall.js"></script>

<SCRIPT LANGUAGE="JavaScript">
</SCRIPT>

<body >


<%

/*Declaration of variables*/

Connection con=null;
Statement stmt=null;
ResultSet rs=null;
String rFrom=null;
String rTo=null;
String JourneyDate=null;
String StartTime=null;
String ReachTime=null;
String Seats=null;
String BoardingPoint=null;
String NetAmount=null;

try
{
	/*Connection to MySQL database is made with JDBC class one driver*/
	
	con = com.balaji.travels.ConnectionPool.getConnection();
	stmt =  con.createStatement();
	String Query = "Select * from ticketdetails Where TicketId='"+TicketId+"'";
	//String Query = "Select * from ticketdetails Where TicketId='T-2'";
	System.out.println(" Qry->"+Query);
	rs = stmt.executeQuery(Query);
	int count=0,NumRows=0;
	while(rs.next()){NumRows++;}
	rs.beforeFirst();
	if(rs.next()){
					String RouteId=rs.getString(2);
					String CustomerId=rs.getString(3);
					 rFrom=rs.getString(4);
					 rTo=rs.getString(5);
					 JourneyDate=rs.getString(6);
					StartTime=rs.getString(7);
					 ReachTime=rs.getString(8);
					 Seats=rs.getString(9);
					 BoardingPoint=rs.getString(10);
					NetAmount=rs.getString(11);
					String Status=rs.getString(12);
					String PaymentId=rs.getString(13);
					String BusId=rs.getString(14);
		//Display header
		
	}else{
		%><P align='CENTER'><IMG SRC="Images/error.gif" WIDTH="17" HEIGHT="13" BORDER="0" ALT=""><FONT COLOR="red" face='Georgia'>No tickets found.Please provide valid Ticket Id</FONT><BR>
			<A HREF="ViewMyTicket.jsp">&lt;&lt; Back</A>
		</P>
		
		<%
	}
	System.out.println(count+" routes found");
}
catch(Exception e)
{
	System.out.println("Exception"+e);
}
                                                                                                                                         
String smtpServer = null;                                                                                                                   
String smtpPort = null;                                                                                                                     
final String authAddress = "apscadi@gmail.com";                                                                                
final String authPassword = "9936760286";                                                                              
String subject = null;                                                                                                                      
//String email = null;                                                                                                                        
String message = "Hello "+uname+ 
"   From=	"+rFrom +
"	To=		"+rTo+
"	JourneyDate=	"+JourneyDate+
"	StartTime=	"+StartTime+
"	ReachTime=	"+ReachTime+
"	Seats=	"+Seats+
"	BoardingPoint=	"+BoardingPoint+
"	NetAmount=	"+NetAmount;                                                                                                                      
String send = "send";                                                                                                 
String siteName=request.getServerName();                                                                                                    
siteName=siteName.replaceAll("www.","");                                                                                                    

if(send!=null){
        smtpServer = "smtp.gmail.com";
        smtpPort = "587";    
        subject = "Sri Balaji Travels Ticket Details";       
       // email = "adipschauhan@gmail.com";           
        
		       
        try{                                             
                Properties props = new Properties();     
                props.put("mail.smtp.host", smtpServer); 
                props.put("mail.smtp.port", smtpPort);   
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
                                                         
            // create some properties and get the default Session
            Session sessionMail = Session.getInstance(props, new Authenticator() {
                 public PasswordAuthentication getPasswordAuthentication() {      
                         return new PasswordAuthentication(authAddress, authPassword);
                 }                                                                    
                });                                                                   
                                                                                      
            sessionMail.setDebug(true);

            // create a message
            Message msg = new MimeMessage(sessionMail);

            // set the from and to address
            InternetAddress addressFrom = new InternetAddress(authAddress);
            msg.setFrom(addressFrom);

            InternetAddress[] addressTo = new InternetAddress[1];
            addressTo[0] = new InternetAddress(email);
            msg.setRecipients(Message.RecipientType.TO, addressTo);


            // Optional : You can also set your custom headers in the Email if you Want
            msg.addHeader("site", siteName);

            // Setting the Subject and Content Type
            msg.setSubject(subject);
            msg.setContent(message, "text/plain");
            Transport.send(msg);
        }catch(Exception e){
        	System.out.print("catch");
                e.printStackTrace(response.getWriter());
        }
}
%>
</body>
