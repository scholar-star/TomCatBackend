package org.zerock.tomproject2.controller;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.zerock.tomproject.todo.dto.TodoDTO;
import org.zerock.tomproject.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoReadController", value="/todo/read")
@Log4j2
public class TodoReadController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        try {
            Long tno = Long.parseLong(req.getParameter("tno"));
            TodoDTO todoDTO = todoService.get(tno);

            // 모델 담기
            req.setAttribute("dto",todoDTO);

            // 쿠키 찾기
            Cookie viewTodoCookie = findCookie(req.getCookies(), "viewTodos"); // 요청에서 쿠키를 얻어 비교한 뒤 찾아 건네준다
            String todoListStr = viewTodoCookie.getValue(); // cookie에서 값 얻기
            boolean exist = false;

            if(todoListStr != null && todoListStr.indexOf(tno+"-")>=0) {
                // cookie가 있으면서 tno- 형태가 있으면
                exist = true; // 존재
            }

            log.info("exist: "+exist);

            if(!exist) {
                todoListStr += tno + "-";
                viewTodoCookie.setValue(todoListStr);
                viewTodoCookie.setMaxAge(60 * 60 * 24);
                viewTodoCookie.setPath("/"); // path 이하 경로에서 접근 가능하게 함
                resp.addCookie(viewTodoCookie); // 쿠키저장
            }

            req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new ServletException("read error");
        }
    }

    private Cookie findCookie(Cookie[] cookies, String name) {
        Cookie targetCookie = null;

        if(cookies != null && cookies.length > 0) {
            // 무효화되지 않고 1개 이상 있는 경우
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals(name)) {
                    targetCookie = cookie;
                    break;
                }
            }
        }

        if(targetCookie == null) {
            // 쿠키 자체가 없는 경우
            targetCookie = new Cookie(name, "");
            targetCookie.setPath("/");
            targetCookie.setMaxAge(60*60*24);
        }

        return targetCookie;
    }
}
