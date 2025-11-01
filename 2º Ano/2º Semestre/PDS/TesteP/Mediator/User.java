import java.util.ArrayList;
import java.util.List;

public class User {

    static List<User> userlist = new ArrayList<>();

    public User() {
        userlist.add(this);
    }

}
