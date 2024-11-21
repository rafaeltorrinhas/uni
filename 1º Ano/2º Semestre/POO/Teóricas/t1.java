import java.util.Scanner;

public class t1 {
  public static void main(String[] args) {
    String code = "F7HA8";          

    Scanner obj = new Scanner(System.in);
    System.out.println("Enter code:");    // Pede input
    String guess = obj.nextLine();

    boolean checkCode = code.equals(guess);

    if (checkCode) {
      System.out.println("Correct code");
      } else {
      System.out.println("Wrong code");
    }

    double sum = 0; 
    
    for (int i = 0; i < 100; i++) {
      // System.out.println(i);
      sum = sum + i;
    }
    System.out.println(sum);
  }
}
