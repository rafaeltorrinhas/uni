package aula3.java;

import java.util.Scanner;

public class ex2 {
  public static void main(String[] args) {
    int n = 0;
    double tax = 0;
    Scanner sc = new Scanner(System.in);

    do {

      System.out.println("Insere o montante a investir (Múltiplo de 1000):");
      n = sc.nextInt();
      if (n % 1000 != 0 || n < 0) {
        System.out.println("Valor inváido.");
      }
    } while (n % 1000 != 0 || n < 0);

    do {
      System.out.println("Insere o valor da taxa de juro mensal [0-5 (%)]");
      tax = sc.nextDouble();
      if (tax < 0 || tax > 5) {
        System.out.println("Valor inválido.");
      }
    } while (tax < 0 || tax > 5);

    for (int i = 0; i <= 12; i++) {
      n += n * tax / 100;
      System.out.println("No " + i + "º mês, o valor mensal do fundo é: " + n);
    }
    sc.close();

  }
}
