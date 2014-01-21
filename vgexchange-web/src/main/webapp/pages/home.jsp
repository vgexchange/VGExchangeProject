<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Funcioned!  
</h1>
 <sec:authorize access="isAuthenticated()">
    Bem vindo(a) <sec:authentication property="principal.username"/> - <a href="<c:url value="/j_spring_security_logout"/>">Sair</a>
 </sec:authorize>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
