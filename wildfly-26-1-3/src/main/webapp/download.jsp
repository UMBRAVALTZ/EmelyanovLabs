<%--
  Created by IntelliJ IDEA.
  User: SLIVKA
  Date: 19.11.2024
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
</head>
<body>
<h1>Скачать файл с сервера</h1>
<form action="downloadServlet" method="GET">
    <label for="file">Файл:</label>
    <select name="fileType" id="file">
        <option value="pdf">pdf</option>
        <option value="docx">docx</option>
        <option value="asm">asm</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
    </select>
    <button type="submit">Скачать</button>
</form>
</body>
</html>
