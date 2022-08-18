<%--
  Created by IntelliJ IDEA.
  User: Sava
  Date: 17.08.2022
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<title>Spring MVC and JDBC CRUD Example</title>
<body>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<h3>Add User</h3>
<form method="POST" name="add_package" action="<%=request.getContextPath()%>/add/package">
    Title: <input name="ptitle" value="${packageTitle}" type="text"/> <br/>
    <h2>Knowledge list</h2>
        <script type="text/javascript">
            const dataSheet = new dhx.DataCollection().parse(${knowledgeSet});
            <c:set var="knowldgeSetDto" value=""/>
            let knowledgeIds = new Array();
            const packageGrid = new dhx.Grid("packageGridBox", {
                css: "dhx_demo-grid",
                columns: [
                    {id: "knowledgeId", header: [{text: "ID"}]},
                    {id: "knowledgeTitle", header: [{text: "TITLE"}]}
                ],
                autoWidth: true,
                height: (Number(dataSheet.length) + 2) * 50,
                rowHeight: 30,
                data: dataSheet,
                htmlEnable: true,
                selection: "row",
                eventHandlers: {
                    onclick: {
                        "deleteButton": function (e, data) {
                            knowledgeIds.push()
                            packageGrid.data.remove(data.row.id)
                        },
                    }
                }
            });
        </script>
    type="text"/><br/> <br/> <input value="Add package" type="submit"/>
</form>
</body>
</html>
