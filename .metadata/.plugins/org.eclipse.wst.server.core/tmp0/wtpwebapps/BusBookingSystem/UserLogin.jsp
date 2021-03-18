

<%@ include file = "Header.html" %>

 <%
   
    String name1=null;
  name1=(String)session.getAttribute("fname");
   
System.out.println(name1);
if(name1!=null)
{
	response.sendRedirect("SearchBus.jsp");
}
else 

{ %>
  <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up Form</title>
        
    </head>
    <body>

      <form action="ValidateUser.jsp" method="post">
      
        <h1>Login Here</h1>
        
        <fieldset>
          <legend><span class="number">-></span>Your Login Credentials</legend>
          <font color= "black">
          
          <label for="mail">Email Address:</label>
          <input type="email" id="email" name="email">
          
          
          
          <br>
          </fieldset>
        
        
        <fieldset>
        
        
          <label>Password:</label></font>
          <input type="password" id="development"  name="Pwd"><br>
            
        </fieldset>
        <button type="submit">Log In</button>
      </form>
      
    </body>
</html>
<%} %>
<%@ include file = "footer.html" %>