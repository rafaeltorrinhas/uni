import java.io.*;
import java.util.*;

public class Ex105 {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<Integer, String> numbers = getNumbers("numbers.txt");
        Scanner sc = new Scanner(System.in);
        String phrase = sc.nextLine();
        String[] items = phrase.strip().split("\\band\\b|[ \\-]");
        ArrayList<Integer> values = new ArrayList<>();
        for (String item : items) {
            int value = getValue(item, numbers);
            values.add(value);
        }
        int total = 0;
        int acum = 0;

        for (int i = 0; i < values.size(); i++) {
            int num = values.get(i);
            if (num <= acum) {
                total += acum;
                acum = 0;
            }

            if (acum != 0 && num > acum) {
                acum *= num;
            } else {
                acum = num;
            }
        }
        total += acum;

        System.out.println(total + "\n");
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
