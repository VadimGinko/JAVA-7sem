package by.belstu.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class L1 implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
        System.out.println(
                "----------------------------------- " +
                        "context initialized " +
                        "-----------------------------------");
    }

    public void contextDestroyed(ServletContextEvent event) {
        System.out.println(
                "----------------------------------- " +
                        "context destroyed " +
                        "-----------------------------------");
    }
}