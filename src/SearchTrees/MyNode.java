package SearchTrees;

import java.util.ArrayList;

public class MyNode {
    private Object element;
    private MyNode parent;
    private ArrayList<MyNode> children;
    MyNode() {
        this.element = null;
        this.parent = null;
        this.children = new ArrayList<MyNode>();
    }
    MyNode(Object e) {
        this.element = e;
        this.parent = null;
        this.children = new ArrayList<MyNode>();
    }
    public Object element() {
        return this.element;
    }
    public MyNode parent() {
        return this.parent;
    }
    public ArrayList<MyNode> children() {
        return this.children;
    }
    public int degree() {
        return this.children.size();
    }
    public void setElement(Object e) {
        this.element = e;
    }
    public void setParent(MyNode p) {
        this.parent = p;
    }
    public void setChildren(ArrayList<MyNode> c) {
        this.children = c;
    }
}
