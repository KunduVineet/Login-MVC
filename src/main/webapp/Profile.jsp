<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="in.sp.Model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 20px;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    h1 {
        color: #333;
        margin-bottom: 20px;
    }
    h3 {
        color: #555;
        margin: 10px 0;
    }
    a {
        text-decoration: none;
        color: white;
        background-color: #d9534f;
        padding: 10px 20px;
        border-radius: 4px;
        font-size: 16px;
        margin-top: 20px;
    }
    a:hover {
        background-color: #c9302c;
    }
</style>
</head>
<body>
    <%
        User user = (User) session.getAttribute("session_user");
    %>
    <h1>Welcome to the Profile Page</h1>

    <h3>Name: <%= user.getName() %></h3>
    <h3>Email: <%= user.getEmail() %></h3>
    <h3>City: <%= user.getCity() %></h3>

    <a href="LogOut">Log Out</a>
</body>
</html>
