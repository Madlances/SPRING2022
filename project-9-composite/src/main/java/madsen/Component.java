package madsen;

public abstract class Component {

    public void add(Component component) {
        throw new UnsupportedOperationException("Cannot add to the directory");
    }

    public void remove(Component component) {
        throw new UnsupportedOperationException("Cannot remove from the directory");
    }

    public String getFile() {
        throw new UnsupportedOperationException("Cannot get file");
    }

    public String getFolder() {
        throw new UnsupportedOperationException("Cannot get folder");
    }

    public void print() {
        throw new UnsupportedOperationException("Cannot print");
    }

    public void list() {}

    public void listall() {}

    public void chdir() {}

    public void up() {}

    public void count() {}

    public void countall() {}

    public void quit() {}
}
