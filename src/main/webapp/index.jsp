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
Sample Form
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

<a href="hello-servlet">Click here to see list of all students.</a>
</body>
</html>