public class GreenState implements State {

    @Override
    public void nextState(TrafficLight t) {
        t.setState(new YellowState());
    }

    @Override
    public void display() {
        System.out.println("Current state: Green");
    }
    
}
