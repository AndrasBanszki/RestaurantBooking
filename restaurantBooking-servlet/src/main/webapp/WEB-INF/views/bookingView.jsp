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
     <script type="text/javascript">
         
            function mainSetup(){
                refreshAttr();
                setMinDate();
            }
            // sets a few attributes at startup
            function refreshAttr(){
                var cityForm = document.getElementById("selectCity");
                var selectedCity = cityForm.options[cityForm.selectedIndex].value;
                if (selectedCity === "0"){
                    document.getElementById("selectRestaurant").disabled=true;
                } else if(cityForm.options[0].value === "0"){
                            cityForm.remove(0);
                       }
                var restForm = document.getElementById("selectRestaurant");
                var selectedRestaurant =restForm.options[restForm.selectedIndex].value;
                if ( !(selectedRestaurant === "0") && restForm.options[0].value === "0"){
                    restForm.remove(0);
                } 
            }
            // sets Mindate to today so you cant get a booking for Yesterday min="2000-01-02"
            function setMinDate(){
                var today = new Date();
                var dd = today.getDate(); var mm = today.getMonth()+1; var yyyy = today.getFullYear();
                if( dd < 10) dd = '0' + dd; if(mm < 10) mm = '0' + mm;
                    today = yyyy + '-' + mm + '-' + dd;
                var dateInput = document.getElementById("selectDate");
                dateInput.setAttribute("min", today);
                if(  dateInput.getAttribute("value") === null )
                    document.getElementById("selectDate").setAttribute("value", today);
            }


        </script>
  </head>
  <body onload="mainSetup();">
 
     <jsp:include page="_header.jsp"></jsp:include>
     <jsp:include page="_menu.jsp"></jsp:include>
       
     <!--
        FORM start
     -->  
    <form method="POST" action="restaurantBooking">
        
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
         
        <!--
            SELECT Restaurant
        --> 
        
        <select id="selectRestaurant" name="selectRestaurant" onChange="submit();">

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
        
        <!--
            INPUT date
        -->
        <input type="date" name="selectDate" id="selectDate" value="${selectDate}" >
        
        <input type="submit" value="Select" />
        
    </form> <!-- FORM END-->
    
     <!--
     used to write out parameters to the page, for testing
     -->
    <c:choose>
                <c:when test="${selectCity != null}">
                     Selected city: <c:out value="${selectCity}" />
                    <br />
                </c:when>    
                <c:otherwise>
                     No City selected Yet!
                    <br />
                </c:otherwise>
            </c:choose> 
     <p>Selected city: <c:out value="${selectCity}" /></p>
     
     <c:if test="${errorString} !== null" >
           <p style="color: red;">${errorString}</p>
     </c:if>
 
     <jsp:include page="_footer.jsp"></jsp:include>
 
  </body>
</html>
