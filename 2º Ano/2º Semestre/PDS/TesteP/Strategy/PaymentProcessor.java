public class PaymentProcessor {
    PaymentStrategy p;

    public PaymentProcessor(PaymentStrategy p) {
        this.p = p;
    }

    public void changePayment(PaymentStrategy p) {
        this.p = p;
    }

    public void pay(double amount) {
        this.p.pay(amount);
    }
}
