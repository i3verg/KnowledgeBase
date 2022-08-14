<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="STYLESHEET" type="text/css" th:href="grid.css">
    <script scr="grid.js"></script>
</head>
<body>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<c:choose>
    <c:when test="${packageSet != null}">
        <h3>List of packages</h3>
        <div id="packageGridBox" style="width: 1000px;height: 600px"></div>
        <script type="module" src="grid.js">
            var arrayData = new Array();
            <c:forEach var="packageItem" items="${packageSet}" varStatus="loop">
                arrayData[${loop.index}]="${packageItem}";
            </c:forEach>
            const toolbarData = [
                {
                    id: "add",
                    type: "button",
                    circle: true,
                    value: "Add new knowledge set",
                    size: "small",
                    full: true
                },
                {
                    type: "spacer"
                }
            ];
            const editToolbarData = [
                {
                    id: "close",
                    icon: "dxi dxi-close",
                    circle: true
                }
            ];
            const packageGrid = new dhx.Grid("packageGridBox", {
                columns: [
                    {id: "ID", gravity: 3, header: [{text: "ID"}]},
                    {id: "TITLE", gravity: 2, header: [{text: "ID"}]},
                    {
                        id: "action", gravity: 1.5, header: [{text: "Actions", align: "center"}],
                        htmlEnable: true, align: "center",
                        template: function () {
                            return "<span class='action-buttons'><a class='edit-button'>Edit</a><a class='remove-button'>Delete</a></span>"
                        }
                    }

                ],
                autoWidth: true,
                eventHandlers: {
                    onclick: {
                        "remove-button": function (e,data){
                            grid.data.remove(data.row.id);
                        }
                    }
                },
                data: arrayData
            });
        </script>
    </c:when>
    <c:otherwise>
        No User found in the DB!
    </c:otherwise>
</c:choose>
</body>
</html>

