<%--
  Created by IntelliJ IDEA.
  User: SLIVKA
  Date: 19.11.2024
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Upload File</h2>
<form method="POST" action="uploadServlet" enctype="multipart/form-data">
    Choose a file: <input type="file" name="uploadServlet" />
    <input type="submit" value="Upload" />
</form>
</body>
</html>
