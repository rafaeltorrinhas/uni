package aula3.java;

import java.util.Scanner;

public class ex6 {
  public static void main(String[] args) {

    String phrase = "";
    Scanner sc = new Scanner(System.in);
    System.out.println("Introduza uma palavra, frase ou parágrafo.");
    phrase = sc.nextLine();
    System.out.println(lowerCase(phrase));
    System.out.println(lastLetter(phrase));
    System.out.println(firstChars(phrase));
    sc.close();
  }

  public static String lowerCase(String phrase) {
    return phrase.toLowerCase();
  }

  public static String lastLetter(String phrase) {
    return String.valueOf(phrase.charAt(phrase.length() - 1));
  }

  public static String firstChars(String phrase) {

    String chars = "";
    for (int i = 0; i < 3; i++) {
      chars += String.valueOf(phrase.charAt(i));
    }
    return (chars);
  }

}
