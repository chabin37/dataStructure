package BinaryTrees;

import java.util.ArrayList;

public class MyBinNode extends MyNode{
    private MyBinNode parent;
    //element 상속받음
    private ArrayList<MyBinNode> children;
    @Override
    public MyBinNode parent(){
        return parent;
    }
    MyBinNode() {
        super();
        this.children = new ArrayList<>();
    }
    public int size() {
        int leftSize = (left() != null) ? left().size() : 0;
        int rightSize = (right() != null) ? right().size() : 0;
        return 1 + leftSize + rightSize;
    }
    MyBinNode(Object e) {
        super(e);
        this.children = new ArrayList<>();
    }

    public MyBinNode left() {
        if (children.isEmpty()) return null;
        return children.get(0);
    }

    public MyBinNode right() {
        if (children.size() < 2) return null;
        return children.get(1);
    }

    public void setLeft(MyBinNode v) {
        if (children.isEmpty())
            children.add(v);
        else
            children.set(0, v);
    }

    public void setRight(MyBinNode v) {
        if (children.size() < 2)
            children.add(v);
        else
            children.set(1, v);
    }public void setParent(MyBinNode parent) {
        this.parent = parent;
    }
}
