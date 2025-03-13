import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Operation:");

        String operation = sc.nextLine();
        String[] parts = operation.split(" ");
        String operator = parts[1];
        double num1 = Double.parseDouble(parts[0]);
        double num2 = Double.parseDouble(parts[2]);
        double total = 0;

        switch (operator) {

            case "+":
                total = num1 + num2;
                break;

            case "-":
                total = num1 - num2;
                break;

            case "*":
                total = num1 * num2;
                break;

            case "/":
                total = num1 / num2;
                break;

            default:
                System.out.println("Operação inválida.");
                break;

        }
        System.out.printf("%f %s %f = %f", num1, operator, num2, total);
        sc.close();
    }

}
