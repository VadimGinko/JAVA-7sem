package by.belstu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbServlet extends HttpServlet {
    private static Connection connection;
    private final String SELECT_ALL = "SELECT * FROM table_name";
    private final String SELECT_WHERE = "SELECT * FROM table_name WHERE value1 = ?";

    @Override
    public void init() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db",
                    "postgres", "root");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // All
        try {
            PrintWriter pw = response.getWriter();

            try (PreparedStatement stmt = connection.prepareStatement(SELECT_ALL);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    pw.println(rs.getString("value1") + ": " + rs.getString("value2"));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // All End

        // Where
//        try {
//            String param = request.getParameter("param");
//            if (param == null) {
//                throw new Exception("add QueryParam with name param");
//            }
//
//            PrintWriter pw = response.getWriter();
//
//            try (PreparedStatement stmt = connection.prepareStatement(SELECT_WHERE)) {
//                stmt.setString(1, param);
//                try (ResultSet rs = stmt.executeQuery()) {
//                    while (rs.next()) {
//                        pw.println(rs.getString("value1") + ": " + rs.getString("value2"));
//                    }
//                }
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        // Where End
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try (CallableStatement callableStatement = connection.prepareCall("call insert_data(?, ?)")) {
            String param1 = request.getParameter("param1");
            String param2 = request.getParameter("param2");
            if (param1 == null || param2 == null) {
                throw new Exception("add QueryParam with name param");
            }

            callableStatement.setString(1, param1);
            callableStatement.setString(2, param2);

            callableStatement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            PrintWriter pw = response.getWriter();

            try (PreparedStatement stmt = connection.prepareStatement("select get_students()");
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    pw.println(rs.getObject(1));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}