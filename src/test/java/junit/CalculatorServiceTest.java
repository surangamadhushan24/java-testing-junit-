package junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

    @Mock
    private DataService dataService;
    @InjectMocks
    private CalculatorService calculatorService;

    @Test
    void testAddAllNumbers_PositiveScenario(){
        when(dataService.fetchNumbers()).thenReturn(new int[]{1,2,3});
        int actualResult = calculatorService.addAllNumbers();
        assertEquals(6, actualResult);

    }
}
