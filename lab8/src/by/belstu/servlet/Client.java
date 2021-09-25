package by.belstu.servlet;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {
    private static HttpResponse<String> post(
            String path,
            String param1,
            String param2,
            String param3,
            String header1,
            String header2,
            String header3) {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create(String.format("%s?param1=%s&param2=%s&param3=%s", path, param1, param2, param3));
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(""))
                .setHeader("header1", header1)
                .setHeader("header2", header2)
                .setHeader("header3", header3)
                .build();
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException | IOException e) {
            return null;
        }
    }

    public static String task1Post(
            String path,
            String param1,
            String param2,
            String param3,
            String header1,
            String header2,
            String header3) {
        HttpResponse<String> response = post(
                path,
                param1,
                param2,
                param3,
                header1,
                header2,
                header3);
        var headers = response.headers().map();
        return "response body:" + response.body()
                + "</br>"
                + "header from Bbb 1" + headers.get("header_from_Bbb_1")
                + "header from Bbb 1" + headers.get("header_from_Bbb_2");
    }
}
