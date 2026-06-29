package junit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class AssertJAssertionsDemo {
    private final Calculate  calculator = new Calculate();
    private final Person person1 = new Person("suranga","madhushan");
    private final Person person2 = new Person("suranga","madhushan");
    @Test
    void assertWithAssertJ() {
        assertThat(calculator.sum(4, 1)).isEqualTo(5);
    }
    @Test
    void compareObject(){
        assertThat(person1).isEqualTo(person2);
    }

    @Test
    void compareObjectFields(){
        assertThat(person1)
                .usingRecursiveComparison()
                .isEqualTo(person2);
    }
    @Test
    void booleanAssertion(){
        assertThat("".isEmpty()).isTrue();
    }
}
