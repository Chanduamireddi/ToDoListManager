package com.todomanagerlist.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import com.todomanagerlist.model.Task;
import com.todomanagerlist.model.TaskRepository;

public class TaskController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private TaskRepository taskRepository = new TaskRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("view".equals(action) || action == null) {
            List<Task> tasks = taskRepository.getAll();
            request.setAttribute("tasks", tasks);
            request.getRequestDispatcher("/WEB-INF/views/taskList.jsp").forward(request, response);
        } else if ("add".equals(action)) {
            request.getRequestDispatcher("/WEB-INF/views/addTask.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
            String idStr = request.getParameter("id");
            if (idStr != null) {
                try {
                    int taskId = Integer.parseInt(idStr);
                    boolean deleted = taskRepository.delete(taskId);
                    if (deleted) {
                        response.sendRedirect(request.getContextPath() + "/tasks?action=view");
                    } else {
                        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Task not found");
                    }
                } catch (NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid task ID format");
                }
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Task ID is required for deletion");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action specified");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        if (description != null && !description.trim().isEmpty() && status != null && !status.trim().isEmpty()) {
            taskRepository.add(description.trim(), status.trim());
            response.sendRedirect(request.getContextPath() + "/tasks?action=view");
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Description and status are required");
        }
    }
}
