package org.zerock.tomproject2.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
@Log4j2
public class LogoutController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        log.info("logout.....");
        HttpSession session = req.getSession();
        session.removeAttribute("loginInfo"); // session 공간의 로그인 정보를 지운다
        session.invalidate(); // session 무효화

        resp.sendRedirect("/login"); // login 화면(filter)
    }
}
