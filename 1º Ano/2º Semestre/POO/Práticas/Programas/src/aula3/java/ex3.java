package aula3.java;

import java.util.Scanner;
import java.util.Random;

public class ex3 {
  public static void main(String[] args) {

    int n = 0;
    String answer = "y";
    Random rand = new Random();
    boolean check = false;
    boolean val = false;
    Scanner sc = new Scanner(System.in);

    do {
      int sec = rand.nextInt(99) + 1;
      do {
        do {
          do {

            System.out.println("Guess:");
            n = sc.nextInt();
            if (n < 1 || n > 100) {
              System.out.println("Number should be between 1-100.\n");
            } else {
              val = true;
            }
          } while (val = false);

          if (n < sec) {
            System.out.println("Higher!\n");
          } else if (n > sec) {
            System.out.println("Lower!\n");
          } else {
            System.out.println("Correct!\n");
            check = true;
            break;
          }
        } while (check == false);
      } while (n != sec);

      System.out.println("Want to play again? (y/n)");
      answer = sc.next();
      System.out.println();
      if (answer.equals("y")) {
        continue;
      } else {
        break;
      }
    } while (answer.equals("y"));
    sc.close();
  }
}