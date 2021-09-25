package by.belstu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Bbb extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter pw = resp.getWriter();

        pw.println("Headers from Servlet Aaa: ");
        pw.println("header1: " + req.getHeader("header1"));
        pw.println("header2: " + req.getHeader("header2"));
        pw.println("header3: " + req.getHeader("header3"));
        pw.println("Params from Aaa:");
        pw.println("param1: " + req.getParameter("param1"));
        pw.println("param2: " + req.getParameter("param2"));
        pw.println("param3: " + req.getParameter("param3"));
        pw.println("</br>");

        pw.println("all headers(task 2-1)");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = req.getHeader(key);
            pw.println(key + ": " + value);
        }
        resp.setHeader("header1", req.getHeader("header1"));
        resp.setHeader("header2", req.getHeader("header2"));
        resp.setHeader("header3", req.getHeader("header3"));
        resp.setHeader("header_from_Bbb_1", "1");
        resp.setHeader("header_from_Bbb_2", "2");
    }
}
