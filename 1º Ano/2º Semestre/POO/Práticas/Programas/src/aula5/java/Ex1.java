package aula5.java;

import java.util.Scanner;

public class Ex1 {
  public static void main(String[] args) {
    boolean a = true;
    DateYMD data = new DateYMD();
    Scanner sc = new Scanner(System.in);
    do {
      int option;

      do {
        System.out.println(
            "Date operations:\n 1 - create new date\n 2 - show current date\n 3 - increment date\n 4 - decrement date \n 0 - exit");
        System.out.print("\nOpção: ");
        option = sc.nextInt();

        if (option < 0 || option > 4) {
          System.out.println("Invalid option.");
        }
      } while (option < 0 || option > 4);

      switch (option) {
        case 0:
          a = false;
          break;
        case 1:

          String date;
          String[] dateParts;
          int day;
          int month;
          int year;
          System.out.println("Indique a data no formato YYYY-MM-DD.");
          date = sc.next();
          dateParts = date.split("-");
          day = Integer.valueOf(dateParts[2]);
          month = Integer.valueOf(dateParts[1]);
          year = Integer.valueOf(dateParts[0]);

          data.setDate(day, month, year);
          System.out.printf("\nNew date: %s\n", data);
          System.out.println();
          break;
        case 2:
          System.out.printf("\nData: %s\n", data.getDate());
          System.out.println();
          break;
        case 3:
          data.incrementDate();
          System.out.printf("\nData após incremento: %s\n", data.getDate());
          System.out.println();
          break;
        case 4:
          data.decrementDate();
          System.out.printf("\nData após decremento: %s\n", data.getDate());
          System.out.println();
          break;
      }

    } while (a == true);
    sc.close();
  }
}
