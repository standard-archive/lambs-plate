package com.lambsplate.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PortConfigTest {

    @Test
    void usesDefaultPortWhenVariableIsNotSet() {
        assertEquals(PortConfig.DEFAULT_PORT, PortConfig.fromEnvironment(null));
    }

    @Test
    void usesDefaultPortWhenVariableIsBlank() {
        assertEquals(PortConfig.DEFAULT_PORT, PortConfig.fromEnvironment("   "));
    }

    @Test
    void parsesAValidPort() {
        assertEquals(8080, PortConfig.fromEnvironment("8080"));
    }

    @Test
    void ignoresSurroundingWhitespace() {
        assertEquals(8080, PortConfig.fromEnvironment(" 8080 "));
    }

    @Test
    void rejectsText() {
        assertThrows(IllegalArgumentException.class, () -> PortConfig.fromEnvironment("abc"));
    }

    @Test
    void rejectsZero() {
        assertThrows(IllegalArgumentException.class, () -> PortConfig.fromEnvironment("0"));
    }

    @Test
    void rejectsPortsAboveTheMaximum() {
        assertThrows(IllegalArgumentException.class, () -> PortConfig.fromEnvironment("65536"));
    }
}
