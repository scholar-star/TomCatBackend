package org.zerock.tomproject.calc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="inputController", urlPatterns = "/calc/input") // /calc/input url에 대한 것
public class InputController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        System.out.println("InputController...doGet...");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/calc/input.jsp");
        // 서블릿에 전달된 요청을 다른 쪽으로 전달/배포
        // WEB-INF 밑에 jsp 파일 - 브라우저에서 jsp로 직접 호출 불가(브라우저가 직접 접근 불가)
        dispatcher.forward(req, resp);
    }
}
