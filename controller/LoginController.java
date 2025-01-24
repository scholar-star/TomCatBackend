package org.zerock.tomproject2.controller;

import lombok.extern.java.Log;
import org.zerock.tomproject2.todo.dto.MemberDTO;
import org.zerock.tomproject2.todo.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.UUID;

@WebServlet("/login")
@Log
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        log.info("login get....");
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        log.info("login post....");

        String mid = req.getParameter("mid");
        String pwd = req.getParameter("mpw");

        String auto = req.getParameter("auto");

        boolean rememberMe = auto!=null && auto.equals("on"); // checkbox : onoff
//        String str = mid+pwd;
//
//        HttpSession session = req.getSession();
//        // 세션 공간을 받음
//        session.setAttribute("loginInfo", str);
//        // loginInfo : str로 세션 공간에 저장
//        resp.sendRedirect("/todo/list");

        try { // 세션을 저장하고 todo 본문으로 이동
            MemberDTO memberDTO = MemberService.INSTANCE.login(mid, pwd);
            // 둘 중 하나가 일치하지 못하면 값을 가지고 나오지 못한다.
            // dto 객체 생성
            if(rememberMe){
                String uuid = UUID.randomUUID().toString();

                MemberService.INSTANCE.updateUuid(mid, uuid);
                memberDTO.setUuid(uuid);

                Cookie rememberCookie =
                        new Cookie("remember-me", uuid);
                rememberCookie.setMaxAge(60*60*24*7);
                rememberCookie.setPath("/");

                resp.addCookie(rememberCookie);
            }

            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", memberDTO);
            resp.sendRedirect("/todo/list");

        } catch (Exception e) { // 예외 발생 시
            resp.sendRedirect("/login?result=error");
        }
    }
}
