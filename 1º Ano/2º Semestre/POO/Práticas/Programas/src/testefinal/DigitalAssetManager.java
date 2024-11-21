package testefinal;

import java.util.*;

public class DigitalAssetManager implements DigitalAssetManagerInterface {

  int count = 0;
  int gcount = -1;
  RegisteredUser[] users = new RegisteredUser[20];

  @Override

  public User registerUser(String userName) {
    int id = count++;
    RegisteredUser user = new RegisteredUser(id, userName);

    return user;
  }

  @Override
  public User getUser(String userName) {

    return null;
  }

  @Override
  public User createGuestUser() {
    int id = gcount--;
    GuestUser guestuser = new GuestUser(id);
    return guestuser;
  }

  @Override
  public DigitalObject registerDigitalObject(String doi, User owner) {
    DigitalObject object = new DigitalObject(doi, owner, null);
    return object;
  }

  @Override
  public boolean setObjectSensitivity(String doi, SensitivityLevel sensitivityLevel, User owner) {
    if (owner)
      return false;
  }

}
