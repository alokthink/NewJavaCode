

<%@ include file = "Header.html" %>
  <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up Form</title>
        
        
    </head>
    <body>

      <form action="Validate.jsp" method="post">
      
        <h1>Login Here</h1>
        
        <fieldset>
          <legend><span class="number">-></span>Your Login Credentials</legend>
          <font color= "black">
          
          <label for="mail">Login Username:</label>
          <input type="text" id="mail" name="Name">
          
          
          
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

<%@ include file = "footer.html" %>