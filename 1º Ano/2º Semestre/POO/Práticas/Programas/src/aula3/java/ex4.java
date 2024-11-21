package aula3.java;

import java.util.Scanner;
import java.util.Random;

public class ex4 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    System.out.println("Insira o número de alunos:");
    int n = scanner.nextInt();

    double[][] notas = new double[n][2];

    for (int i = 0; i < n; i++) {
      notas[i][0] = Math.round(20.0 * random.nextDouble());
      notas[i][1] = Math.round(20.0 * random.nextDouble());
    }

    System.out.println("NotaT  NotaP  Pauta");

    for (int i = 0; i < n; i++) {
      double notaT = calculateNotaTotal(notas[i][0], notas[i][1]);
      System.out.printf("%5.1f   %5.1f    %2.0f\n", notas[i][0], notas[i][1], notaT);
      scanner.close();
    }
  }

  public static double calculateNotaTotal(double notaT, double notaP) {
    if (notaT < 7.0 || notaP < 7.0) {
      return 66.0;
    } else {
      return Math.round((0.4 * notaT + 0.6 * notaP) * 10) / 10.0;
    }
  }
}
