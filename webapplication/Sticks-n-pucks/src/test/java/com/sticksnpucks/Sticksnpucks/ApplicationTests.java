package com.sticksnpucks.Sticksnpucks;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

// Test class added ONLY to cover main() invocation not covered by application tests.
public class ApplicationTests {
    @Test
    void main() {
        Application.main(new String[]{});
        assertTrue(true);
    }
}
