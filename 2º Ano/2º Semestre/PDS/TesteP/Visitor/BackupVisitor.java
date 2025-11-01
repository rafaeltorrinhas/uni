public class BackupVisitor implements Visitor {

    public void visit(File file) {
        System.out.println("Backing up file: " + file.getName());
    }

    public void visit(Folder folder) {
        System.out.println("Backing up folder: " + folder.getName());
    }
}
