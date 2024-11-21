package aula08;

public class Veiculos implements KmPercorridosInterface {

  String modelo;
  String matricula;
  String marca;
  int potencia;
  int distanciaPercorrida;

  @Override
  public int distanciaTotal() {
    return distanciaPercorrida;
  }

  @Override
  public void trajeto(int quilometros) {
    distanciaPercorrida += quilometros;
  }

  @Override
  public int ultimoTrajeto() {
    return distanciaPercorrida;
  }

  public String getModelo() {
    return modelo;
  }

  public String getMatricula() {
    return matricula;
  }

  public String getMarca() {
    return marca;
  }

  public int getPotencia() {
    return potencia;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public void setPotencia(int potencia) {
    this.potencia = potencia;
  }

  public Veiculos(String modelo, String matricula, String marca, int potencia) {
    this.modelo = modelo;
    this.matricula = matricula;
    this.marca = marca;
    this.potencia = potencia;
    this.distanciaPercorrida = 0;
  }

  public static void main(String[] args) {
    Veiculos veiculo1 = new Motociclo("Modelo1", "Matricula1", "Marca1", 100, "Tipo1");
    Veiculos veiculo2 = new AutomovelLigeiro("Modelo2", "Matricula2", "Marca2", 200, 5, "NQuadro2");
    Veiculos veiculo3 = new Taxi("Modelo3", "Matricula3", "Marca3", 300, 4, "NQuadro3", 123);
    Veiculos veiculo4 = new PesadoMercadorias("Modelo4", "Matricula4", "Marca4", 400, 456, 1000, 5000);
    Veiculos veiculo5 = new PesadoPassageiros("Modelo5", "Matricula5", "Marca5", 500, 789, 2000, 50);

    Veiculos[] veiculos = { veiculo1, veiculo2, veiculo3, veiculo4, veiculo5 };

    Empresa empresa = new Empresa("NomeEmpresa", "CodigoPostal", veiculos.length, veiculos, "email@empresa.com");

    veiculo1.setModelo("NovoModelo");
    System.out.println(veiculo1.getModelo());

    empresa.setNome("NovaEmpresa");
    System.out.println(empresa.getNome());

    System.out.println(veiculo1.toString());
    System.out.println(empresa.toString());

    System.out.println(veiculo1.equals(veiculo2));

    veiculo1.trajeto(100);
    veiculo2.trajeto(200);
    veiculo3.trajeto(300);
    veiculo4.trajeto(400);
    veiculo5.trajeto(500);

    System.out.println(veiculo1.distanciaTotal());
    System.out.println(veiculo2.distanciaTotal());
    System.out.println(veiculo3.distanciaTotal());
    System.out.println(veiculo4.distanciaTotal());
    System.out.println(veiculo5.distanciaTotal());

    Veiculos veiculoComMaiorKm = empresa.getV()[0];
    for (Veiculos veiculo : empresa.getV()) {
      if (veiculo.distanciaTotal() > veiculoComMaiorKm.distanciaTotal()) {
        veiculoComMaiorKm = veiculo;
      }
    }
    System.out.println("Veículo com maior quilómetros percorridos: " + veiculoComMaiorKm.getModelo());
  }
}

class Motociclo extends Veiculos {

  String tipo;

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getTipo() {
    return tipo;
  }

  public Motociclo(String modelo, String matricula, String marca, int potencia, String tipo) {
    super(modelo, matricula, marca, potencia);
    this.tipo = tipo;
  }

}

class AutomovelLigeiro extends Veiculos {

  int capacidade;
  String nquadro;

  public int getCapacidade() {
    return capacidade;
  }

  public void setCapacidade(int capacidade) {
    this.capacidade = capacidade;
  }

  public String getNquadro() {
    return nquadro;
  }

  public void setNquadro(String nquadro) {
    this.nquadro = nquadro;
  }

  public AutomovelLigeiro(String modelo, String matricula, String marca, int potencia, int capacidade, String nquadro) {
    super(modelo, matricula, marca, potencia);
    this.capacidade = capacidade;
    this.nquadro = nquadro;
  }

}

class Taxi extends AutomovelLigeiro {

  int numerol;

  public int getNumerol() {
    return numerol;
  }

  public void setNumerol(int numerol) {
    this.numerol = numerol;
  }

  public Taxi(String modelo, String matricula, String marca, int potencia, int capacidade, String nquadro,
      int numerol) {
    super(modelo, matricula, marca, potencia, capacidade, nquadro);
    this.numerol = numerol;
  }

}

class PesadoMercadorias extends Veiculos {
  int nquadro;
  int peso;
  int maxcarga;

  public int getNquadro() {
    return nquadro;
  }

  public void setNquadro(int nquadro) {
    this.nquadro = nquadro;
  }

  public int getPeso() {
    return peso;
  }

  public void setPeso(int peso) {
    this.peso = peso;
  }

  public int getMaxcarga() {
    return maxcarga;
  }

  public void setMaxcarga(int maxcarga) {
    this.maxcarga = maxcarga;
  }

  public PesadoMercadorias(String modelo, String matricula, String marca, int potencia, int nquadro, int peso,
      int maxcarga) {
    super(modelo, matricula, marca, potencia);
    this.nquadro = nquadro;
    this.peso = peso;
    this.maxcarga = maxcarga;
  }

}

class PesadoPassageiros extends Veiculos {
  int nquadro;
  int peso;
  int maxpassageiros;

  public int getNquadro() {
    return nquadro;
  }

  public void setNquadro(int nquadro) {
    this.nquadro = nquadro;
  }

  public int getPeso() {
    return peso;
  }

  public void setPeso(int peso) {
    this.peso = peso;
  }

  public int getMaxpassageiros() {
    return maxpassageiros;
  }

  public void setMaxpassageiros(int maxpassageiros) {
    this.maxpassageiros = maxpassageiros;
  }

  public PesadoPassageiros(String modelo, String matricula, String marca, int potencia, int nquadro, int peso,
      int maxpassageiros) {
    super(modelo, matricula, marca, potencia);
    this.nquadro = nquadro;
    this.peso = peso;
    this.maxpassageiros = maxpassageiros;
  }
}

class Empresa {

  String nome;
  String codigopostal;
  int countveiculos;
  public Veiculos[] v;
  String email;

  public Empresa(String nome, String codigopostal, int countveiculos, Veiculos[] v, String email) {
    this.nome = nome;
    this.codigopostal = codigopostal;
    this.countveiculos = countveiculos;
    this.v = v;
    this.email = email;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCodigopostal() {
    return codigopostal;
  }

  public void setCodigopostal(String codigopostal) {
    this.codigopostal = codigopostal;
  }

  public int getCountveiculos() {
    return countveiculos;
  }

  public void setCountveiculos(int countveiculos) {
    this.countveiculos = countveiculos;
  }

  public Veiculos[] getV() {
    return v;
  }

  public void setV(Veiculos[] v) {
    this.v = v;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}

interface VeiculoEletrico {
  int autonomia();

  void carregar(int percentagem);
}

class AutomovelLigeiroEletrico extends AutomovelLigeiro implements VeiculoEletrico {
  int autonomiaRestante;

  public AutomovelLigeiroEletrico(String modelo, String matricula, String marca, int potencia, int capacidade,
      String nquadro) {
    super(modelo, matricula, marca, potencia, capacidade, nquadro);
    this.autonomiaRestante = 0;
  }

  @Override
  public int autonomia() {
    return autonomiaRestante;
  }

  @Override
  public void carregar(int percentagem) {
    autonomiaRestante += percentagem;
  }
}

class PesadoPassageirosEletrico extends PesadoPassageiros implements VeiculoEletrico {
  int autonomiaRestante;

  public PesadoPassageirosEletrico(String modelo, String matricula, String marca, int potencia, int nquadro, int peso,
      int maxpassageiros) {
    super(modelo, matricula, marca, potencia, nquadro, peso, maxpassageiros);
    this.autonomiaRestante = 0;
  }

  @Override
  public int autonomia() {
    return autonomiaRestante;
  }

  @Override
  public void carregar(int percentagem) {
    autonomiaRestante += percentagem;
  }
}