<%--
  Created by IntelliJ IDEA.
  User: Alexandr
  Date: 15.01.2021
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Questionnaire</title>
</head>
<body>
<form action="/statistics">
  <p>Humeniuk Alexandr Homework1</p>
  <p>Question 1. Are you older than 10?</p>
  <input type="radio" name="age" value="yes">Yes <br>
  <input type="radio" name="age" value="no">No <br>
  <p>Question 2. How are you?</p>
  <input type="radio" name="feeling" value="good">Good <br>
  <input type="radio" name="feeling" value="bad">Bad <br>
  <input type="submit" value="See answers">
</form>
</body>
</html>
