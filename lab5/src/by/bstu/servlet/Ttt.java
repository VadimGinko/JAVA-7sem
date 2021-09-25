package by.bstu.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Ttt extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter printWriter = res.getWriter();
        printWriter.println(
                "<br/>surname: " + req.getParameter("surname") +
                        "<br/>lastname: " + req.getParameter("lastname") +
                        "<br/>sex: " + req.getParameter("sex")
        );
    }
}
