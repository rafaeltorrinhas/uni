package testefinal3;

public class Client {
  public String nome;
  public String localidade;

  public String getLocalidade() {
    return localidade;
  }

  public String getNome() {
    return nome;
  }

  public void setLocalidade(String localidade) {
    this.localidade = localidade;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Client(String nome, String localidade) {
    this.nome = nome;
    this.localidade = localidade;
  }

  @Override
  public String toString() {
    return nome + " [" + localidade + "]";
  }

}
