<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ipl Form</title>
</head>
<%-- getServletContext().setAttribute("ipl",new IplBean()) --%>
<jsp:useBean id="ipl" class="beans.IplBean" scope="application"/>
<body>
<%-- display team details --%>
<%-- getServletContext().getAttribute("ipl"):IplBean-->getAllTeams --%>
<h3>Teams:${applicationScope.ipl.allTeams}</h3>
</body>
</html>