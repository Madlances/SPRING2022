package madsen;

import java.util.ArrayList;

/**
 * This class will be the abstract parent class of Composite and Leaf, using the Composite pattern,
 * the subclasses will inherit the methods below.
 */

public abstract class Component {

    protected String name;
    protected Composite parent;

    /**
     * This is the constructor that sets teh name and parent
     * @param name
     * @param parent
     */
    public Component(String name, Composite parent) {
        this.name = name;
        this.parent = parent;
    }
    
    /**
     * This is to get the name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * This is to set the name
     * @param newName
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * this will print the number of files (not directories) in the current directory
     * @param proceed
     * @return
     */
    public abstract int count(Boolean proceed);

    /**
     * this will prints the number of files (not directories) in the subtree starting from the current node
     * @return
     */
    public abstract int countAll();

    /**
     * this will list the entries in the current directory horizontally
     * @param proceed
     */
    public abstract void list(Boolean proceed);

    /**
     * this will prints a hierarchical listing of the current directory subtree (starting from the current node)
     * @param depth
     */
    public abstract void listAll(Integer depth);

    /**
     * will return the parent
     * @return
     */
    public Composite getParent() {
        return this.parent;
    };

    /**
     * this will get the children of the directory
     * @return
     */
    public abstract ArrayList<Component> getChildren();

    /**
     * This will change the directory to the named, adjacent subdirectory
     * @param name
     * @param proceed
     * @return
     */
    public abstract Component chDir(String name, Boolean proceed);

    /**
     * will add the child to the array list to be able to return it
     * @param child
     */
    public abstract void addChild(Component child);
}
