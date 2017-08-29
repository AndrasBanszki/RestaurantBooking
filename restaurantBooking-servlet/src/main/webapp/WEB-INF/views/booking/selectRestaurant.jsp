<%-- 
    Document   : selectRestaurant
    Created on : 2017.08.29., 11:36:30
    Author     : Bánszki András <andras.banszki@gmail.com>
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
