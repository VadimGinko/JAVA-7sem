package by.belstu.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Sss extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = getServletContext().getInitParameter("filesPath");
        String fileName = request.getParameter("file");
        System.out.println(path);
        System.out.println("Servlet:Sss");

        if (fileName != null) {
            Log.info("file: " + fileName);
            File file = new File(path + "//" + fileName);
            response.setContentType("application/msword");
            response.addHeader("Content-Disposition", "attachment; filename=" + file.getName());
            response.setContentLength((int) file.length());

            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(file));
            int readBytes;
            while ((readBytes = buf.read()) != -1) {
                response.getOutputStream().write(readBytes);
            }
        }
    }
}
