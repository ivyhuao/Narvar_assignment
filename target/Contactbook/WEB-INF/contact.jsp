<%@page contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="contact.*"%>

<jsp:useBean id="contactDao" type="contact.ContactDao" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<title>Narvar code assignment- Contact book</title>
	</head>
	
	<body>

       	<fieldset>
			<form method="POST" action="contact.html" onsubmit="return validate(this);">
			Name: <input type="text" name="name"/>
			<p>Email: <input type="text" name="email"/></p>
		    <p>	
		    	<label>Profession: </label>
		        <select id="profession" name="profession">
		       		<option value = "nurse">Nurse</option>
			    	<option value = "doctor">Doctor</option>
			        <option value = "teacher">Teacher</option>
			        <option value = "student">Student</option>
			        <option value = "engineer">Engineer</option>
		        </select>
		    </p>    
			<p id="lo" style="display: none;"><label id="locationlable"></label><input type="text" name="location" /></p>
    		<p><input type="submit" value="Add contact" /></p>
    		</form>
    	</fieldset>
    		    	<script type='text/javascript'>
    		    	function validate(form) {
    		    	    if (form.name.value == "" && form.email.value == "") {
    		    	         alert("Please finish the information before adding new contact!");
    		    	         return false;
    		    	    }else if (form.name.value == ""){
    		    	    	alert("Please input the name before adding new contact!");
   		    	         	return false;
    		    	    }else if (form.email.value == ""){
    		    	    	alert("Please input the email before adding new contact!");
   		    	         	return false;
    		    	    }else {
    		    	        return true;
    		    	    }
    		    	}

		        	$('#profession').change(function (){
				        	if($('#profession').val() == 'doctor'){
								$('#lo').show();
								document.getElementById('locationlable').innerHTML = 'Hospital: ';
				            }else if($('#profession').val()=='student'){
				            	$('#lo').show();
				            	document.getElementById('locationlable').innerHTML = 'School: ';
				            }else{
				            	$('#lo').hide();
				            }
				        });
    			</script>
		<hr>
			<ol>
			    <%
			       for (Contact contact : contactDao.getAllContacts()) {
			    %>
			    <li><%=contact%></li>
			    <%
			       }
			    %>
			</ol>
		<hr>
	</body>
</html>