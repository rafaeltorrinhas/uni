package aula2.java;

import java.util.Scanner;

public class ex4 {
  public static void main(String[] args) {
    double ammount = 0;
    double tax = 0;

    Scanner sc = new Scanner(System.in);
    System.out.println("Introduza o investimento (€): ");
    ammount = sc.nextDouble();
    System.out.println("Introduza a taxa (%): ");
    tax = sc.nextDouble();

    for (int i = 0; i < 3; i++) {
      ammount += ((tax / 100) * ammount);
    }

    System.out.printf("O montante ao fim de 3 meses é: %.3f euros \n", ammount);
    sc.close();
  }
}
