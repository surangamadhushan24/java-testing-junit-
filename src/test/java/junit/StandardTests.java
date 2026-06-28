package junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class StandardTests {

    @BeforeAll
    static void initAll() {
        System.out.println("before all");
    }
    @BeforeEach
    void init() {
        System.out.println("before each");

    }
    @Test
    void succeedingTest() {
        System.out.println("succeed");

    }
    @Test
    void failingTest() {
        fail("a failing test");
    }
    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        System.out.println("disable");

    }
    @Test
    void abortedTest() {
        assumeTrue("abc".contains("Z"));
        fail("test should have been aborted");
    }
    @AfterEach
    void tearDown() {
    }
    @AfterAll
    static void tearDownAll() {
    }
}
