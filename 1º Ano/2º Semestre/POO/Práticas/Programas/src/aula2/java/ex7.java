package aula2.java;

import java.util.Scanner;

public class ex7 {
  public static void main(String[] args) {

    double xp1 = 0;
    double xp2 = 0;
    double yp1 = 0;
    double yp2 = 0;
    double dist = 0;

    Scanner sc = new Scanner(System.in);
    System.out.println("Introduza o X do ponto 1: ");
    xp1 = sc.nextDouble();
    System.out.println("Introduza o Y do ponto 1: ");
    yp1 = sc.nextDouble();
    System.out.println("Introduza o X do ponto 2: ");
    xp2 = sc.nextDouble();
    System.out.println("Introduza o Y do ponto 2: ");
    yp2 = sc.nextDouble();

    dist = Math.sqrt(Math.pow(xp2 - xp1, 2) + Math.pow(yp2 - yp1, 2));
    System.out.printf("Distância: %.2f", dist);
    sc.close();
  }
}
