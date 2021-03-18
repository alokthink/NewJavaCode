<%@ include file = "Header.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<script language="JavaScript"
			src="<%=request.getContextPath() + "/js/gen_validatorv31.js"%>"
			type="text/javascript">
		</script>

		<script language="JavaScript" src="scripts/gen_validatorv31.js"
			type="text/javascript">
</script>
		<script language="JavaScript" type="text/javascript"
			src="scripts/ts_picker.js">
</script>
		<script language="JavaScript1.1" src="scripts/pass.js">

</script>
		<script type="text/javascript" src="scripts/image.js">
</script>
		<script type="text/javascript" src="scripts/general.js">
</script>
		<script type="text/javascript" src="scripts/adi.js">
</script>
		<script type="text/javascript" src="scripts/form_validation.js">
</script>
		<script language="JavaScript" src="images/javascripts.js">
</script>
		<script language="JavaScript" src="images/pop-closeup.js">
</script>
		<script>

//var x_win = window.self; 

function goOn() {
	var port = document.register.port.value;
	var host = document.register.host.value;
	var loginname = document.register.loginname.value;
	

}
</script>



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
</style>
		<body>
			
			
			<form action="ploadSuccess" method="post"
				name="register" onSubmit="return validate()" encType="multipart/form-data">
				<!--<table border="1"><tr><td></td></tr></table>-->
				<input type="hidden" name="port" value="<%=request.getLocalPort()%>">
					<input type="hidden" name="host"
						value="<%=request.getServerName()%>">
						<br>
<h1>Sign Up</h1>
        
        <fieldset>
          <legend><span class="number"></span>Your basic info</legend>
          <font color= "black"><label for="name" >Email Id:</label>
           <input type="email" id="mail" name="email">
								
								
										<label for="password">Password:</label>
         
          
										<input type="password" id="password" name="pass"
											onkeyup="testPassword(document.forms.register.password.value);"
											onChange="Encrypt(document.forms.register.password.value);">
									
								
										<a id="Words"> Strength:</a>
									
									
										<table cellpadding=0 cellspacing=0>
											<tr>
												<td height=15 bgcolor=#dddddd></td>
											</tr>
										</table>
									
                                         <label>Confirm Password:</label>
										<input type="password" name="conformpassword" value=""
											size="20" onBlur="checkconformpassword()" />
									
									
									<label>Address:</label>
          <input type="text" id="under_13"  name="address"><br>
          
        

									<label>SecurityQuestion:</label>
										

									
										<select name="forgotpwquestion">
											<option value="select" selected="true">
												<font size="3" face="Verdana">--Select One---</font>
											</option>
											<option value="What is your favorite pastime?">
												<font size="3" face="Verdana">What is your favorite
												pastime?</font>
											</option>
											<option value="Who your childhood hero?">
												<font size="3" face="Verdana">Who your childhood
												hero?</font>
											</option>
											<option value="What is the name of your first school?">
												<font size="3" face="Verdana">What is the name of
												your first school?</font>
											</option>
											<option value="Where did you meet your spouse?">
												<font size="3" face="Verdana">Where did you meet your
												spouse?</font>
											</option>
											<option value="What is your favorite sports team?">
												<font size="3" face="Verdana">What is your favorite
												sports team?</font>
											</option>
											<option value="What is your father middle name?">
												<font size="3" face="Verdana">What is your father
												middle name?</font>
											</option>
											<option value="What was your high school mascot?">
												<font size="3" face="Verdana">What was your high
												school mascot?</font>
											</option>
											<option value="What make was your first car or bike?">
												<font size="3" face="Verdana">What make was your
												first car or bike?</font>
											</option>
											<option value="What is your pet name?">
												<font size="3" face="Verdana">What is your pet name?</font>
											</option>
										</select>
									
									<td colspan="2">
										<!--  <input type="checkbox" name="ch" value="1"
							onClick="check(register)" />
						Own Question-->

									</td>
								
										<label for="Security Answer">Security Answer:</label>
         
										<input type="text" name="forgotpwanswer" value="" size="20" />
									
								

								
											<label>First Name :</label>
										

									
										<input type="text" name="firstName" value="">
									
									<label>Last Name :</label>

									
										<input type="text" name="lastName" value="" size="20" />
									<label>Birth Date :</label>
										

									
										<input type="text" name="birthDate" value="" size="20"
											readonly="readonly" />
										<center><a
											href="javascript:show_calendar('document.register.birthDate', document.register.birthDate.value);">
											<img src="Images/cal.gif" alt="a" width="18" height="18"
												border="0" /> </a></center>
									
										</br>
									 		<label>Upload Photo :</label>
									
										<center><img alt="See Photo Here" id="previewField"
											src="Images/upload.png" height="150" width="120">
											<input type="file" name="photo" size="50"
												onChange="preview(this)" /></center>
							

										<label>Gender</label>

									
										<select name="gender">
											<option value="select" selected="true">
												<font size="3" face="Verdana">Select </font>
											</option>
											<option value="Male">
												<font size="3" face="Verdana">Male</font>
											</option>
											<option value="Female">
												<font size="3" face="Verdana">Female</font>
											</option>
										</select>
									
											<label> Pin Code </label>

										
											<input type="text" name="pin" value="" size="20" />
										

											<label> Mobile Number :</label>


										
											<input type="text" name="mob" value="" size="20" />
										
</font></fieldset>


									
											<button type="submit" name="register">Sign Up</button>
											</br>
											<button type="reset" name="cancel">Reset</button>
												 
										
			</form>

			<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("register");

frmvalidator.addValidation("loginname", "req", "Please enter LoginName");
frmvalidator.addValidation("loginname", "maxlen=20",
		"Max length for LoginName is 20");
frmvalidator.addValidation("password", "req", "Please enter Password");
frmvalidator.addValidation("password", "maxlen=20",
		"Max length for LoginName is 20");
frmvalidator.addValidation("logintype", "dontselect=0");
frmvalidator.addValidation("forgotpwquestion", "dontselect=0");

frmvalidator.addValidation("forgotpwanswer", "req",
		"Please enter Security Question Answer");
frmvalidator.addValidation("forgotpwanswer", "req",
		"Please enter Security Question Answer");

frmvalidator.addValidation("firstname", "req", "Please enter FirstName");
frmvalidator.addValidation("firstname", "maxlen=20",
		"Max length for FirstName is 20");
frmvalidator.addValidation("firstname", "alpha",
		" First Name Alphabetic chars only");
frmvalidator.addValidation("lastname", "req", "Please enter LastName");
frmvalidator.addValidation("lastname", "maxlen=20",
		"Max length for LastName is 20");
frmvalidator.addValidation("lastname", "alpha",
		" Last Name Alphabetic chars only");
frmvalidator.addValidation("birthDate", "req", "Please enter your DOB");
frmvalidator.addValidation("photograph", "req", "Please Load Your Photo");
frmvalidator.addValidation("gender", "dontselect=0");

frmvalidator.addValidation("emailid", "maxlen=50");
frmvalidator.addValidation("emailid", "req");
frmvalidator.addValidation("emailid", "email");

frmvalidator.addValidation("fax", "req", "Please enter Fax Number");
</script>
			
		</body>
</html>
