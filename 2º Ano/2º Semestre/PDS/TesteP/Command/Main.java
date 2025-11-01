public class Main {
    public static void main(String[] args) {
        Command offTv = new TurnOffCommand();
        Command onTv = new TurnOnCommand();

        onTv.execute();
        offTv.execute();
        offTv.undo();
        onTv.undo();
    }
}
