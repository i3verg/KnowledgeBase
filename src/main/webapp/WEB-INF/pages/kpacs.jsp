<%--
  Created by IntelliJ IDEA.
  User: Sava
  Date: 12.08.2022
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Spring MVC and JDBC CRUD Example</title>
<body>
<h2>Spring MVC and JDBC CRUD Example</h2>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<c:choose>
    <c:when test="${knowledge != null}">
        <h3>List of knowledge</h3>
        <table cellpadding="5" cellspacing="5">
            <thead>
            <tr>
                <th>ID</th>
                <th>TITLE</th>
                <th>DESCRIPTION</th>
                <th>CREATION DATE</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="knowledge" items="${knowledge}">
                <tr>
                    <td>${knowledge.knowledgeId}</td>
                    <td>${knowledge.knowledgeTitle}</td>
                    <td>${knowledge.knowledgeDescription}</td>
                    <td>${knowledge.creationDate}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        No User found in the DB!
    </c:otherwise>
</c:choose>
</body>
</html>
