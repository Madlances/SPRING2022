package madsen;

import java.util.Vector;

public abstract class Component {

    protected String name;
    protected Component parent;

    public Component(String name, Component parent) {
        this.name = name;
        this.parent = parent;
    }

    // this one
   public abstract String getName();

   // this one
   public abstract void setName(String name);

   // this one
   public abstract int count(int count);

   // this one
   public abstract int countAll(int countAll);

   // this one
   public abstract void list(boolean list);

   // this one
   public abstract void listAll(int list);

   // this one
   public abstract Component getParent();

   // this one
   public abstract Vector<Component> getChildren();

   // this one
   public abstract void chDir(String name, boolean test);

   // this one
   public abstract void addChild(Component child);
}
