package org.zerock.tomproject.calc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="calcController", urlPatterns = "/calc/makeResult")
public class CalcController extends HttpServlet {
    @Override // post
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        // getParameter -> String 반환
        
        System.out.printf("num1: %s, num2: %s\n", num1, num2);

        resp.sendRedirect("/index");
        // 처리가 끝난 후 Redirect
    }
}
