<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="/resources/grid/grid.js"></script>
    <link rel="stylesheet" href="/resources/grid/grid.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script type="text/javascript" src="/resources/jquery-3.6.0.js"></script>
    <style>
        .deleteButton {
            background-color: DodgerBlue;
            border: none;
            color: white;
            padding: 12px 16px;
            font-size: 16px;
            cursor: pointer;
        }

        /* Darker background on mouse-over */
        .deleteButton:hover {
            background-color: RoyalBlue;
        }
    </style>
</head>
<body>

<div id="packageGrid">
    <h3>List of packages</h3>
    <section class="dhx_sample-controls">
        <button id="addButton" class="btnAdd">Add knowledge set</button>
    </section>
</div>

<c:if test="${not empty msg}">
    ${msg}
</c:if>
<c:choose>
    <c:when test="${packageSet != null}">
        <script type="text/javascript">
            const dataSheet = new dhx.DataCollection().parse(${packageSet});
            const packageGrid = new dhx.Grid("packageGridBox", {
                css: "dhx_demo-grid",
                columns: [
                    {id: "knowledgePackageId", header: [{text: "ID"}, {content: "inputFilter"}]},
                    {id: "knowledgePackageTitle", header: [{text: "TITLE"}, {content: "inputFilter"}]},
                    {
                        id: "action", gravity: 1.5, header: [{text: "Actions", align: "center", rowspan: 2}],
                        htmlEnable: true, align: "center", template: deleteButtonTemplate
                    }
                ],
                autoWidth: true,
                height: (Number(dataSheet.length) + 2) * 50,
                rowHeight: 30,
                data: dataSheet,
                htmlEnable: true,
                resizable: true,
                sortable: true,
                eventHandlers: {
                    onclick: {
                        "deleteButton": function (e, data) {
                            $.ajax({
                                type: "DELETE",
                                url: 'http://localhost:8080/set/' + data.row.knowledgePackageId,
                            })
                            packageGrid.data.remove(data.row.id)
                        },
                    }
                },
                selection: "row"
            });
            function deleteButtonTemplate() {
                return '<button class="deleteButton"><i class="fa fa-trash"></i></button>';
            }
        </script>

    </c:when>
    <c:otherwise>
        No Package found in the DB!
    </c:otherwise>
</c:choose>
</body>
</html>

