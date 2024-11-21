package aula2.java;

import java.util.Scanner;

public class ex8 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Tamanho de A: ");
    double A = sc.nextDouble();

    System.out.print("Tamanho de B: ");
    double B = sc.nextDouble();

    if (A <= 0 || B <= 0) {
      System.out.println("Valores inválidos");
    }

    double hypotenuse = Math.sqrt(A * A + B * B);
    double angle = Math.toDegrees(Math.atan(A / B));

    System.out.println("Hypotenusa: " + hypotenuse);
    System.out.println("Ângulo entre A e a hipotenusa: " + angle);

    sc.close();
  }
}
