package madsen;

import java.util.ArrayList;

/**
 * This class inherits from Component overriding the abstract functions 
 */

public class Composite extends Component{
    ArrayList<Component> children = new ArrayList<>();

    /**
     * this is setting the name and parent
     * @param name
     * @param parent
     */
    public Composite(String name, Composite parent) {
        super(name, parent);
    }

    /**
     * This will return the count
     */
    @Override
    public int count(Boolean proceed) {
        if (proceed) {
            Integer count = 0;
            for (Component child : this.getChildren()) {
                count += child.count(false);
            }
            return count;
        } else {
            return 0;
        }
    }

    /**
     * This will return the countall
     */
    @Override
    public int countAll() {
        Integer count = 0;
        for (Component child : this.getChildren()) {
            count += child.countAll();
        }
        return count;
    }

    /**
     * This will list the children
     * @param proceed
     */
    @Override
    public void list(Boolean proceed) {
        if (proceed) {
            for (Component child: this.getChildren()) {
                child.list(false);
            }
            System.out.println();
        } else {
            System.out.print(name + " ");
        }
    }

    /**
     * this will return the listall
     * @param depth
     */
    @Override
    public void listAll(Integer depth) {
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < App.INDENT_WIDTH; j++) {
                System.out.print(" ");
            }
        }
        System.out.println(this.getName() + ":");
        for (Component child : this.getChildren()) {
            child.listAll(depth + 1);
        }
    }

    /**
     * This will return the children
     */
    @Override
    public ArrayList<Component> getChildren() {
        return children;
    }

    /**
     * this will set the chDir
     */
    @Override
    public Component chDir(String name, Boolean proceed) {
        if (proceed) {
            for (Component child : this.getChildren()) {
                if (child.getName().equals(name)) {
                    return child.chDir(name, false);
                }
            }
            return null;
        } else {
            return this;
        }
    }

    /**
     * This will add the children to the array at the beginning
     */
    @Override
    public void addChild(Component c) {
        children.add(c);
    }
}
