public class TrafficLight {
    public State state;

    public TrafficLight(State state) {
        this.state = state;
    }

    public void nextState() {
        this.state.nextState(this);
    }

    public void setState(State s) {
        this.state = s;
    }

    public State getState() {
        return state;
    }

}