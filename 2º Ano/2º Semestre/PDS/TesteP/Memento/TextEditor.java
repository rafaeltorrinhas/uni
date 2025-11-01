
public class TextEditor {
    public String currentText;

    public void type(String text) {
        this.currentText = text;
        System.out.println("Text: " + text);
    }

    public Memento save() {
        System.out.println("State saved.");
        return new Memento(currentText);

    }

    public void restore(Memento m) {
        currentText = m.getCurrState();
        System.out.println("State restored to: " + currentText);
    }

    public void show() {
        System.out.println("Current text: " + currentText);
    }
}