<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <spring:theme code="styleSheet" var="app_css"/>
    <spring:url value="/${app_css}" var="app_css_url"/>
    <spring:url value="/resources/grid/grid.js" var="grid_url"/>
    <script src="${grid_url}" type="text/javascript">
        <jsp:text/>
    </script>
</head>
<style>
    .packageGrid {
        display: grid;
        grid-template-columns: auto auto auto;
        background-color: #2196F3;
        padding: 10px;
    }
</style>
<body>
<c:if test="${not empty msg}">
    ${msg}
</c:if>
<c:choose>
    <c:when test="${packageSet != null}">
        <h3>List of packages</h3>

        <div id="layout" style="height: 100%;"></div>



        <script type="text/javascript">
            const dataSheet = new dhx.DataCollection().parse(${packageSet});
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
                    {width: 500, id: "knowledgePackageId", header: [{text: "ID"}]},
                    {width: 500, id: "knowledgePackageTitle", header: [{text: "TITLE"}]}
                ],
                headerRowHeight: 42,
                data: dataSheet,
                adjust: true
            });
            initGrid();
        </script>

    </c:when>
    <c:otherwise>
        No User found in the DB!
    </c:otherwise>
</c:choose>
<div id="packageGrid" style="height: 100%; width: 100%">

</div>
</body>
</html>

