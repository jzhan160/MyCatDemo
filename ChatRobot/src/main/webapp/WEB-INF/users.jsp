<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table width="100%" border=1>
    <tr>
        <td>id</td>
        <td>email</td>
        <td>username</td>
        <td>role</td>
        <td>status</td>
    </tr>
    <c:forEach items="${userList}" var="user">
    <tr>
        <td>${user.id }</td>
        <td>${user.email }</td>
        <td>${user.username }</td>
        <td>${user.role}</td>
        <td>${user.status}</td>
    </tr>
    </c:forEach>

</table>

</body>
</html>
