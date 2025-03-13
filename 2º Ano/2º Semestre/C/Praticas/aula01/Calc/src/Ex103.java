import java.util.*;

public class Ex103 {
    public static void main(String[] args) {
        String str = args[1];
        String[] operation = str.strip().split(" ");
        Stack<Double> items = new Stack<>();
        int count = 0;
        for (String item : operation) {

            if (isNumeric(item)) {
                items.add(Double.parseDouble(item));
                count++;
            }
        }
        int total = 0;
        for (int j = count; j < operation.length; j++) {
            total = 1;
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
