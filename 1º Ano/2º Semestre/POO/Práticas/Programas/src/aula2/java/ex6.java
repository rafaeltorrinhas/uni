package aula2.java;

import java.util.Scanner;

public class ex6 {
  public static void main(String[] args) {
    double s = 0;
    double hh = 0;
    double mm = 0;
    double ss = 0;

    Scanner sc = new Scanner(System.in);
    System.out.println("Introduza o tempo em segundos: ");
    try {
      s = sc.nextDouble();
    } catch (java.util.InputMismatchException e) {
      System.out.println("Valor inválido.");
      sc.close();
      return;
    }

    if (s < 0) {
      System.out.println("Valor inválido.");
    } else {
      hh = (s / 3600);
      mm = (s % 3600) / 60;
      ss = (s % 3600) % 60;
    }

    System.out.printf("%.0f:%.0f:%.0f", hh, mm, ss);
    sc.close();
  }
}
