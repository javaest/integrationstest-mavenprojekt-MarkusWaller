package com.est.ftiti;

import org.testng.annotations.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class OrderServiceIntegrationTest {

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private OrderService orderService;

    @Test
    void testFailedPayment() {
        Mockito.when(paymentService.processPayment(Mockito.anyDouble())).thenReturn(false);

        // Rufe die placeOrder Methode auf
        Order order = new Order(10.0); // Erstelle ein Bestellobjekt
        boolean result = orderService.placeOrder(order);

        // Überprüfe, ob die Bestellung fehlgeschlagen ist
        assertFalse(result);
    }
}