public class Main {
    public static void main(String[] args) {
        PaymentProcessor p = new PaymentProcessor(new CryptoPayment());

        p.pay(10);

        p.changePayment(new CreditCardPayment());
        p.pay(20);

        p.changePayment(new PayPalPayment());
        p.pay(30);

    }
}
