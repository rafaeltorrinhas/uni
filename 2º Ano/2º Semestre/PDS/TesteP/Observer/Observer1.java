public class Observer1 implements Observer {
    public double temp;

    public void update(double temp) {
        this.temp = temp;
    }

    public void show() {
        System.out.println("Observer1: " + temp);
    }

}
