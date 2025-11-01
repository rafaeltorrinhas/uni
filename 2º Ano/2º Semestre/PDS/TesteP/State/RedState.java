public class RedState implements State {

    @Override
    public void nextState(TrafficLight t) {
        t.setState(new GreenState());
    }

    @Override
    public void display() {
        System.out.println("Current state: Red");
    }

}
