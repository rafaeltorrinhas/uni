package testefinal2;

import java.util.Objects;

public class Reserva {

  PacoteTuristico pacote;
  int numPessoas;
  double precoTotal;

  public Reserva(PacoteTuristico pacote, int numPessoas) {
    this.pacote = pacote;
    this.numPessoas = numPessoas;

    if (numPessoas > 0 && numPessoas < 4) {
      this.precoTotal = pacote.precoTotal(numPessoas);
    } else {
      this.precoTotal = pacote.precoTotal(numPessoas) - pacote.precoTotal(numPessoas) * .07;
    }
  }

  public PacoteTuristico getPacote() {
    return this.pacote;
  }

  public void setPacote(PacoteTuristico pacote) {
    this.pacote = pacote;
  }

  public int getNumPessoas() {
    return this.numPessoas;
  }

  public void setNumPessoas(int numPessoas) {
    this.numPessoas = numPessoas;
  }

  public Reserva pacote(PacoteTuristico pacote) {
    setPacote(pacote);
    return this;
  }

  public Reserva numPessoas(int numPessoas) {
    setNumPessoas(numPessoas);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Reserva)) {
      return false;
    }
    Reserva reserva = (Reserva) o;
    return Objects.equals(pacote, reserva.pacote) && numPessoas == reserva.numPessoas;
  }

  @Override
  public int hashCode() {
    return Objects.hash(pacote, numPessoas);
  }

  @Override
  public String toString() {
    return "" + pacote;
  }

}
