package org.zerock.tomproject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="myServlet", urlPatterns = "/my")
public class MyServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter(); // 응답을 html로 설정하고, 입력을 받는다.
        out.println("<html><body>");
        out.println("<h1>My Servlet</h1>");
        out.println("</body></html>");
    }
}
