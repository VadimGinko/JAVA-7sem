import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Sss extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Sss Get");

        // Task1
//         RequestDispatcher rd = req.getRequestDispatcher("/GGG");
//         rd.forward(req, resp);
        // end Task1

        // Task3
        // RequestDispatcher rd6 = req.getRequestDispatcher("/page.html");
        // rd6.forward(req, resp);
        // end Task3

        // Task4
        // RequestDispatcher rd7 = req.getRequestDispatcher("/GGG");
        // rd7.forward(req, resp);
        // end Task4

        // Task5
//         RequestDispatcher rd = req.getRequestDispatcher("/GGG");
//         resp.getWriter().write("output Task5 from Sss");
//         rd.forward(req, resp);
        // end Task5

        // Task6
        resp.sendRedirect("http://localhost:8080/Lab3/GGG");
        // end Task6

        //Task7
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("http://localhost:8080/Lab3/GGG?param=task7"))
//                .build();
//        try {
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            resp.getWriter().write("response Task 7:" + response.body());
//        } catch (InterruptedException e) {
//            resp.getWriter().write("Task 7: Bad Request");
//        }
        // end Task7
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("Sss " + req.getMethod());
//        // Task2
//        RequestDispatcher rd = req.getRequestDispatcher("/GGG");
//        rd.forward(req, resp);
//        // end Task2
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("POST Sss");
        // RequestDispatcher dispatcher = request.getRequestDispatcher("/GGG");
        // dispatcher.forward(request, response);

        //редирект только get
        //response.sendRedirect("http://localhost:8080/Lab3/GGG");
    }
}
