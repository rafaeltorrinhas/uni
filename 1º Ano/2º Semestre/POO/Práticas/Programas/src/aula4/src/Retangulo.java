package aula4.src;

public class Retangulo {
  double c, l;

  public Retangulo(double valorC, double valorL) {
    if (valorC <= 0 || valorL <= 0) {

      System.out.println("Valores inválidos - será considerado um retângulo com 3 de comprimento e 2 de largura");
      c = 3;
      l = 1;

    } else {

      c = valorC;
      l = valorL;

    }
  }

  public String toString() {
    return "C: " + c + "\nL: " + l;
  }

  public void setLados(double nValorC, double nValorL) {

    if (nValorC <= 0 || nValorL <= 0) {

      System.out.println("Valores inválidos - será considerado um retângulo com 3 de comprimento e 2 de largura");
      c = 3;
      l = 1;

    } else {

      c = nValorC;
      l = nValorL;

    }

  }

  public double area() {
    return c * l;
  }

  public double perimetro() {
    return c * 2 + l * 2;
  }

  public double getC() {
    return c;
  }

  public double getL() {
    return l;
  }

  public boolean equals(Retangulo outroRetangulo) {
    return (c == outroRetangulo.c && l == outroRetangulo.l || c == outroRetangulo.l && l == outroRetangulo.c);
  }
}
