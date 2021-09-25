package by.belstu.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Random;

public class SssJSON extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Random random = new Random();
            int n = Integer.parseInt(request.getHeader("XRand-N"));
            StringBuilder textResult = new StringBuilder();
            int count = new Random().nextInt(10 - 5 + 1) + 5;

            textResult.append("[");
            for (int i = 0; i < count; i++) {
                Integer number = random.nextInt(2 * n + 1) - n;
                textResult.append(number).append(i < count - 1 ? "," : "");
            }
            textResult.append("]");

            Thread.sleep(1000);

            response.setContentType("application/json");
            response.getWriter().println(textResult);
        } catch (Exception e) {
            response.getWriter().println(e.getMessage());
        }
    }
}
