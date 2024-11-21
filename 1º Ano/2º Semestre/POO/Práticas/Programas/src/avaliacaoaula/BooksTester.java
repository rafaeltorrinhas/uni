package avaliacaoaula;

public class BooksTester {
    public static void main(String[] args) {
        BookManager bm = new BookManager();

        // --------------------------
        Book b1 = new Book("Memorial do Convento", "José Saramago", "Porto Editora", "978-972-0-04671-0", "2014-09-01");
        Book b2 = new Book("O Último Cabalista de Lisboa", "Richard Zimler", "Porto Editora", "978-972-0-04491-4",
                "2013-09-01");
        bm.addBook(b1);
        bm.addBook(b2);
        bm.printAllBooks();

        bm.removeBook(2);
        System.out.println("All books after deleting book with id=2");
        bm.printAllBooks();

        System.out.println("Adding again the second book.");
        bm.addBook(b2);
        bm.printAllBooks();
        // --------------------------

        b2 = bm.getBook(5); // -- does not exist!
        System.out.println(b2);
        System.out.println(bm.calculateBookLoanCost(1, 5)); // (days, id) -- Book does not exist!
        // --------------------------

        bm.printAllBooks();
        System.out.println("------------------");
        // --------------------------

        bm.readFile("books.txt");
        bm.printAllBooks();
        // --------------------------

        System.out.println(bm.getBook(5));
        System.out.println(bm.calculateBookLoanCost(12, 5)); // (days, id)
        // --------------------------

        bm.writeFile("out_books_final.txt");

    }
}
