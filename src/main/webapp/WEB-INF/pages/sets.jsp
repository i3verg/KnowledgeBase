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
</head>
<div id="packageGrid" >
    <h3>List of packages</h3>
    <section class="dhx_sample-controls">
        <button id="hide" class="dhx_sample-btn dhx_sample-btn--flat">Add knowledge set"</button>
    </section>
</div>

<c:if test="${not empty msg}">
    ${msg}
</c:if>
<c:choose>
    <c:when test="${packageSet != null}">
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
            const editFormConfig = {
                padding: 0,
                rows: [
                    {
                        id: "id",
                        type: "input",
                        name: "id",
                        hidden: true
                    },
                    {
                        type: "input",
                        name: "title",
                        label: "Title"
                    },
                    {
                        type: "input",
                        name: "authors",
                        label: "Authors"
                    },
                    {
                        type: "input",
                        name: "average_rating",
                        label: "Rating"
                    },
                    {
                        type: "datepicker",
                        name: "publication_date",
                        label: "Publication date",
                        dateFormat: "%d/%m/%Y"
                    },
                    {
                        align: "end",
                        cols: [
                            {
                                id: "apply-button",
                                type: "button",
                                text: "Apply",
                                icon: "mdi mdi-check",
                                circle: true,
                            }
                        ]
                    }

                ]
            }
            const packageGrid = new dhx.Grid("packageGridBox", {
                css: "dhx_demo-grid",
                columns: [
                    {id: "knowledgePackageId", header: [{text: "ID"}, {content: "inputFilter"}]},
                    {id: "knowledgePackageTitle", header: [{text: "TITLE"}, {content: "inputFilter"}]},
                    {
                        id: "action", gravity: 1.5, header: [{ text: "Actions", align: "center", rowspan: 2 }],
                        htmlEnable: true, align: "center",

                        template: function () {
                            return "<div class='myCustomCell'><span>United Kingdom</span><img src='https://snippet.dhtmlx.com/codebase/data/combobox/01/img/gb.png'></div>"
                        }
                    }
                ],
                autoWidth: true,
                height: (Number(dataSheet.length)+2)*35,
                rowHeight: 30,
                data: dataSheet,
                htmlEnable: true,
                resizable: true,
                sortable: true,
                eventHandlers: {
                    onclick: {
                        "remove-button": function (e, data) {
                            $.ajax({
                                type: "DELETE",
                                url: 'http://localhost:8080/set/'+data.row.knowledgePackageId,
                                error : function (error){
                                    alert(error);                                }
                            })
                            packageGrid.data.remove(data.row.id)
                        },
                        "edit-button": function (e, data) {
                            openEditor(data.row.id);
                        }
                    }
                },
                selection : "row"
            });

            //packageGrid.events.on("click", function(id) {
              //  if (id)
            //})

            function openEditor(id) {
                editWindow.show();
                const item = grid.data.getItem(id);
                if (item) {
                    editForm.setValue(item);
                }
            }
            function closeEditor() {
                editForm.clear();
                editWindow.hide();
            }
            function deletePackage(id){

            }

        </script>

    </c:when>
    <c:otherwise>
        No User found in the DB!
    </c:otherwise>
</c:choose>
<div id="toolbarData" style="height: 50px"></div>
</html>

