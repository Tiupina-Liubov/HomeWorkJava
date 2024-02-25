package src._2024_02_21.taski2;

//todo
public class PaymentService {
    private final SimpleNotificationService notificationService;
    private final SimpleTransactionRepository transactionRepository;

    public PaymentService(SimpleNotificationService notificationService, SimpleTransactionRepository transactionRepository) {
        this.notificationService = notificationService;
        this.transactionRepository = transactionRepository;
    }

    public boolean makePayment(double amount) {
        boolean result = transactionRepository.processTransaction(amount);
        if (result) {
            notificationService.sendPaymentNotification("Payment successful for amount: " + amount);
        } else {
            notificationService.sendPaymentNotification("Payment failed for amount: " + amount);
        }
        return result;
    }

    public boolean refundPayment(double amount) {
        boolean result = transactionRepository.processTransaction(-amount);
        if (result) {
            notificationService.sendPaymentNotification("Refund successful for amount: " + amount);
        } else {
            notificationService.sendPaymentNotification("Refund failed for amount: " + amount);
        }
        return result;
    }

    public void adjustPayment(double originalAmount, double newAmount) {
        boolean refundResult = transactionRepository.processTransaction(-originalAmount);
        if (refundResult) {
            notificationService.sendPaymentNotification("Adjustment refund successful for amount: " + originalAmount);
            boolean paymentResult = transactionRepository.processTransaction(newAmount);
            if (paymentResult) {
                notificationService.sendPaymentNotification("Adjustment payment successful for amount: " + newAmount);
            } else {
                notificationService.sendPaymentNotification("Adjustment payment failed for amount: " + newAmount);
            }
        } else {
            notificationService.sendPaymentNotification("Adjustment refund failed for amount: " + originalAmount);
        }
    }

    public void verifyPayment(double amount) {
        notificationService.sendPaymentNotification("Payment verified for amount: " + amount);
    }

    public void cancelPayment(double amount) {
        boolean refundResult = transactionRepository.processTransaction(-amount);
        if (refundResult) {
            notificationService.sendPaymentNotification("Payment cancellation successful for amount: " + amount);
        } else {
            notificationService.sendPaymentNotification("Payment cancellation failed for amount: " + amount);
        }
    }
}
