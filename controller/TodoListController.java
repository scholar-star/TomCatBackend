package org.zerock.tomproject2.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.tomproject.todo.dto.TodoDTO;
import org.zerock.tomproject.todo.service.TodoService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="todoListController", value="/todo/list")
@Log4j2
public class TodoListController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        log.info("todo list.......");
        ServletContext context = req.getServletContext(); // servletcontext 얻기
        log.info("appName: "+context.getAttribute("appName")); // appName 공유자원

        // log test
        try {
            List<TodoDTO> dtoList = todoService.listAll();
            req.setAttribute("dtoList", dtoList);
            req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException(e);
        }
    }
}
