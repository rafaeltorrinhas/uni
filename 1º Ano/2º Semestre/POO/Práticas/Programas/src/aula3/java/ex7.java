package aula3.java;

import java.util.Scanner;

public class ex7 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Frase:");
    String sentence = scanner.nextLine();

    System.out.println("Número de números: " + countDigits(sentence));
    System.out.println("Número de espaços: " + countSpaces(sentence));
    System.out.println("Minúscula?: " + isLowerCase(sentence));
    System.out.println("Frase com no máximo um espaço entre palavras: " + replaceConsecutiveSpaces(sentence));
    System.out.println("É palindromo?: " + isPalindrome(sentence));
    scanner.close();
  }

  public static int countDigits(String s) {
    int count = 0;
    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        count++;
      }
    }
    return count;
  }

  public static int countSpaces(String s) {
    int count = 0;
    for (char c : s.toCharArray()) {
      if (c == ' ') {
        count++;
      }
    }
    return count;
  }

  public static boolean isLowerCase(String s) {
    for (char c : s.toCharArray()) {
      if (Character.isLetter(c) && Character.isUpperCase(c)) {
        return false;
      }
    }
    return true;
  }

  public static String replaceConsecutiveSpaces(String s) {
    return s.replaceAll("\\s+", " ");
  }

  public static boolean isPalindrome(String s) {
    s = s.replaceAll("\\s", "").toLowerCase();
    return new StringBuilder(s).reverse().toString().equals(s);
  }
}
