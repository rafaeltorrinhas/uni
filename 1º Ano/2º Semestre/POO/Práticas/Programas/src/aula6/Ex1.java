package aula6;

public class Ex1 {

  public static void main(String[] args) {
    Aluno al = new Aluno("Andreia Melo", 9855678,
        new DateYMD(18, 7, 1990), new DateYMD(1, 9, 2018));
    Professor p1 = new Professor("Jorge Almeida", 3467225, new DateYMD(1967, 3, 13),
        "Associado", "Informática");
    Bolseiro bls = new Bolseiro("Igor Santos", 8976543, new DateYMD(1985, 5, 13), p1, 900, new DateYMD(2024, 03, 22));
    bls.setBolsa(1050);

    System.out.println("Aluno: " + al.getName());
    System.out.println(al);

    System.out.println("Bolseiro: " + bls.getName() + ", NMec: "
        + bls.getNmec() + ", Bolsa: " + bls.getBolsa() + ", Orientador: " +
        bls.getOrientador());
    System.out.println(bls);
  }
}

class Pessoa {
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

class Aluno extends Pessoa {
  private int nmec = 100;
  public DateYMD dataInsc;

  public Aluno(String nome, int cc, DateYMD dataNasc, DateYMD dataInsc) {
    super(nome, cc, dataNasc);
    this.nmec = nmec + 1;
    this.dataInsc = dataInsc;
  }

  public String getName() {
    return super.getNome();
  }

  public int getNmec() {
    return nmec;
  }

  public DateYMD getDataInsc() {
    return dataInsc;
  }

  public void setDataInsc(DateYMD dataInsc) {
    this.dataInsc = dataInsc;
  }

  @Override
  public String toString() {
    return "Aluno [nmec=" + nmec + ", dataInsc=" + dataInsc + "]";
  }

}

class Professor extends Pessoa {
  private String dep;
  private String cat;

  public Professor(String nome, int cc, DateYMD dataNasc, String dep, String cat) {
    super(nome, cc, dataNasc);
    if (cat == "Auxiliar" || cat == "Associado" || cat == "Catedrático") {
      this.dep = dep;
      this.cat = cat;
    }
  }

  public String getDep() {
    return dep;
  }

  public String getCat() {
    return cat;
  }

  public void setDep(String dep) {
    this.dep = dep;
  }

  public void setCat(String cat) {
    this.cat = cat;
  }

}

class Bolseiro extends Aluno {
  private int bolsa;
  private Professor orientador;

  public Bolseiro(String nome, int cc, DateYMD dataNasc, Professor orientador, int bolsa, DateYMD dataInsc) {
    super(nome, cc, dataNasc, dataInsc);
    this.bolsa = bolsa;
    this.orientador = orientador;
  }

  public int getBolsa() {
    return bolsa;
  }

  public Professor getOrientador() {
    return orientador;
  }

  public void setBolsa(int bolsa) {
    this.bolsa = bolsa;
  }

  public void setOrientador(Professor orientador) {
    this.orientador = orientador;
  }

  @Override
  public String toString() {
    return "Bolseiro [bolsa=" + bolsa + ", orientador=" + orientador + "]";
  }
}
