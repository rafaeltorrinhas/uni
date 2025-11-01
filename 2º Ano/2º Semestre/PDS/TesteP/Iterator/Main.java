import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> booklist = new ArrayList<String>();
        booklist.add("Book 1");
        booklist.add("Book 2");
        booklist.add("Book 3");
        booklist.add("Book 4");
        booklist.add("Book 5");
        booklist.add("Book 6");
        BookCollection books = new BookCollection(booklist);

        BookIterator iter = books.createIterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

    }
}
