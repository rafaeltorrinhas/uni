package aula10;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Ex4 {
  public static void main(String[] args) throws IOException {
    List<String> moreThan2 = new ArrayList<>();
    List<String> endsWithS = new ArrayList<>();
    List<String> onlyLetters = new ArrayList<>();
    Scanner sc = new Scanner(
        new FileReader("/home/rafael/OneDrive/uni/1º Ano/2º Semestre/POO/Práticas/Programas/src/aula10/words.txt"));

    while (sc.hasNext()) {
      String word = sc.next();
      if (word.length() > 2) {
        moreThan2.add(word);
      }
      if (word.length() - 1 == word.lastIndexOf("s")) {
        endsWithS.add(word);
      }
      if (word.matches("[a-zA-Z]+")) {
        onlyLetters.add(word);
      }
      System.out.println(word);
    }
    System.out.println(moreThan2);
    System.out.println(endsWithS);
    System.out.println(onlyLetters);
    sc.close();
  }
}
