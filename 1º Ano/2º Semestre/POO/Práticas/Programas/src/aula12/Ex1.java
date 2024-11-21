package aula12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Ex1 {

  public static void main(String[] args) {
    readfile(
        "C:\\Users\\rafae\\OneDrive - Universidade de Aveiro\\uni\\1º Ano\\2º Semestre\\POO\\Práticas\\Programas\\src\\aula12\\movies.txt");
  }

  public static void readfile(String file) {
    try {
      Scanner sc = new Scanner(new FileReader(file));
      int count = 0;
      Map<String, Integer> palavras = new TreeMap<>();
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        String[] parts = line.split(" ");

        for (int i = 0; i < parts.length - 1; i++) {
          palavras.put(parts[i], null);
          count++;
        }
      }
      System.out.println("Número total de palavras: " + count);
      System.out.println("Número de palavras diferentes: " + palavras.size());
      sc.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }

  }
}
