package utility;

public class Misc {

    public static boolean isPrime(int num) {
        boolean flag = true;

        if (num > 1) {
            for (int c = 2; c < num; c++){
                if (num % c == 0) {
                    flag = false;
                    break;
                }
            } 
        }
        return flag;
    }



    public static boolean isLeap(int year) {
        boolean flag = false;
        
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            flag = true;
        }

        return flag;
    }


    public static void printCentered(String text, int width){
        int padding = (width - text.length()) / 2;
        System.out.printf("%" + (text.length() + padding) + "s\n", text);
    }


    public static int randomInt(int a,int b) {
        double random = (double) Math.random();
        int value = (int) (1 + random * ((b+1) - a));
        return value;
    }

    public static double randomDouble(double a,double b) {
        double random = (double) Math.random();
        double value = (1 + random * ((b+1) - a));
        return value;
    }

    public static String spaceFix(String text) {
        return text.replaceAll("( )+", " ");
    }



    public static int monthDays(int month, int year) {
        int dias;
        
        int[] diaMeses = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};

        dias = diaMeses[month];
        
        if (dias == 28 && Misc.isLeap(year)) {
            dias ++;
        }

        return dias;
    }


    public static int[] today() {
        int[] today = new int[3];
        java.util.Calendar cal = java.util.Calendar.getInstance();
        today[0] = cal.get(java.util.Calendar.DAY_OF_MONTH);
        today[1] = cal.get(java.util.Calendar.MONTH) + 1;
        today[2] = cal.get(java.util.Calendar.YEAR);
        return today;
    }
}





