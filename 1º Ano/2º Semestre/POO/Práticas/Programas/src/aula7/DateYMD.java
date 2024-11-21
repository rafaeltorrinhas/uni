package aula7;

public class DateYMD extends Date {
    int day, month, year;

    public DateYMD(int newDay, int newMonth, int newYear) {
        this.day = newDay;
        this.month = newMonth;
        this.year = newYear;
    }

    public static boolean validMonth(int month) {
        if (month <= 0 || month > 12) {
            return false;
        } else {
            return true;
        }
    }

    public static int monthDays(int month, int year) {
        if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                return 29;
            } else {
                return 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    public static boolean leapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return false;
        } else {
            return true;
        }

    }

    public static boolean valid(int day, int month, int year) {

        return validMonth(month) && day >= 1 && day <= monthDays(month, year);
    }

    public void set(int day, int month, int year) {
        if (valid(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            System.out.println("Invalid date. Please try again.");
        }
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public void increment() {
        this.day++;
        if (this.day > monthDays(this.month, this.year)) {
            this.day = 1;
            this.month++;
            if (this.month > 12) {
                this.month = 1;
                this.year++;
            }
        }
    }

    public void decrement() {
        this.day--;
        if (this.day < 1) {
            this.day = monthDays(this.month, this.year);
            this.month--;
            if (this.month < 1) {
                this.month = 12;
                this.year--;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", this.year, this.month, this.day);
    }
}