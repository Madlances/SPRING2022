package madsen;

import java.util.ArrayList;

/**
 * This class inherits from Component overriding the abstract functions 
 */

public class Leaf extends Component{
    /**
     * This is the constructor that sets the name and parent
     * @param name
     * @param parent
     */
    public Leaf(String name, Composite parent) {
        super(name, parent);
    }

    /**
     * this returns 1 as the count
     * @param proceed
     */
    @Override
    public int count(Boolean proceed) {
        return 1;
    }

    /**
     * this returns 1 as countall
     */
    @Override
    public int countAll() {
        return 1;
    }

    /**
     * this lists the leafs
     * @param proceed
     */
    @Override
    public void list(Boolean proceed) {
        System.out.print(name + " ");
    }

    /**
     * this prints out the listall
     * @param depth
     */
    @Override
    public void listAll(Integer depth) {
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < App.INDENT_WIDTH; j++) {
                System.out.print(" ");
            }
        }
        System.out.println(this.getName());
    }

    /**
     * This will throw an error initially
     */
    @Override
    public ArrayList<Component> getChildren() {
        throw new UnsupportedOperationException("Can't get children");
    }

    /**
     * This return null
     * @param name
     * @param proceed
     */
    @Override
    public Component chDir(String name, Boolean proceed) {
        return null;
    }

    /**
     * This will throw an error initially
     */
    @Override
    public void addChild(Component c) {
        throw new UnsupportedOperationException("Can't add child");
    }
}
