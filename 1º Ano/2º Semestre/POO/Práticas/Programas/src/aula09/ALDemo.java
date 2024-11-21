package aula09;

import aula6.DateYMD;
import aula6.Pessoa;
import aula7.Date;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;

public class ALDemo {
  public static void main(String[] args) {
    ArrayList<Integer> c1 = new ArrayList<>();
    for (int i = 10; i <= 100; i += 10)
      c1.add(i);
    System.out.println("Size: " + c1.size());
    for (int i = 0; i < c1.size(); i++)
      System.out.println("Elemento: " + c1.get(i));
    ArrayList<String> c2 = new ArrayList<>();
    c2.add("Vento");
    c2.add("Calor");
    c2.add("Frio");
    c2.add("Chuva");
    System.out.println(c2);
    Collections.sort(c2);
    System.out.println(c2);
    c2.remove("Frio");
    c2.remove(0);
    System.out.println(c2);
    c2.add("Vento");
    c2.add("Frio");

    // adds
    System.out.println("\n\n\n\n");
    System.out.println(c2.indexOf("Vento"));
    System.out.println(c2.indexOf("Frio"));
    System.out.println(c2.lastIndexOf("Vento"));
    System.out.println(c2.contains("Chuva"));
    System.out.println(c2);
    System.out.println(c2.set(3, "Calor"));
    System.out.println(c2);
    System.out.println(c2.subList(0, 3));

    Set<Pessoa> c3 = new HashSet<>();
    DateYMD d1 = new DateYMD(2005, 5, 12);
    Pessoa p1 = new Pessoa("João", 12345678, d1);
    c3.add(p1);
    c3.add(new Pessoa("João", 12344321, d1));
    c3.add(p1);
    System.out.println(c3);

    Set<Date> c4 = new TreeSet<>();
    // c4.add();

    System.out.println(c4);
  }
}
