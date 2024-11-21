package avaliacaoaula;

import java.time.*;
import java.time.format.*;
import java.util.Objects;

public class Book {
  private static int nextId = 1;
  private int id;
  private String nome;
  private String autor;
  private String editora;
  private String isbn;
  private LocalDate data;
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  public Book(String nome, String autor, String editora, String isbn, String data) {
    this.id = nextId++;
    this.nome = nome;
    this.autor = autor;
    this.editora = editora;
    this.isbn = isbn;
    this.data = LocalDate.parse(data, formatter);
    ;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getAutor() {
    return this.autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public String getEditora() {
    return this.editora;
  }

  public void setEditora(String editora) {
    this.editora = editora;
  }

  public String getIsbn() {
    return this.isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public LocalDate getData() {
    return this.data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public Book id(int id) {
    setId(id);
    return this;
  }

  public Book nome(String nome) {
    setNome(nome);
    return this;
  }

  public Book autor(String autor) {
    setAutor(autor);
    return this;
  }

  public Book editora(String editora) {
    setEditora(editora);
    return this;
  }

  public Book isbn(String isbn) {
    setIsbn(isbn);
    return this;
  }

  public Book data(LocalDate data) {
    setData(data);
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
    return id == book.id && Objects.equals(nome, book.nome) && Objects.equals(autor, book.autor)
        && Objects.equals(editora, book.editora) && Objects.equals(isbn, book.isbn) && Objects.equals(data, book.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, autor, editora, isbn, data);
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", nome='" + getNome() + "'" +
        ", autor='" + getAutor() + "'" +
        ", editora='" + getEditora() + "'" +
        ", isbn='" + getIsbn() + "'" +
        ", data='" + getData() + "'" +
        "}";
  }

}
