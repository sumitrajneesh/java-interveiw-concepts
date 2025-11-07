package creational.factory.payment;


public class PaymentFactory {

    public PaymentService getPaymentService(String paymentType) {
        if( paymentType == null || paymentType.isEmpty())
            return null;

        switch (paymentType) {
            case "CREDIT" :
                return new CreditCardPayment();
            case "UPI":
                return new UpiPaymentService();
            case "PAYPAL":
                return new PaypalPaymentService();
            default:
                throw new IllegalArgumentException("Unknown PaymentType: " + paymentType);
        }

    }
}
