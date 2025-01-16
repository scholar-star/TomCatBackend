package org.zerock.tomproject.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.tomproject.todo.dto.TodoDTO;
import org.zerock.tomproject.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.server.ServerCloneException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "todoRegisterController", value="/todo/register")
@Log4j2
public class TodoRegisterController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-mm-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        log.info("/todo/register GET.......");
        req.getRequestDispatcher("/WEB-INF/todo/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        TodoDTO todoDTO = TodoDTO.builder()
                .title(req.getParameter("title"))
                .dueDate(LocalDate.parse(req.getParameter("dueDate"), DATEFORMATTER))
                .build();
        // dueDate 데이터는 dueDate에서 LocalDate.parse로 파싱하여 받는다.
        log.info("/todo/register POST......");
        log.info(todoDTO);
        try {
            todoService.register(todoDTO);
        } catch(Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/todo/list");
        // 추가 완료시 리다이렉트
    }
}
