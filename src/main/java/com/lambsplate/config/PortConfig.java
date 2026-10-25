package com.lambsplate.config;

/**
 * Decides which port the server listens on.
 */
public final class PortConfig {

    /** Port used when the PORT environment variable is not set. */
    public static final int DEFAULT_PORT = 7070;

    private static final int MIN_PORT = 1;
    private static final int MAX_PORT = 65535;

    private PortConfig() {
    }

    /**
     * Turns the value of the PORT environment variable into a port number.
     *
     * @param value the raw value, or null when the variable is not set
     * @return the default port when the value is null or blank, otherwise the parsed port
     * @throws IllegalArgumentException if the value is not a whole number between 1 and 65535
     */
    public static int fromEnvironment(String value) {
        if (value == null || value.isBlank()) {
            return DEFAULT_PORT;
        }
        int port;
        try {
            port = Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw invalid(value, e);
        }
        if (port < MIN_PORT || port > MAX_PORT) {
            throw invalid(value, null);
        }
        return port;
    }

    private static IllegalArgumentException invalid(String value, Throwable cause) {
        return new IllegalArgumentException(
                "PORT must be a whole number between " + MIN_PORT + " and " + MAX_PORT + " but was: " + value,
                cause);
    }
}
