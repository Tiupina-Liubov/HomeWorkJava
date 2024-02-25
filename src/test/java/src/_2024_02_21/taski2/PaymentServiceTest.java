package src._2024_02_21.taski2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {
    //@Mock
    SimpleNotificationService notificationService = mock(SimpleNotificationService.class);

    SimpleTransactionRepository transactionRepository = mock(SimpleTransactionRepository.class);

    PaymentService paymentService = new PaymentService(notificationService, transactionRepository);

    double originalAmount = 100.0;

    double newAmount = 150.0;

    @Test
    void makePaymentPositiveTest() {
        Mockito.when(transactionRepository.processTransaction(Mockito.anyDouble())).thenReturn(true);
        assertTrue(paymentService.makePayment(Mockito.anyDouble()));
        verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }

    @Test
    void makePaymentNegativeTest() {
        Mockito.when(transactionRepository.processTransaction(Mockito.anyDouble())).thenReturn(false);
        assertFalse(paymentService.makePayment(Mockito.anyDouble()));
        verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }

    @Test
    void refundPaymentPositiveTest() {
        Mockito.when(transactionRepository.processTransaction(-Mockito.anyDouble())).thenReturn(true);
        assertTrue(paymentService.refundPayment(Mockito.anyDouble()));
        verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }

    @Test
    void refundPaymentNegativeTest() {
        Mockito.when(transactionRepository.processTransaction(-Mockito.anyDouble())).thenReturn(false);
        assertFalse(paymentService.refundPayment(Mockito.anyDouble()));
        verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }

    @Test
    void adjustPaymentPositiveTest() {
        Mockito.when(transactionRepository.processTransaction(-originalAmount)).thenReturn(true);
        Mockito.when(transactionRepository.processTransaction(newAmount)).thenReturn(true);

        paymentService.adjustPayment(originalAmount, newAmount);

        verify(transactionRepository).processTransaction(-originalAmount);
        verify(transactionRepository).processTransaction(newAmount);
        verify(notificationService, Mockito.times(2)).sendPaymentNotification(Mockito.anyString());
    }

    @Test
    void adjustPaymentPositiveRefundAndNegativePaymentTest() {
        Mockito.when(transactionRepository.processTransaction(-originalAmount)).thenReturn(true);
        Mockito.when(transactionRepository.processTransaction(newAmount)).thenReturn(false);

        paymentService.adjustPayment(originalAmount, newAmount);

        verify(transactionRepository).processTransaction(-originalAmount);
        verify(transactionRepository).processTransaction(newAmount);
        verify(notificationService, Mockito.times(2)).sendPaymentNotification(Mockito.anyString());
    }

    @Test
    void adjustPaymentFailureTest() {
       Mockito.when(transactionRepository.processTransaction(-originalAmount)).thenReturn(false);

        paymentService.adjustPayment(originalAmount, newAmount);

        verify(transactionRepository).processTransaction(-originalAmount);
        verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }

    @Test
    void verifyPaymentTest() {
       paymentService.verifyPayment(Mockito.anyDouble());
        verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }


    @Test
    void cancelPaymentPositiveTest() {
        Mockito.when(transactionRepository.processTransaction(-Mockito.anyDouble())).thenReturn(true);
        paymentService.cancelPayment(Mockito.anyDouble());
        verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }

    @Test
    void cancelPaymentNegativeTest() {
        Mockito.when(transactionRepository.processTransaction(-Mockito.anyDouble())).thenReturn(false);
        paymentService.cancelPayment(Mockito.anyDouble());
        verify(notificationService).sendPaymentNotification(Mockito.anyString());
    }
}