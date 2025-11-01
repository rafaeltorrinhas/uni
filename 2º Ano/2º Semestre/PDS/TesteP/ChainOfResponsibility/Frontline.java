public class Frontline extends HelpDesk {
  public HelpDesk h;
  public Severity sev = Severity.basic;

  public Frontline(HelpDesk h) {
      this.h = h;
  }


  public void handle(Ticket ticket) {
    if (ticket.getSeverity() != sev) {
      h.handle(ticket);
    } else {
      System.out.println("Ticket handled by Frontline");
    }
  }

}
