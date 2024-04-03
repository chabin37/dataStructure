import java.util.ArrayList;

public class MyNode {
    private Object element;
    private MyNode parent;
    private ArrayList children;

    public MyNode() {
        element=null;
        parent=null;
        children=null;
    }
    MyNode(Object e){element=e;}
    public Object element(){return element;}
    public MyNode parent(){return parent;}
    public ArrayList children(){return children;}
    public int degree(){return this.children.size();}
    public void setElement(Object e){this.element=e;}
    public void setParent(MyNode p){this.parent=p;}
    public void setChildren(ArrayList c){this.children=c;}
}
