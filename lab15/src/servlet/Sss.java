package servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Sss extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        final String to = request.getParameter("mail");
        final String mes = request.getParameter("message");
        final String from = getServletContext().getInitParameter("from");
        final String username = getServletContext().getInitParameter("username");
        final String password = getServletContext().getInitParameter("password");
        final String host = getServletContext().getInitParameter("host");
        final String port = getServletContext().getInitParameter("port");

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            message.setSubject("Subject");

            message.setText(mes);

            Transport.send(message);

            response.getWriter().write("Sent message successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            // mail server connection parameters
            // String host = "pop.mail.ru";
            String host = getServletContext().getInitParameter("hostImaps");
            int port = Integer.parseInt(getServletContext().getInitParameter("portImaps"));
            String user = getServletContext().getInitParameter("username") + "@mail.ru";
            String password = getServletContext().getInitParameter("password");

            Properties properties = System.getProperties();
            Session session = Session.getDefaultInstance(properties);
            Store store = session.getStore("imaps");
            store.connect(host, port, user, password);
            //Store store = session.getStore("pop3");
            //store.connect(host, 995, user, password);
            Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages();

            if (messages.length == 0) System.out.println("No messages found.");

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < messages.length; i++) {
                if (i > 10) {
                    inbox.close(true);
                    store.close();
                    break;
                }

                builder.append("From : ").append(messages[i].getFrom()[0]).append("<br>");
                builder.append("Subject : ").append(messages[i].getSubject()).append("<br>");
                builder.append("Sent Date : ").append(messages[i].getSentDate()).append("<br>");
                response.setContentType("text/html");
            }
            response.getWriter().write(builder.toString());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
