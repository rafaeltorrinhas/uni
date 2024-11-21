package aula6;

public class Pessoa {
  private String nome;
  private int cc;
  private DateYMD dataNasc;

  public String getNome() {
    return nome;
  }

  public int getCc() {
    return cc;
  }

  public DateYMD getDataNasc() {
    return dataNasc;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCc(int cc) {
    this.cc = cc;
  }

  public void setDataNasc(DateYMD dataNasc) {
    this.dataNasc = dataNasc;
  }

  @Override
  public String toString() {
    return "nome=" + nome + ", cc=" + cc + ", dataNasc=" + dataNasc;
  }

  public Pessoa(String nome, int cc, DateYMD dataNasc) {
    this.nome = nome;
    this.cc = cc;
    this.dataNasc = dataNasc;
  }
}
