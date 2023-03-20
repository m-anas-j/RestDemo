<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br>
<h2>Sample Forms</h2>
<br>
This form is for JSON POST. It will send the form data to the servlet, where the information
will be converted to a JSON object, and then sent to a RESTful endpoint that can consume JSON objects.
<br>
<form method="post" action="hello-servlet">
    ID: <input type="text" name="id-field">
    <br>
    Name: <input type="text" name="name-field">
    <br>
    Semester: <input type="text" name="semester-field">
    <br>
    <input type="submit" value="Submit">
</form>
<br>
This form is for HTML form POST. The form information will be directly sent to a RESTful endpoint
that can consume HTML form data.
<br>
<form method="post" action="http://localhost:8082/RestDemo/api/student/new-student">
    ID: <input type="text" name="id-field">
    <br>
    Name: <input type="text" name="name-field">
    <br>
    Semester: <input type="text" name="semester-field">
    <br>
    <input type="submit" value="Submit">
</form>

<a href="hello-servlet">Click here to see list of all students.</a>
</body>
</html>