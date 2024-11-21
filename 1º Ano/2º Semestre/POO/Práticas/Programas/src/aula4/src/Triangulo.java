package aula4.src;

public class Triangulo {

  double l1, l2, l3;

  public Triangulo(double valorL1, double valorL2, double valorL3) {

    if (valorL1 <= 0 || valorL2 <= 0 || valorL3 <= 0 || valorL1 >= valorL2 + valorL3 || valorL2 >= valorL1 + valorL3
        || valorL3 >= valorL2 + valorL1) {

      System.out.println("Valores inválidos, irá ser considerado o triângulo com o valor dos lados igual a 1.");
      l1 = 1;
      l2 = 1;
      l3 = 1;

    } else {

      l1 = valorL1;
      l2 = valorL2;
      l3 = valorL3;

    }
  }

  public String toString() {

    return "\nl1: " + l1 + "\nl2: " + l2 + "\nl3: " + l3;

  }

  public double area() {

    double s = (l1 + l2 + l3) / 2;
    double area = Math.sqrt(s * (s - l1) * (s - l2) * (s - l3));
    return area;
  }

  public void setLados(double nValorL1, double nValorL2, double nValorL3) {
    if (nValorL1 <= 0 || nValorL2 <= 0 || nValorL3 <= 0 || nValorL1 >= nValorL2 + nValorL3
        || nValorL2 >= nValorL1 + nValorL3 || nValorL3 >= nValorL2 + nValorL1) {

      System.out.println("Valores inválidos, irá ser considerado o triângulo com o valor dos lados igual a 1.");
      l1 = 1;
      l2 = 1;
      l3 = 1;

    } else {

      l1 = nValorL1;
      l2 = nValorL2;
      l3 = nValorL3;

    }
  }

  public double perimetro() {
    return l1 + l2 + l3;
  }

  public double getL1() {
    return l1;
  }

  public double getL2() {
    return l2;
  }

  public double getL3() {
    return l3;
  }

  public boolean equals(Triangulo outroTriangulo) {
    return l1 == outroTriangulo.l1 && l2 == outroTriangulo.l2 && l3 == outroTriangulo.l3;
  }
}
