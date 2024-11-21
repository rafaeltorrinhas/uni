package testefinal2;

import java.time.LocalDate;

public abstract class Servico {
  protected static int count = 1000;
  protected String id;
  protected String name;

  public Servico() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}

class Voo extends Servico {
  String nome;
  LocalDate data;
  Classe vclass;

  public Voo(String nome, LocalDate data, Classe vclass) {
    this.nome = nome;
    this.data = data;
    this.vclass = vclass;
    this.id = "V" + String.valueOf(count++);

  }

  @Override
  public String toString() {
    return "[" + id + "] " + "Voo " + nome + ", em " + data + ", classe " + vclass + "\n";
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

}

class Alojamento extends Servico {
  public String nome;
  public int nquartos;
  public int ocupacao;
  Regime regime;

  public Alojamento(String nome, int nquartos, int ocupacao, Regime regime) {
    this.nome = nome;
    this.nquartos = nquartos;
    this.ocupacao = ocupacao;
    this.regime = regime;
    this.id = "A" + String.valueOf(count++);
  }

  @Override
  public String toString() {
    return "[" + id + "] " + "Alojamento " + nome + " com " + nquartos + " quartos, ocupação máxima " + ocupacao
        + " pessoas, em regime de " + regime + "\n";
  }

}

class Transporte extends Servico {
  public int ocupantes;
  public int maxkm;
  Combustivel combustivel;

  public Transporte(int ocupantes, int maxkm, Combustivel combustivel) {
    this.ocupantes = ocupantes;
    this.maxkm = maxkm;
    this.combustivel = combustivel;
    this.id = "T" + String.valueOf(count++);
  }

  @Override
  public String toString() {
    return "[" + id + "] " + "Transporte para " + ocupantes + " ocupantes, " + combustivel + ", Kms máximos: "
        + maxkm + "\n";
  }

}

class RoteiroCultural extends Servico {
  String nome;
  int nlocais;

  public RoteiroCultural(String nome, int nlocais) {
    this.nome = nome;
    this.nlocais = nlocais;
    this.id = "R" + String.valueOf(count++);
  }

}

enum Classe {
  TURISTICA,
  EXECUTIVA,
  PRIMEIRA
}

enum Regime {
  PEQUENOALMOCO,
  MEIAPENSAO,
  PENSAOCOMPLETA,
  TUDOINCLUIDO
}

enum Combustivel {
  GASOLINA,
  GASOLEO,
  HIBRIDO,
  ELETRICO
}
