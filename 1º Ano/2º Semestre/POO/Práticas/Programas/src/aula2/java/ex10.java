package aula2.java;

import java.util.Scanner;

public class ex10 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Introduza números (Introduza o primeiro de novo para terminar):");
    double firstNumber = scanner.nextDouble();
    double max = firstNumber;
    double min = firstNumber;
    double sum = firstNumber;
    int count = 1;

    for (double number = scanner.nextDouble(); number != firstNumber; number = scanner.nextDouble()) {
      if (number > max) {
        max = number; // atribui valores ao máx
      }
      if (number < min) {
        min = number; // atribui valores ao min
      }
      sum += number; // soma os números
      count++; // conta o total de números
    }

    double average = sum / count; // calcula a média

    System.out.println("Máximo: " + max);
    System.out.println("Mínimo: " + min);
    System.out.println("Média: " + average);
    System.out.println("Números (#): " + count);

    scanner.close();
  }

}
