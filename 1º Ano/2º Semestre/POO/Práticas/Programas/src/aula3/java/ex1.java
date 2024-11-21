package aula3.java;

import java.util.Scanner;

public class ex1 {
  public static void main(String[] args) {

    int n = 0;
    double sum = 0;
    boolean pos = false;
    Scanner sc = new Scanner(System.in);
    do {

      System.out.println("\nNº: ");
      n = sc.nextInt();

      if (n >= 0) {
        pos = true;
      } else {
        System.out.println("Número inválido.");
      }

    } while (pos == false);

    for (int i = 2; i <= n; i++) {
      if (isPrime(i) == true) {
        sum += i;
      }
    }

    System.out.printf("Soma: %.0f \n", sum);
    sc.close();
  }

  public static boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}