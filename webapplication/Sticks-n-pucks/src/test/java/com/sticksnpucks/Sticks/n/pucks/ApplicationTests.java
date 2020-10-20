package com.sticksnpucks.Sticks.n.pucks;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

// Test class added ONLY to cover main() invocation not covered by application tests.
public class ApplicationTests {
    @Test
    protected void main() {
        Application.main(new String[]{});
        assertTrue(true);
    }
}
