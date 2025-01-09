package org.zerock.tomproject.calc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "sampleServlet", urlPatterns = "/sample")
public class SampleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        System.out.println("doGet..."+this);
        // urlPattern을 시작 후 호출할 때 작동
    }

    @Override
    public void destroy() { // tomcat terminate
        System.out.println("destroy...");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init(ServletConfig)...");
        // urlPattern에 맞는 Servlet 시작 시 작동
    }
}
