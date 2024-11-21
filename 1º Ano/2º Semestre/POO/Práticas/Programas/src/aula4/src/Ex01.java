package aula4.src;

import java.util.*;

public class Ex01 {
  public static void main(String[] args) {

    // Circulo c1 = new Circulo(3);
    // Circulo c2 = new Circulo(4);
    // Circulo c3 = new Circulo(3);
    // System.out.println("Raio: " + c1.raio);

    // System.out.println(c1);

    // c1.setRaio(5);
    // System.out.println(c1); // set

    // System.out.println("Raio: " + c1.getRaio()); // get
    // System.out.println(c1.equals(c2));
    // System.out.println(c1.equals(c3));

    // System.out.println("Perímetro: " + c1.perimetro() + "\n" + "Área: " +
    // c1.area());

    // Triangulo t1 = new Triangulo(3, 3, 3);
    // Triangulo t2 = new Triangulo(1, 6, 6);

    // System.out.println(t1);
    // System.out.println("Área do triângulo: " + t1.area());
    // System.out.println("Perímetro do triângulo: " + t1.perimetro());
    // t1.setLados(3, 1, 3);
    // System.out.println(t1);
    // System.out.println("Lado 1: " + t1.getL1() + ", Lado 2: " + t1.getL2() + ",
    // Lado 3: " + t1.getL3());
    // System.out.println(t1.equals(t2));

    // Retangulo r1 = new Retangulo(7, 4);
    // Retangulo r2 = new Retangulo(4, 7);

    // System.out.println(r1);
    // System.out.println("Área: " + r1.area());
    // System.out.println("Perímetro: " + r1.perimetro());
    // r1.setLados(4, 7);
    // r2.setLados(7, 4);
    // System.out.println("Comp:" + r1.getC() + " Larg: " + r1.getL());

    int option;
    Scanner sc = new Scanner(System.in);
    do {

      System.out.println("Escolha uma opção:\n1 - Círculo\n2 - Triângulo\n3 - Retângulo");
      option = sc.nextInt();

    } while (option < 1 || option > 3);

    switch (option) {
      case 1:

        Circulo c1 = new Circulo(3);
        Circulo c2 = new Circulo(4);
        Circulo c3 = new Circulo(3);
        System.out.println("Raio: " + c1.raio);

        System.out.println(c1);

        c1.setRaio(5);
        System.out.println(c1);

        System.out.println("Raio: " + c1.getRaio());
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));

        System.out.println("Perímetro: " + c1.perimetro() + "\n" + "Área: " +
            c1.area());
        break;

      case 2:

        Triangulo t1 = new Triangulo(3, 3, 3);
        Triangulo t2 = new Triangulo(1, 6, 6);

        System.out.println(t1);
        System.out.println("Área do triângulo: " + t1.area());
        System.out.println("Perímetro do triângulo: " + t1.perimetro());
        t1.setLados(3, 1, 3);
        System.out.println(t1);
        System.out.println("Lado 1: " + t1.getL1() + ", Lado 2: " + t1.getL2() + ", Lado 3: " + t1.getL3());
        System.out.println(t1.equals(t2));
        break;

      case 3:
        Retangulo r1 = new Retangulo(7, 4);
        Retangulo r2 = new Retangulo(4, 7);

        System.out.println(r1);
        System.out.println("Área: " + r1.area());
        System.out.println("Perímetro: " + r1.perimetro());
        r1.setLados(4, 7);
        r2.setLados(7, 4);
        System.out.println("Comp: " + r1.getC() + "\nLarg: " + r1.getL());
        System.out.println(r1.equals(r2));
        break;

      default:
        break;
    }
    sc.close();
  }
}
