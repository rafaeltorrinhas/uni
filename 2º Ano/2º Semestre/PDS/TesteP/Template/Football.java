public class Football extends Game {

    @Override
    protected void initialize() {
        System.out.println("Football Game initialized");
    }

    @Override
    protected void startPlay() {
        System.out.println("Football Game started");
   }

    @Override
    protected void endPlay() {
        System.out.println("Football Game ended");
   }

    @Override
    protected void displayWinner() {
        System.out.println("Football game winner is team 1");    
    }

}
