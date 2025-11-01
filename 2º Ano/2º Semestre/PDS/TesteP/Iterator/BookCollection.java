import java.util.List;

public class BookCollection {
    List<String> books;

    public BookCollection(List<String> books) {
        this.books = books;
    }

    public BookIterator createIterator() {
        return new BookIterator(books);
    }
}
