package by.belstu.servlet;

import by.belstu.CBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// http://localhost:8080/Lab7/cccrequest?cBean=old&value1=v1&value2=v2&value3=v3
public class CccRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response(request, response);
    }

    protected void response(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value1 = request.getParameter("value1");
        String value2 = request.getParameter("value2");
        String value3 = request.getParameter("value3");
        String cBeanName = request.getParameter("cBean");

        if (cBeanName == null) {
            writeErrorMessage(response, "add cBean parameter");
            return;
        } else {
            CBean cBean;
            if (cBeanName.equals("new")) {
                cBean = new CBean();

                cBean = this.setValues(cBean, value1, value2, value3);
                request.setAttribute("atrCBean", cBean);
            } else if (cBeanName.equals("old")) {
                cBean = (CBean) request.getAttribute("atrCBean");
                if (cBean == null) {
                    writeErrorMessage(response, "create new CBean");
                    return;
                }
                cBean = this.setValues(cBean, value1, value2, value3);
                request.setAttribute("atrCBean", cBean);
            } else {
                writeErrorMessage(response, "wrong cBean parameter");
                return;
            }
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/CccRequest.jsp");
        requestDispatcher.forward(request, response);
    }

    private CBean setValues(CBean cBean, String value1, String value2, String value3) {
        if (value1 != null) {
            cBean.setValue1(value1);
        }
        if (value2 != null) {
            cBean.setValue2(value2);
        }
        if (value3 != null) {
            cBean.setValue3(value3);
        }
        return cBean;
    }

    private void writeErrorMessage(HttpServletResponse response, String message) throws IOException {
        response.getWriter().write(message);
    }
}

