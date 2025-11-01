public abstract class Game {
    public final void play() {
        initialize();
        startPlay();
        endPlay();
        displayWinner();
    }

    protected abstract void initialize();

    protected abstract void startPlay();

    protected abstract void endPlay();

    protected abstract void displayWinner();
}