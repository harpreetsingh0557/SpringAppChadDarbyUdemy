<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Input Form</title>
</head>
<body>
	
	  
	<!--<form action="processForm" method="get"> -->
	<form action="processFormCapitalLetter" method="get">	
		<div class = "usernameText">
			<label for = "studentName">Enter your name:</label>		
			<input 	type = "text" id = "studentName" name = "usernameText"
					placeholder="Apnaa naa daso"> 
		</div>
		
		<div class = "submitButton">
			<label for = "submitButton"></label>		
			<input 	type = "submit" id = "submitButton" name = "submitButton"
					placeholder="Daseya te age suto"> 
		</div>
					
	</form>
	
	
</body>
</html>