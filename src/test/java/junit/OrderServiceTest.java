package junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private PaymentGateway paymentGateway; // Instantiates a fake placeholder

    @Mock
    private InventoryRepository inventoryRepository; // Instantiates a fake placeholder

    @InjectMocks
    private OrderService orderService; // Automatically injects the mocks above into this constructor

    @Test
    void testPlaceOrder_Success() {
        // --- 1. ARRANGE (Stubbing behavior) ---
        when(inventoryRepository.checkStock("PROD-01", 2)).thenReturn(true);
        when(paymentGateway.processPayment("ORD-100", 250.0)).thenReturn(true);

        // Stubbing using generic argument matchers
//        when(inventoryRepository.checkStock(anyString(), anyInt())).thenReturn(true);
//        when(paymentGateway.processPayment(eq("ORD-100"), anyDouble())).thenReturn(true);

        // --- 2. ACT ---
        boolean result = orderService.placeOrder("ORD-100", "PROD-01", 2, 250.0);

        // --- 3. ASSERT ---
        assertTrue(result);
    }
    @Test
    void testPlaceOrder_VerifiesInteractions() {
        when(inventoryRepository.checkStock(anyString(), anyInt())).thenReturn(true);
        when(paymentGateway.processPayment(anyString(), anyDouble())).thenReturn(true);

        doThrow(new RuntimeException("Database offline"))
                .when(inventoryRepository).deductStock(anyString(), anyInt());

        orderService.placeOrder("ORD-100", "PROD-01", 2, 250.0);

        // Verify deductStock was called exactly 1 time with these parameters
        verify(inventoryRepository, times(1)).deductStock("PROD-01", 2);

        // Verify that a specific method was never executed
        verify(inventoryRepository, never()).checkStock("INVALID-ID", 0);
    }
}