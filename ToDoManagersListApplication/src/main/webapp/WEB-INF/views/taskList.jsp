<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>To Do Tasks List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/tasklist.css">
</head>
<body>
    <header>
        <h1>To Do Tasks List</h1>
        <a href="${pageContext.request.contextPath}/tasks?action=add" class="add-task-btn">Add New Task</a>
    </header>
    <main>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Description</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="task" items="${tasks}">
                    <tr>
                        <td>${task.id}</td>
                        <td>${task.description}</td>
                        <td>${task.status}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/tasks?action=delete&id=${task.id}" class="delete-btn" onclick="return confirm('Please click OK to delete');">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </main>
</body>
</html>