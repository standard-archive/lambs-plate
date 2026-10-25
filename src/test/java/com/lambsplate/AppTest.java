package com.lambsplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.javalin.Javalin;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {

    private final HttpClient client = HttpClient.newHttpClient();
    private Javalin app;

    @BeforeEach
    void startApp() {
        // Port 0 asks the operating system for any free port, so tests never clash.
        app = App.create().start(0);
    }

    @AfterEach
    void stopApp() {
        app.stop();
    }

    private HttpResponse<String> get(String path) throws Exception {
        HttpRequest request = HttpRequest
                .newBuilder(URI.create("http://127.0.0.1:" + app.port() + path))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    @Test
    void healthEndpointReturnsOk() throws Exception {
        HttpResponse<String> response = get("/health");

        assertEquals(200, response.statusCode());
        assertEquals("ok", response.body());
    }

    @Test
    void unknownPathReturnsNotFound() throws Exception {
        assertEquals(404, get("/does-not-exist").statusCode());
    }
}
