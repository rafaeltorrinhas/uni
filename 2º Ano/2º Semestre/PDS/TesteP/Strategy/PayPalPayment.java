public class PayPalPayment implements PaymentStrategy {

    public void pay(double amount) {

        System.out.println("Paid " + amount + " through paypal.");
    }
}
