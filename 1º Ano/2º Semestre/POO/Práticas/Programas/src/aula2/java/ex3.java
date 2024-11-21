package aula2.java;

import java.util.Scanner;

public class ex3 {
  public static void main(String[] args) {
    double qtd = 0;
    double tfinal = 0;
    double tinicial = 0;
    double q = 0;

    Scanner sc1 = new Scanner(System.in);
    System.out.println("Introduza a quantidade de água(kg): ");
    qtd = sc1.nextDouble();
    // Scanner sc2 = new Scanner(System.in);
    System.out.println("Introduza a temperatura inicial (ºC): ");
    // tinicial = sc2.nextDouble;
    tinicial = sc1.nextDouble();
    // Scanner sc3 = new Scanner(System.in);
    System.out.println("Introduza a temperatura final (ºC)");
    // tfinal = sc3.nextDouble();
    tfinal = sc1.nextDouble();

    q = qtd * (tfinal - tinicial) * 4148;

    System.out.printf("Energia %.2f", q);

    sc1.close();
    // sc2.close();
    // sc3.close();
  }
}
