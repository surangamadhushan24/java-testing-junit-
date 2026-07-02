package junit;

// Dependencies
interface PaymentGateway {
    boolean processPayment(String orderId, double amount);
}

 interface InventoryRepository {
    boolean checkStock(String productId, int quantity);
    void deductStock(String productId, int quantity);
}

// System Under Test (SUT)
public class OrderService {
    private final PaymentGateway paymentGateway;
    private final InventoryRepository inventoryRepository;

    public OrderService(PaymentGateway paymentGateway, InventoryRepository inventoryRepository) {
        this.paymentGateway = paymentGateway;
        this.inventoryRepository = inventoryRepository;
    }


    public boolean placeOrder(String orderId, String productId, int quantity, double amount) {
        if (!inventoryRepository.checkStock(productId, quantity)) {
            return false;
        }

        boolean paymentSuccess = paymentGateway.processPayment(orderId, amount);
        if (paymentSuccess) {
            inventoryRepository.deductStock(productId, quantity);
            return true;
        }
        return false;
    }
}
