package com.lambsplate;

import com.lambsplate.config.PortConfig;
import io.javalin.Javalin;

/**
 * Entry point of Lamb's Plate.
 */
public final class App {

    private App() {
    }

    /**
     * Builds the application with all routes registered, without starting it.
     * Tests use this to start the app on a free port.
     *
     * @return the configured Javalin instance
     */
    public static Javalin create() {
        Javalin app = Javalin.create();
        app.get("/health", ctx -> ctx.result("ok"));
        return app;
    }

    public static void main(String[] args) {
        int port = PortConfig.fromEnvironment(System.getenv("PORT"));
        create().start(port);
    }
}
