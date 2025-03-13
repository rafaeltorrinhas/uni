import java.io.*;
import java.util.*;

public class Ex104 {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<Integer, String> numbers = getNumbers("numbers.txt");
        Scanner sc = new Scanner(System.in);
        String phrase = sc.nextLine();
        String[] items = phrase.strip().split("[ \\-]");

        for (String item : items) {
            int value = getValue(item, numbers);
            System.out.printf("%d ", value);
        }
        System.out.println("\n");
        sc.close();

    }

    public static HashMap<Integer, String> getNumbers(String filename) throws FileNotFoundException {
        HashMap<Integer, String> numbers = new HashMap<>();
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] line_strip = line.strip().split("-");
            numbers.put(Integer.parseInt(line_strip[0].strip()), line_strip[1].strip());
        }
        sc.close();
        return numbers;

    }

    public static int getValue(String value, HashMap<Integer, String> map) {

        for (int key : map.keySet()) {
            if (map.get(key).equals(value)) {
                return key;
            }
        }
        return 0;
    }
}
