package BinaryTrees;

import java.util.ArrayList;

public class MyBinNode extends MyNode{
    private MyBinNode parent;
    //element 상속받음
    private ArrayList<MyBinNode> children;
    MyBinNode(){
        super();
    }
    @Override
    public MyBinNode parent(){
        return parent;
    }
    MyBinNode(Object e){
        super(e);
    }
    public ArrayList<MyBinNode> Binchildren(){
        return this.children;
    }
    public MyBinNode left() {
        return children.get(0);
    }
    public MyBinNode right() {
        return children.get(1);
    }
    public void setLeft(MyBinNode v) {
        children.add(0,v);
    }
    public void setRight(MyBinNode v) {
        children.add(1,v);
    }
}
