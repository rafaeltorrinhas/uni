public class TurnOffCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Turned Off");
    }

    @Override
    public void undo() {
        new TurnOnCommand().execute();
    }

}
