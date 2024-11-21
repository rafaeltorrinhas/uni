package aula2.java;

import java.util.Scanner;

public class ex2 {
  public static void main(String[] args) {
    double c = 0;
    double f = 0;

    Scanner sc = new Scanner(System.in);
    System.out.println("Introduza os ºC: ");
    c = sc.nextDouble();
    f = 1.8 * c + 32;

    System.out.printf("ºF: %.2f \n", f);
    sc.close();
  }
}
