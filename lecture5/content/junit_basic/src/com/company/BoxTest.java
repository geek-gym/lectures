package com.company;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BoxTest {

    public BoxTest() {
        System.out.println("BoxTest CONSTRUCTED!!!");
    }

    private int index = 0;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("This is common setup");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("This is common cleanup");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("This is setup");
        this.index = 1;
    }

    @AfterEach
    public void tearDown() {
        System.out.println("This is cleanup");
        this.index = 0;
    }

    @Test
    @Tag("fast")
    @DisabledOnOs(OS.MAC)
    public void calculateVolume() {
        System.out.println("This is test " + this.index);
    }

    @Test
    @Disabled("This is obsolete test")
    @DisplayName("Temp test for example")
    public void tempTest() {
        System.out.println("This is second test");
        assert 1 != 1;
    }
}