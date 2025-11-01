public class TechSupport extends HelpDesk {
  public HelpDesk h = new Supervisor();
  public Severity sev = Severity.intermediate;

  public void handle(Ticket ticket) {
    if (ticket.getSeverity() != sev) {
      h.handle(ticket);
    } else {
      System.out.println("Ticket handled by TechSupport");
    }
  }

}
