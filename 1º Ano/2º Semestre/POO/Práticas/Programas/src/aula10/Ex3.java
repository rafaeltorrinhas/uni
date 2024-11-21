package aula10;

import java.util.*;

public class Ex3 {
  public static void main(String[] args) {
    String phrase = "Hello World";
    HashMap<Character, StringBuilder> ocorrencias = new HashMap<>();

    for (int i = 0; i < phrase.length(); i++) {
      char c = phrase.charAt(i);
      if (ocorrencias.containsKey(c)) {
        ocorrencias.get(c).append(", ").append(i);
      } else {
        ocorrencias.put(c, new StringBuilder("" + i + ""));
      }
    }
    System.out.println(ocorrencias);
  }
}
