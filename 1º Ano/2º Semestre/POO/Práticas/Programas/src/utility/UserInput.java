package utility;
import java.util.InputMismatchException;
import java.util.Scanner;

//Input com Validação
public class UserInput {
    static Scanner input = new Scanner(System.in);
    

    // Double
    public static double getDouble(String texto) {
        double num;

        while (true) {
            System.out.print(texto + ": ");

            try{
                num = input.nextDouble();
                return num;
                
            } catch (InputMismatchException e) {
                System.out.println("Valor Inválido.");
                input.next();
            }
        }

    }


    // PositiveDouble
    public static double getPositiveDouble(String texto) {
        double num;

        while (true) {
            System.out.print(texto + ": ");

            try{
                num = input.nextDouble();
                if (num > 0) {
                    return num;
                } else {
                    System.out.println("Valor Inválido.");
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Valor Inválido.");
                input.next();
            }
        }
    }






    
    // Integer
    public static int getInt(String texto) {
        int num;

        while (true) {
            System.out.print(texto + ": ");
            
            try {
                num = input.nextInt();
                return num;

            } catch (InputMismatchException e) {
                System.out.println("Valor Inválido.");
                input.next();
            }
        }        
    }


    // Integer Between
    public static int getIntBetween(String texto, int a, int b) {
        int num;

        do {
            num = getInt(texto);
        } while (num < a || num > b);

        return num;
    }








    // Input String
    public static String getString(String texto) {
        System.out.print(texto + ": ");
        input.nextLine(); // Consume the remaining newline character
        return input.nextLine();
    }
}

