package aula10;

import java.util.*;

public class Ex1 {

  public static void main(String[] args) {
    Map<String, Book> mapa = new HashMap<>();
    Book l1 = new Book("Informação Dramática", "Men da RTP", 2005);
    Book l2 = new Book("Cama Molhada", "Wet Bed Gang", 1910);
    Book l3 = new Book("A saga dos Pokemons", "Numeiro", 1879);
    Book l4 = new Book("Engraçado", "Dillaz", 2012);
    Book l5 = new Book("Noite sem Espinafres", "Popeye", 1796);

    mapa.put("Drama", l1);
    System.out.println(mapa.get("Drama"));
    mapa.put("Romance", l2);
    System.out.println(mapa.get("Romance"));
    mapa.put("Ação", l3);
    System.out.println(mapa.get("Ação"));
    mapa.put("Comédia", l4);
    System.out.println(mapa.get("Comédia"));
    mapa.put("Terror", l5);
    System.out.println(mapa.get("Terror"));
    System.out.println(mapa);
    mapa.remove("Drama");
    System.out.println(mapa);
    mapa.replace("Romance", l2, l4);
    System.out.println(mapa.get("Romance"));
    mapa.replace("Comédia", l4, l2);
    System.out.println(mapa.get("Comédia"));
  }

}

class Book {

  private String title;
  private String author;
  private int year;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public Book() {
  }

  public Book title(String title) {
    setTitle(title);
    return this;
  }

  public Book author(String author) {
    setAuthor(author);
    return this;
  }

  public Book year(int year) {
    setYear(year);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Book)) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(title, book.title) && Objects.equals(author, book.author) && year == book.year;
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, author, year);
  }

  @Override
  public String toString() {
    return "'" + getTitle() + "'" +
        ", '" + getAuthor() + "'" +
        ", " + getYear() + "";
  }

  public Book(String title, String author, int year) {
    this.title = title;
    this.author = author;
    this.year = year;
  }

}