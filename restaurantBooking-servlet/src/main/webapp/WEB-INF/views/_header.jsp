<%-- 
    Document   : _header
    Created on : 2017.08.02., 14:37:12
    Author     : Bánszki András <andras.banszki@gmail.com>
--%>

    
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<div style="background: #E0E0E0; height: 55px; padding: 5px;">
  <div style="float: left">
     <h1>Restaurant</h1>
  </div>
 
  <div style="float: right; padding: 10px; text-align: right;">
 
     <!-- User store in session with attribute: loginedUser -->
     Hello <b>${loginedUser.userName}</b>
  
 
  </div>
 
</div>