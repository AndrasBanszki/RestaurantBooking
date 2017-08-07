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
  </head>
  <body>
 
     <jsp:include page="_header.jsp"></jsp:include>
     <jsp:include page="_menu.jsp"></jsp:include>
    
    <h3>Restaurants List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="0" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Restaurant</th>
          <th>City</th>
          
       </tr>
       <c:forEach var="Restaurant" items="${restList}"  >
          <tr>
             <td>
                 <c:out value="${Restaurant.name}" />
             </td>
             <td>
                <c:forEach items="${cityList}" var="City">
                    <c:if test="${Restaurant.city == City.id}">
                        ${City.name}
                    </c:if>
                </c:forEach>
             </td>

          </tr>
       </c:forEach>
    </table>
      
 
     <jsp:include page="_footer.jsp"></jsp:include>
 
  </body>
</html>
