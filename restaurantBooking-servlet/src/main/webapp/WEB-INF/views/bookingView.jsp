<%-- 
    Document   : restaurantList
    Created on : 2017.08.02., 16:24:59
    Author     : Bánszki András <andras.banszki@gmail.com>
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Restaurants List</title>

        <script language="text/javascript"  type="text/javascript" src="js/js.js"></script>

    </head>
    <body onload="mainSetup();">

        <%@ include file="reuse/_header.jsp" %>
        <%@ include file="reuse/_menu.jsp" %>

        <!--
           FORM start
        -->  
        <form method="GET" action="restaurantBooking">

            <!-- SELECT City -->  
            <%@ include file="booking/selectCity.jsp" %> 
            <br />
            <!-- SELECT Restaurant -->
            <%@ include file="booking/selectRestaurant.jsp" %>
            <br />
            <!-- SELECT table -->
            <%@ include file="booking/selectTable.jsp" %> 
            <br />
            <!-- INPUT date -->
            <%@ include file="booking/selectDate.jsp" %> 
            <br />
            <!-- INPUT time -->
            <%@ include file="booking/selectTime.jsp" %> 
            <br />
            <!-- LIST Booked  -->
            <%@ include file="booking/bookedTables.jsp" %> 
            <br />
            

        </form> 

        <%@ include file="booking/errorString.jsp" %> 
        <br />

        <%@ include file="reuse/_footer.jsp" %>

    </body>
</html>
