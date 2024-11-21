package aula6;

public class Encapsulamento {

  public static void main(String[] args) {

    // Animal a = new Animal("Mamifero", 2.0, 2.0);
    // System.out.println(a);
    // System.out.println(a.weight);
    // System.out.println(a.getWeight()); // usar para ir buscar a espécie quando
    // está "private"

    Dog d = new Dog("Mamífero", 10, 1, "Benjy");
    // System.out.println(d);
    System.out.println(d.weight);
  }
}

class Animal {

  public String species;
  protected double weight;
  public double height;
  // private static int count;

  public Animal(String newSpecies, double newWeight, double newHeight) {

    this.species = newSpecies;
    this.weight = newWeight;
    this.height = newHeight;

    // Animal.count += 1;
  }

  public String getSpecies() {
    return this.species;
  }

  public double getWeight() {
    return this.weight;
  }

  public double getHeight() {
    return this.height;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  @Override
  public String toString() {
    return "Animal: " + this.species + ", weight: " + this.weight + ", height: " + this.height;
  }

}

class Dog extends Animal {

  private String name;

  public Dog(String newSpecies, double newWeight, double newHeight, String newName) {
    super(newSpecies, newWeight, newHeight);
    this.name = newName;
  }

  @Override
  public String toString() {
    return "Name: " + this.name + ", " + super.toString();
  }

}