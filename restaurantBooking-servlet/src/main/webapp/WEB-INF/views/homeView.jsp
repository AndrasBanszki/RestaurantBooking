<%-- 
    Document   : homeview
    Created on : 2017.08.02., 15:36:35
    Author     : Bánszki András <andras.banszki@gmail.com>
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Home Page</title>
    </head>
    <body>

        <%@ include file="reuse/_header.jsp" %>
        <%@ include file="reuse/_menu.jsp" %>

            <h3>Home Page</h3>

            This is demo Simple web application using jsp,servlet &amp; Jdbc. <br><br>
            <b>It includes the following functions:</b>
            <ul>
                <li>List all of the Restaurants that is available in the list.</li>
                <li>Make restaurant booking</li>
                <li>Login which is not ready yet</li>
                <li>Storing user information in cookies, wich is not ready yet</li>
            </ul>

            <ul>
                <li>MYSQL to store data somewhere</li>
                <li>JDBC to acces MYSQL</li>
                <li>POJO-s for the model of those datas</li>
                <li>DAO classes, to acces the data</li>
                <li>Junit tests, just to test my DAO classes </li>
                <li>JavaEE Servlets, to do some stuff, mainly act as the Controller</li>
                <li>JavaServerPages easier to list out our date for the user</li>
                <li>JavaScript some manipulation of the forms, default values</li>
                <li>HTML5 of course why not, users better see some layout they like</li>
                <li>CSS for some fancy out look of our HTML</li>
            </ul>
            
        <%@ include file="reuse/_footer.jsp" %>

    </body>
</html>