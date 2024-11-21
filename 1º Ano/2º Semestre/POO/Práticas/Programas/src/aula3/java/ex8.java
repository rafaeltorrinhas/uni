package aula3.java;

import java.util.Scanner;

public class ex8 {
  public static void main(String[] args) {
    String phrase = "";
    Scanner sc = new Scanner(System.in);

    System.out.println("Introduza uma frase: ");
    phrase = sc.nextLine();

    System.out.println(convertPhrase(phrase));
    sc.close();
  }

  public static String convertPhrase(String phrase) {
    String[] words = phrase.split(" ");
    String acronym = "";
    for (int i = 0; i < words.length; i++) {
      if (words[i].length() >= 3) {
        acronym += String.valueOf(words[i].charAt(0)).toUpperCase();
      }
    }
    return (acronym);
  }

}
