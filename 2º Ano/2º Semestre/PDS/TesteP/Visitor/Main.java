
public class Main {
    public static void main(String[] args) {
        Visitor v = new BackupVisitor();
        FileSystemElement fol = new Folder("pasta", null);
        FileSystemElement file = new File("ficheiro", 200);

        fol.accept(v);
        file.accept(v);

    }
}
