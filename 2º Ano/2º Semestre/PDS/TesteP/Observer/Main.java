public class Main {
    public static void main(String[] args) {
        WeatherStation w = new WeatherStation(10);
        Observer o1 = new Observer1();
        Observer o2 = new Observer2();

        w.attach(o1);
        w.changeTemp(10);
        w.setState();

        o1.show();

        w.attach(o2);

        w.changeTemp(20);
        o2.show();
        w.setState();
        o1.show();
        o2.show();

        WeatherStation w2 = new WeatherStation(15);
        w2.attach(o1);
        w2.setState();
        o1.show();

    }
}
