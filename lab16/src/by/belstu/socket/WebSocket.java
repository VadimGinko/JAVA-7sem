package by.belstu.socket;

import jakarta.websocket.Endpoint;
import jakarta.websocket.EndpointConfig;
import jakarta.websocket.RemoteEndpoint;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//аннотации заявляет, что класс является веб-сокет, который будет развернут и доступен в URI пространства сервера веб-сокетов;
@ServerEndpoint("/websock")
public class WebSocket extends Endpoint { //Класс Endpoint держит методы жизненного цикла , которые могут быть переопределены , чтобы перехватить WebSocket

    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        RemoteEndpoint.Basic remoteEndpointBasic = session.getBasicRemote(); // для синхронной отправки
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
        try {
            while (true) {
                Thread.sleep(2000);
                remoteEndpointBasic.sendText(format.format(new Date()));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}