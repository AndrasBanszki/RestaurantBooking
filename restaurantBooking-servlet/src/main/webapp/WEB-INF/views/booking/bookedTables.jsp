<%-- 
    Document   : bookedTables
    Created on : 2017.08.29., 11:38:49
    Author     : Bánszki András <andras.banszki@gmail.com>
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:choose>
    <c:when test="${tableBookings.size() > 0}">               
        <table border="0" cellpadding="5" cellspacing="1" >

            <tr>
                <th>Time:</th>
                <th>Table reserved:</th>
                <th>Duration:</th>
            </tr>

            <c:forEach var="tableBooking" items="${tableBookings}"  >
                <tr>
                    <td>
                        <c:out value="${tableBooking.booking.dateTime.getHour()} : ${tableBooking.booking.dateTime.getMinute()}" />
                    </td>
                    <td>
                        <c:out value="${tableBooking.table.tableNo}" />
                    </td>
                    <td>
                        <c:out value="${tableBooking.booking.duration}" />
                    </td>
                </tr>
            </c:forEach>    
        </table>

    </c:when>    
    <c:otherwise>
        No reservations for the selected day, try out 2017.09.01 and select Nyíregyháza and Tírpák falatozó

    </c:otherwise>
</c:choose> 
