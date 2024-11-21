package testefinal3;

public class Activity {
  int price;
  int numPessoas;

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Activity(int price, int numPessoas) {
    this.price = price;
    this.numPessoas = numPessoas;
  }

  public int getNumPessoas() {
    return numPessoas;
  }

  public void setNumPessoas(int numPessoas) {
    this.numPessoas = numPessoas;
  }

}

class Sport extends Activity {
  Modality modality;

  public enum Modality {
    KAYAK,
    HIKING,
    BIKE,
    BOWLING
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Sport(Modality modality, int numPessoas) {
    super(30, numPessoas);
    this.modality = modality;
  }

  @Override
  public String toString() {
    return "    " + modality + " with " + numPessoas + " participants.";
  }

}

class Culture extends Activity {
  Option option;

  public enum Option {
    ARCHITECTURAL_TOUR,
    RIVER_TOUR,
    ART_MUSEUM,
    WINE_TASTING
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Option getOption() {
    return option;
  }

  public void setOption(Option option) {
    this.option = option;
  }

  public Culture(Option option, int numPessoas) {
    super(22, numPessoas);
    this.option = option;
  }

  @Override
  public String toString() {
    return "    " + option + " with " + numPessoas + " participants.";
  }
}

class Catering extends Activity {

  public int numPessoas;
  Option option;

  public enum Option {
    DRINKS_AND_SNACKS,
    LIGHT_BITES,
    FULL_MENU

  }

  public Option getOption() {
    return option;
  }

  public void setOption(Option option) {
    this.option = option;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Catering(Option option, int numPessoas) {
    super(25, numPessoas);
    this.option = option;
  }

  @Override
  public String toString() {
    return "    " + option + " with " + numPessoas + " participants.";
  }
}