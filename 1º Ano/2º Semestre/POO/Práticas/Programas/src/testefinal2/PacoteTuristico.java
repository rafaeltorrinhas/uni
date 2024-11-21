package testefinal2;

import java.util.*;
import java.util.stream.Collectors;

public class PacoteTuristico implements IPacoteTuristico {
  public String nome;
  public int noites;
  public double preco;
  public ArrayList<Servico> servicos = new ArrayList<>();

  public PacoteTuristico(String nome, int noites, double preco) {
    this.nome = nome;
    this.noites = noites;
    this.preco = preco;
  }

  public String getNome() {
    return nome;
  }

  public double getPreco() {
    return preco;
  }

  @Override
  public String toString() {
    return "Pacote Turístico " + nome + ": " + noites + " noites, " + preco + "€ / pessoa / noite\n"
        + servicos.stream().map(Object::toString).collect(Collectors.joining("")) + "\n";
  }

  public PacoteTuristico adicionaServico(Servico servico) {

    servicos.add(servico);
    return this;
  };

  @Override
  public Collection<String> listaServicos() {

    return servicos.stream()
        .map(s -> s.getId())
        .collect(Collectors.toList());
  }

  @Override
  public int precoTotal(int numPessoas) {
    double precototal = preco * numPessoas;
    return (int) precototal;
  }
}
