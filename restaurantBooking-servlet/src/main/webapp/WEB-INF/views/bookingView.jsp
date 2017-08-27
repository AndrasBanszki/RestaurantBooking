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
      
     <jsp:include page="_header.jsp"></jsp:include>
     <jsp:include page="_menu.jsp"></jsp:include>
       
     <!--
        FORM start
     -->  
    <form method="GET" action="restaurantBooking">
        
         <!--
             SELECT City
         -->    
        <select id="selectCity" name="selectCity" onChange="submit();">
             <option value="0">Select City</option>
            <c:forEach items="${cityList}" var="city">
                <c:choose>
                    <c:when test="${selectCity == city.id}">
                         <option selected="selected" value="${city.id}"><c:out value="${city.name}" /></option>
                        <br />
                    </c:when>    
                    <c:otherwise>
                         <option value="${city.id}"><c:out value="${city.name}" /></option>
                        <br />
                    </c:otherwise>
                </c:choose>

            </c:forEach>
        </select>
        
         <br /> 
        <!--
            SELECT Restaurant
        --> 
        
        <select id="selectRestaurant" name="selectRestaurant" onChange="submit();" disabled="true" >

         <option value="0">Select Restaurant</option>
         
           <c:forEach items="${restList}" var="rest">
               <c:choose>
                   <c:when test="${selectRestaurant == rest.id}">
                        <option selected="selected" value="${rest.id}"><c:out value="${rest.name}" /></option>
                       <br />
                   </c:when>    
                   <c:otherwise>
                        <option value="${rest.id}"><c:out value="${rest.name}" /></option>
                       <br />
                   </c:otherwise>
               </c:choose>

           </c:forEach>
       </select>          
        
         <br />
         <!-- 
            SELECT table
        -->
        <select id="selectTable" name="selectTable" onChange="submit();" disabled="true" >
             <option value="0">Select Table</option>
            <c:forEach items="${restTables}" var="table">
                <c:choose>
                    <c:when test="${selectTable == table.id}">
                         <option selected="selected" value="${table.id}">
                             <c:out value="${table.tableNo}. table: ${table.numberOfSeats}" />
                         </option>
                        <br />
                    </c:when>    
                    <c:otherwise>
                         <option value="${table.id}">
                             <c:out value="${table.tableNo}. table: ${table.numberOfSeats}" /> 
                         </option>
                        <br />
                    </c:otherwise>
                </c:choose>

            </c:forEach>
        </select>
        
        <br/>
        <!--
            INPUT date
        -->
        <input type="date" name="selectDate" id="selectDate" value="${selectDate}" onChange="submit();" >
        
        <br />
        
        <!-- 
            input time
        -->
        <input type="time" name="selectTime" id="selectTime" value="${selectTime}" min="08:00" max="22:00">
        
        <br />
        
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
        
        
        
        
        <br />
        <input type="submit" value="Select" />
                    
    </form> <!-- FORM END-->
    
     <!--
     used to write out parameters to the page, for testing
     -->


     
     <c:if test="${errorString} !== null" >
           <p style="color: red;">${errorString}</p>
     </c:if>
 
     <jsp:include page="_footer.jsp"></jsp:include>
 
  </body>
</html>
