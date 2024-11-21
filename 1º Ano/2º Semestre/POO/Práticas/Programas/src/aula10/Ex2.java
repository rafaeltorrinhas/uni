package aula10;

import java.util.*;

public class Ex2 {

  public static void main(String[] args) {
    TreeMap<String, List<Book>> mapa = new TreeMap<>();
    List<Book> dramaBooks = new ArrayList<>();
    List<Book> romanceBooks = new ArrayList<>();
    List<Book> acaoBooks = new ArrayList<>();
    List<Book> comediaBooks = new ArrayList<>();
    List<Book> terrorBooks = new ArrayList<>();

    Book l1 = new Book("Informação Dramática", "Men da RTP", 2005);
    Book l2 = new Book("Cama Molhada", "Wet Bed Gang", 1910);
    Book l3 = new Book("A saga dos Pokemons", "Numeiro", 1879);
    Book l4 = new Book("Engraçado", "Dillaz", 2012);
    Book l5 = new Book("Noite sem Espinafres", "Popeye", 1796);

    dramaBooks.add(l1);
    dramaBooks.add(l2);

    acaoBooks.add(l3);
    comediaBooks.add(l4);
    terrorBooks.add(l5);

    mapa.put("Drama", dramaBooks);
    mapa.put("Romance", romanceBooks);
    mapa.put("Ação", acaoBooks);
    mapa.put("Comédia", comediaBooks);
    mapa.put("Terror", terrorBooks);

    System.out.println(getRandomBook(mapa, "Drama")); // dá print no l1 ou l2 (random)
    System.out.println(getRandomBook(mapa, "Romance")); // dá print null (não tem items)
    System.out.println(getRandomBook(mapa, "Ação"));
    System.out.println(getRandomBook(mapa, "Comédia"));
    System.out.println(getRandomBook(mapa, "Terror"));

  }

  public static Book getRandomBook(Map<String, List<Book>> mapa, String genre) {
    List<Book> books = mapa.get(genre);
    if (books != null && !books.isEmpty()) {
      Random random = new Random();
      int index = random.nextInt(books.size());
      return books.get(index);
    }
    return null;
  }
}
