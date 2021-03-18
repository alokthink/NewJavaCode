

<%@ include file = "Header.html" %>
  <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up Form</title>
        
        
    </head>
    <body>

      <form action="register.jsp" method="post">
      
        <h1>Sign Up</h1>
        
        <fieldset>
          <legend><span class="number"></span>Your basic info</legend>
          <font color= "black"><label for="name" >Name:</label>
          <input type="text" id="cname" name="cname">
          
          <label for="mail">Email:</label>
          <input type="email" id="mail" name="email">
          
          <label for="password">Password:</label>
          <input type="password" id="password" name="pass">
          
          <label>Address:</label>
          <input type="text" id="under_13"  name="address"><br>
          </fieldset>
        
        
        <fieldset>
        
        <label>PIN:</label>
          <input type="text" id="under_13"  name="pin"><br>
          <label>Phone:</label></font>
          <input type="Text" id="development"  name="phone"><br>
            
        </fieldset>
        <button type="submit">Sign Up</button>
      </form>
      
    </body>
</html>

<%@ include file = "footer.html" %>