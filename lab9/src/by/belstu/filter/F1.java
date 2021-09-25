package by.belstu.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class F1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("F1 init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("do Filter1");

        task5((HttpServletRequest) servletRequest);

        String value = servletRequest.getParameter("f1");
        if (value == null) {
            servletResponse.getWriter().println("Ccc blocked on F1");
        } else {
            System.out.printf("do Filter1 good: %s \n", value);
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    private void task5(HttpServletRequest servletRequest){
        servletRequest.getSession().setAttribute("attr", "1");
        servletRequest.getSession().setAttribute("attr", "1");
        servletRequest.getSession().removeAttribute("attr");

    }

    @Override
    public void destroy() {
        System.out.println("F1 destroy");
    }
}
