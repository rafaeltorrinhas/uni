public class Caretaker {

    public static void main(String[] args) {

        TextEditor editor = new TextEditor();

        editor.type("Hello, world!");
        Memento saved = editor.save();

        editor.type("Oops, I made a mistake.");
        editor.show();

        editor.restore(saved);
        editor.show();
    }

}
