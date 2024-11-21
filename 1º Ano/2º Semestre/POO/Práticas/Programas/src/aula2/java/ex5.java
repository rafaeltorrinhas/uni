package aula2.java;

import java.util.Scanner;

public class ex5 {
  public static void main(String[] args) {
    double v1 = 0;
    double v2 = 0;
    double d1 = 0;
    double d2 = 0;
    double d = 0;
    double t = 0;
    double vm = 0;

    Scanner sc = new Scanner(System.in);
    System.out.println("Introduza a velocidade no 1º trajeto (m/s): ");
    v1 = sc.nextDouble();
    System.out.println("Introduza a distância no 1º trajeto (m): ");
    d1 = sc.nextDouble();
    System.out.println("Introduza a velocidade no 2º trajeto (m/s): ");
    v2 = sc.nextDouble();
    System.out.println("Introduza a distância no 2º trajeto (m): ");
    d2 = sc.nextDouble();

    if (v1 <= 0 || v2 <= 0 || d1 <= 0 || d2 <= 0) {
      System.out.println("Valores inválidos");
    } else {
      t = d1 / v1 + d2 / v2;
      d = d1 + d2;
      vm = d / t;
    }
    System.out.printf("Velocidade média: %.2f", vm);
    sc.close();
  }
}
