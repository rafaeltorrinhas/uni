package aula2.java;

import java.util.Scanner;

public class ex1 {
  public static void main(String[] args) {
    double km = 0;
    double miles = 0;

    Scanner sc = new Scanner(System.in);
    System.out.println("Introduza os km: ");
    km = sc.nextDouble();
    miles = km / 1.609;

    System.out.printf("Milhas: %.2f \n", miles);
    sc.close();
  }
}