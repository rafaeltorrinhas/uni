public class Ticket {
  public int id;
  public Severity sev;

  public Ticket(int id, Severity sev) {
    this.id = id;
    this.sev = sev;
  }

  public Severity getSeverity() {
    return this.sev;
  }

}
