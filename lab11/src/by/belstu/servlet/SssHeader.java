package by.belstu.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SssHeader extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Integer x = Integer.parseInt(request.getHeader("Value-X"));
            Integer y = Integer.parseInt(request.getHeader("Value-Y"));

            Thread.sleep(10000);

            response.setHeader("Value-Z", Integer.toString(x + y));
        } catch (Exception e) {
            response.getWriter().println(e.getMessage());
        }
    }
}
