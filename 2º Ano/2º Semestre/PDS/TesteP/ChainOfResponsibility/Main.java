public class Main {
    public static void main(String[] args) {
        Ticket t1 = new Ticket(0, Severity.basic);
        Ticket t2 = new Ticket(1, Severity.intermediate);
        Ticket t3 = new Ticket(2, Severity.advanced);

        HelpDesk h = new Frontline();

        h.handle(t1);
        h.handle(t2);
        h.handle(t3);

    }
}
