package aula2.java;

import java.util.Scanner;

public class ex9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduza um valor positivo N: ");
        int N = sc.nextInt();

        for (int i = N; i >= 0; i--) {
            System.out.print(i);
            if (i % 10 == 0) {
                System.out.println();
            } else {
                System.out.print(", ");
            }
        }
        sc.close();
    }
}
