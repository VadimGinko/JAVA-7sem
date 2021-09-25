package by.belstu.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

public class F3 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("F3 init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("do Filter3");

        String value = servletRequest.getParameter("f3");
        if (value == null) {
            servletResponse.getWriter().println("Ccc blocked on F3");
        } else {
            System.out.printf("do Filter3 good: %s \n", value);
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("F3 destroy");
    }
}
