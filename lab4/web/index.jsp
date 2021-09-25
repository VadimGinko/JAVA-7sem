<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.stream.IntStream" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="com.sun.jdi.connect.Connector" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Lab4</title>
</head>
<body>
<div>
    <%
        int hour = LocalDateTime.now().getHour();
        String pageName;
        if (hour < 12) {
            out.println("Good morning");
            pageName = "morning.jsp";
        } else if (hour < 17) {
            out.println("Good afternoon");
            pageName = "afternoon.jsp";
        } else if (hour < 22) {
            out.println("Good evening");
            pageName = "evening.jsp";
        } else {
            out.println("Good night");
            pageName = "night.jsp";
        }

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        out.println("<table>");
        for (int i = 0; i < 7; i++) {
            int dayOfWeek = localDate.getDayOfWeek().ordinal() + 1;
            out.println(
                    "<tr>" +
                            "<td>" + localDate.format(formatter) + "</td>" +
                            "<td>" + dayOfWeek + "</td>" +
                    "</tr>");
            localDate = localDate.plusDays(1);
        }
        out.println("</table>");
    %>

    <%if (pageName.equals("night.jsp")) {%>
    <%@ include file="night.jsp" %>
    <% } %>

    <%if (pageName.equals("morning.jsp")) {%>
    <%@ include file="morning.jsp" %>
    <% } %>

    <%if (pageName.equals("afternoon.jsp")) {%>
    <%@ include file="afternoon.jsp" %>
    <% } %>

    <%if (pageName.equals("evening.jsp")) {%>
    <%@ include file="evening.jsp" %>
    <% } %>

    <form action="<%= pageName %>" method="get">
        <button type="submit">Press</button>
    </form>

    <%--    https://coderoad.ru/14580120/В-чем-разница-между-включением-файлов-с-директивой-JSP-include-действием-JSP--%>
    <jsp:include page="<%= pageName %>"/>

    <jsp:include page="/Afternoon"/>

<%--    <jsp:forward page="<%= pageName %>"/>--%>

    <form action="Jjj" method="post">
        <button type="submit">Post Jjj</button>
    </form>
</div>
</body>
</html>