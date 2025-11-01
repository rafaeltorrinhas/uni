public class Handball extends Game {

    @Override
    protected void initialize() {
        System.out.println("Handball Game initialized");
    }

    @Override
    protected void startPlay() {
        System.out.println("Handball Game started");
    }

    @Override
    protected void endPlay() {
        System.out.println("Handball Game ended");
    }

    @Override
    protected void displayWinner() {
        System.out.println("Handball game winner is team 2");
    }

}