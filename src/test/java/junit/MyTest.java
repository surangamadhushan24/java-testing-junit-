package junit; // Make sure this matches your package structure if applicable

import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.assertEquals;

// Fixed: Added missing import
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class MyTest {

    @Test
    public void exampleTest() { // Changed to public
        boolean condition = "true".equalsIgnoreCase(System.getProperty("runTest"));
        Assumptions.assumeTrue(condition, "Skipping the test because the condition is not met");
        
        int result = someMethod();
        Assertions.assertEquals(42, result, "The result should be 42");
    }

    private int someMethod() {
        return 42;
    }
}