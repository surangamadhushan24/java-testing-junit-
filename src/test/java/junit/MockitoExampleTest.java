package demo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class MockitoExampleTest {

    @Test
    void testMockList() {

        // Create a fake List
        List<String> mockedList = mock(List.class);

        // Call methods
        mockedList.add("one");
        mockedList.clear();

        // Verify method calls
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }
}