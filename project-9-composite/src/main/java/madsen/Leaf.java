package madsen;

public class Leaf extends Component{
    private final String fileName;
    private final String folderName;

    public Leaf(String fileName, String folderName) {
        this.fileName = fileName;
        this.folderName = folderName;
    }

    @Override
    public String getFile() {
        return this.fileName;
    }

    @Override 
    public String getFolder() {
        return this.folderName;
    }

    @Override
    public void print() {}
}
