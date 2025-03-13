import java.util.*;

public class Ex102 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    HashMap<String, Double> values = new HashMap<>();
    while (true) {
      System.out.println("Operação: ");
      String operation = sc.nextLine();
      String[] parts = operation.split(" ");
      double total = calculate(values, parts);
      System.out.printf("Total: %f \n", total);
    }

  }

  public static double calculate(HashMap<String, Double> values, String[] parts) {

    double total;
    if (values.get(parts[0]) != null) {
      total = values.get(parts[0]);
    } else {
      total = 0;
    }

    if (parts.length <= 1) {
      return total;
    }

    double value2;
    String op = parts[1];
    String num1 = parts[0];
    String num2 = parts[2];

    switch (op) {
      case "=":
        if (Arrays.copyOfRange(parts, 2, parts.length).length > 1) {
          values.put(num1, calculate(values, Arrays.copyOfRange(parts, 2, parts.length)));
        } else {
          values.put(num1, Double.parseDouble(num2));
        }
        break;
      case "+":
        if (values.get(parts[2]) != null) {
          value2 = values.get(parts[2]);
        } else {
          value2 = Double.parseDouble(num2);
        }
        total += value2;
        parts[2] = Double.toString(total);
        // System.out.println(total);

        if (Arrays.copyOfRange(parts, 2, parts.length).length <= 1) {
          return total;
        }

        total = calculate(values, Arrays.copyOfRange(parts, 2, parts.length));

        break;
      case "-":
        if (values.get(parts[2]) != null) {
          value2 = values.get(parts[0]);
        } else {
          value2 = Double.parseDouble(num2);
        }
        total -= value2;
        parts[2] = Double.toString(total);
        // System.out.println(total);

        if (Arrays.copyOfRange(parts, 2, parts.length).length <= 1) {
          return total;
        }
        total = calculate(values, Arrays.copyOfRange(parts, 2, parts.length));
        break;
      case "*":
        if (values.get(parts[2]) != null) {
          value2 = values.get(parts[0]);
        } else {
          value2 = Double.parseDouble(num2);
        }
        total *= value2;
        parts[2] = Double.toString(total);
        // System.out.println(total);

        if (Arrays.copyOfRange(parts, 2, parts.length).length <= 1) {
          return total;
        }
        total = calculate(values, Arrays.copyOfRange(parts, 2, parts.length));
        break;
      case "/":
        if (values.get(parts[2]) != null) {
          value2 = values.get(parts[0]);
        } else {
          value2 = Double.parseDouble(num2);
        }
        total /= value2;
        parts[2] = Double.toString(total);
        // System.out.println(total);

        if (Arrays.copyOfRange(parts, 2, parts.length).length <= 1) {
          return total;
        }
        total = calculate(values, Arrays.copyOfRange(parts, 2, parts.length));
        break;

      default:
        System.out.println("Invalid operation.");
        break;
    }
    return total;
  }

}
