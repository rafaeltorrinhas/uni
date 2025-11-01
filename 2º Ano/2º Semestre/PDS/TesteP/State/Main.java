public class Main {
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight(new GreenState());

        t.getState().display();
        t.nextState();
        t.getState().display();
        t.nextState();
        t.getState().display();
    }
}
