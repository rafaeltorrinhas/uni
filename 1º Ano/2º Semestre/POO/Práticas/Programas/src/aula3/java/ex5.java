package aula3.java;

import java.util.Scanner;

public class ex5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira o mês e ano (mm/yyyy): ");
        String date = sc.nextLine();

        System.out.println("Insira o dia da semana em qual o mês começa [1(segunda)-7(domingo)]: ");
        int startDay = sc.nextInt();

        int month = Integer.parseInt(date.split("/")[0]);
        int year = Integer.parseInt(date.split("/")[1]);

        if (isValidDate(month, year) && startDay >= 1 && startDay <= 7) {
            printCalendar(month, year, startDay);
        } else {
            System.out.println("Invalid input.");
        }
        sc.close();
    }

    public static boolean isValidDate(int month, int year) {
        return month >= 1 && month <= 12 && year > 0;
    }

    public static int getDays(int month, int year) {
        if (month == 2) {
            return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    public static void printCalendar(int month, int year, int startDay) {
        String[] months = { "", "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        String[] days = { "", "Mo", "Tu", "We", "Th", "Fr", "Sa", "Su" };

        System.out.printf("    %s %d\n", months[month], year);
        for (int i = 1; i <= 7; i++) {
            System.out.printf("%s ", days[i]);
        }
        System.out.println();

        int d = getDays(month, year);
        int currentDay = 1;

        for (int i = 0; i < 6; i++) {
            for (int j = 1; j <= 7; j++) {
                if (i == 0 && j < startDay || currentDay > d) {
                    System.out.print("   ");
                } else {
                    System.out.printf("%2d ", currentDay++);
                }
            }
            System.out.println();
        }
    }
}
