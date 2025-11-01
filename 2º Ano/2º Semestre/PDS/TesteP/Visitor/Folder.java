import java.util.*;

public class Folder implements FileSystemElement {
    public List<File> files;
    public String name;

    public Folder(String name, List<File> files) {
        this.name = name;
        this.files = files;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
