public class TurnOnCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Turned On");
    }

    @Override
    public void undo() {
        new TurnOffCommand().execute();
    }

}
