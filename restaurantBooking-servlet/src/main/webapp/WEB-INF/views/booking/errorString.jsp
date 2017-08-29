<%-- 
    Document   : errorString
    Created on : 2017.08.29., 12:47:11
    Author     : Bánszki András <andras.banszki@gmail.com>
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:if test="${errorString} !== null" >
    <p style="color: red;">${errorString}</p>
</c:if>