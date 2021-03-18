<%@page import="java.util.Properties"%>
<%@page import="javax.mail.*,javax.mail.internet.*"%>

<% String to = request.getParameter("email");

      // Sender's email ID needs to be mentioned
      String from = "apscadi@gmail.com";

      // Assuming you are sending email from localhost
      String host = "aadityaathaakur@gmail.com";

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      properties.setProperty("mail.smtp.host", host);

      // Get the default Session object.
      Session sess = Session.getDefaultInstance(properties);

      try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(sess);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("SUVJECT_LINE");

         // Now set the actual message
         message.setText("YOUR MESSAGE GOES HERE");

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   
   %>