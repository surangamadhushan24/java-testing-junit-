package junit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class AssertJAssertionsDemo {
    private final Calculate  calculator = new Calculate();
    @Test
    void assertWithAssertJ() {
        assertThat(calculator.sum(4, 1)).isEqualTo(5);
    }
}
