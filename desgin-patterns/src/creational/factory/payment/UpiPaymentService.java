package creational.factory.payment;

public class UpiPaymentService implements PaymentService{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment of ₹" + amount);
    }
}
