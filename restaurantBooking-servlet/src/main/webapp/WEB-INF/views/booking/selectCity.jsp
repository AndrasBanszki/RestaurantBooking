<%-- 
    Document   : selectCity
    Created on : 2017.08.29., 11:35:59
    Author     : Bánszki András <andras.banszki@gmail.com>
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
