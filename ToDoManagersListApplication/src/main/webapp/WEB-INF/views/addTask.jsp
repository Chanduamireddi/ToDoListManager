<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Task</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/addtask.css">
</head>
<body>
    <header>
        <h1>Add New Task</h1>
        <a href="${pageContext.request.contextPath}/tasks?action=view" class="add-task-btn">Back to Task List</a>
    </header>
    <main>
        <div class="container">
            <form action="${pageContext.request.contextPath}/tasks" method="post">
                <div class="form-group">
                    <label for="description">Description:</label>
                    <input type="text" id="description" name="description" required>
                </div>
                
                <div class="form-group">
                    <label for="status">Status:</label>
                    <select id="status" name="status" required>
                        <option value="Pending">Pending</option>
                        <option value="Completed">Completed</option>
                    </select>
                </div>
                
                <button type="submit" class="submit-btn">Add Task</button>
            </form>
        </div>
    </main>
</body>
</html>
