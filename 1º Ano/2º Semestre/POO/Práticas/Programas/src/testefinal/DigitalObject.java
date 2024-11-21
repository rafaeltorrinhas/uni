package testefinal;

import java.util.*;

public class DigitalObject {
  String doi;

  SensitivityLevel sensitivityLevel;
  User owner;
  ArrayList<DigitalObject> objects = new ArrayList<>();

  public DigitalObject(String doi, User owner, SensitivityLevel sensitivityLevel) {
    this.doi = doi;
    this.owner = owner;
    this.sensitivityLevel = sensitivityLevel;

  }

}
