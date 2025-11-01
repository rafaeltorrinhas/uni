public class Observer2 implements Observer {
    public double temp;

    public void update(double temp) {
        this.temp = temp;
    }

    public void show() {
        System.out.println("Observer2: " + temp);
    }

}
