package testefinal;

public class User {
  public int id;

  public User(int id) {
    this.id = id;
  }

}

class RegisteredUser extends User {
  public String name;

  public RegisteredUser(int id, String name) {
    super(id);
    this.name = name;
  }

}

class GuestUser extends User {
  public GuestUser(int id) {
    super(id);
  }
}
