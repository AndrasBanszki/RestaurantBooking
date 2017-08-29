<%-- 
    Document   : selectTable
    Created on : 2017.08.29., 11:37:16
    Author     : Bánszki András <andras.banszki@gmail.com>
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
