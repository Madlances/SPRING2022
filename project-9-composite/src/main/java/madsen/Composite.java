package madsen;

import java.util.ArrayList;

public class Composite extends Component{
    private ArrayList<Component> items = new ArrayList<>();
    private String fileName;
    private String folderName;

    public Composite(String fileName, String folderName) {
        this.fileName = fileName;
        this.folderName = folderName;
    }

    @Override
    public String getFile() {
        return fileName;
    }

    @Override
    public String getFolder() {
        return folderName;
    }

    @Override
    public void print() {}

    @Override
    public void add(Component component) {}

    @Override
    public void remove(Component component) {}
}
