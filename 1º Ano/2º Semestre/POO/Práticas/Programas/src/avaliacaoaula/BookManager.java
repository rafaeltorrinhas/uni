package avaliacaoaula;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.io.PrintWriter;

public class BookManager {

  public HashMap<Integer, Book> biblioteca;

  public BookManager() {
    this.biblioteca = new HashMap<>();
  }

  public void addBook(Book book) {
    boolean isPresent = false;
    for (Book b : biblioteca.values()) {
      if (b.getNome().equals(book.getNome()) || b.getIsbn().equals(book.getIsbn())) {
        isPresent = true;
        break;
      }
    }
    if (isPresent == false) {
      biblioteca.put(book.getId(), book);
    }
  }

  public void removeBook(int id) {
    if (biblioteca.get(id) != null) {
      biblioteca.remove(id);
    } else {
      System.out.println("Não existe livro com este id");
    }
  }

  public Book getBook(int id) {
    if (biblioteca.get(id) != null) {
      return biblioteca.get(id);
    } else
      return null;
  }

  public double calculateBookLoanCost(int days, int id) {
    LoanCostCalculator custo = new LoanCostCalculator();
    return custo.calculateCost(days);
  }

  public void printAllBooks() {
    for (Book book : biblioteca.values()) {
      System.out.println(book);
    }
  }

  public void readFile(String file) {
    try {
      File file1 = new File(file);
      Scanner sc = new Scanner(file1);

      if (sc.hasNextLine()) {
        sc.nextLine();
      }

      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        String[] bookInfo = line.split("\t");
        String title = bookInfo[0];
        String author = bookInfo[1];
        String publisher = bookInfo[2];
        String isbn = bookInfo[3];
        String date = bookInfo[4];
        Book book = new Book(title, author, publisher, isbn, date);
        addBook(book);
      }
      sc.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found.");
    }
  }

  public void writeFile(String file) {
    try {
      PrintWriter writer = new PrintWriter(file);
      for (Book book : biblioteca.values()) {

        writer
            .println(book.getNome() + "\t" + book.getAutor() + "\t" + book.getEditora() + "\t" + book.getIsbn() + "\t" +
                book.getData());
      }
      writer.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
