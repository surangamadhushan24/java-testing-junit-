package junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public record MyFirstJUnitJupiterRecordTests() {
    @Test
    void addition(){
        assertEquals(2,new Calculate().sum(1,1));
    }
}
