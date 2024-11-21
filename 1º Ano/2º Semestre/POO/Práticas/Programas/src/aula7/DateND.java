package aula7;

public class DateND extends Date {
    private int daysSince2000;

    public DateND(int day, int month, int year) {
        this.daysSince2000 = (year - 2000) * 365 + (month - 1) * 30 + day - 1;
    }

    @Override
    public int getDay() {
        return this.daysSince2000 % 30 + 1;
    }

    @Override
    public int getMonth() {
        return (this.daysSince2000 / 30) % 12 + 1;
    }

    @Override
    public int getYear() {
        return this.daysSince2000 / (30 * 12) + 2000;
    }

    @Override
    public void increment() {
        this.daysSince2000++;
    }

    @Override
    public void decrement() {
        if (this.daysSince2000 > 0) {
            this.daysSince2000--;
        }
    }
}
