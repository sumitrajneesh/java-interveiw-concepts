package creational.factory.payment;

public class PaymentDemo {
    public static void main(String[] args) {
        PaymentFactory factory = new PaymentFactory();
        PaymentService paymentService = factory.getPaymentService("UPI");
        paymentService.processPayment(200);

    }
}
