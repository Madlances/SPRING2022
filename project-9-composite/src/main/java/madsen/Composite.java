package madsen;

import java.util.Vector;

public class Composite extends Component{
    public String name;
    public Component parent;
    Vector<Component> v = new Vector<>();

    public Composite(String name, Component parent) {
        super(name, parent);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String n) {
        name = n;
    }

    @Override
    public int count(int count) {
        return count;
    }

    @Override
    public int countAll(int countAll) {
        return countAll;
    }

    @Override
    public void list(boolean list) {
        for (Component c: v) {

        }
        System.out.println(name + "");
    }

    @Override
    public void listAll(int indent) {
        System.out.println(name);
    }

    @Override
    public Component getParent() {
        return parent;
    }

    @Override
    public Vector<Component> getChildren() {
        return v;
    }

    @Override
    public void chDir(String name, boolean test) {
        return;
    }

    @Override
    public void addChild(Component c) {
        v.add(c);
    }
}
