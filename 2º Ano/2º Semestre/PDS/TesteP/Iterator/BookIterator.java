import java.util.List;

public class BookIterator implements Iterator {
    List<String> books;
    int idx;

    public BookIterator(List<String> books) {
        this.books = books;
        this.idx = 0;
    }

    @Override
    public boolean hasNext() {
        if (idx < books.size()) {
            return true;
        }
        return false;
    }

    @Override
    public String next() {
        return this.books.get(idx++);
    }

}
