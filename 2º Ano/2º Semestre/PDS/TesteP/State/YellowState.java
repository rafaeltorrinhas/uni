public class YellowState implements State {

    @Override
    public void nextState(TrafficLight t) {
        t.setState(new RedState());
    }

    @Override
    public void display() {
        System.out.println("Current state: Yellow");
    }

}
