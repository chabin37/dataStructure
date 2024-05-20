package SearchTrees;

import java.util.ArrayList;

public class MyTree {
    private MyNode root;
    int size=0;
    MyTree(){root=null;}
    MyTree(Object e){
        root=new MyNode(e);
        root.setChildren(new ArrayList());
    }
    public int size(){
        return size;
    }

    public MyNode root() {return root;}
    public ArrayList<MyNode> children(MyNode v) {
        return v.children();
    }
    public boolean isExternal(MyNode v) {
       return v.children().isEmpty();
    }
    public MyNode addRoot(Object e) {
        if (root != null)
            throw new IllegalStateException("Tree already has a root");

        root = new MyNode(e);
        size = 1;
        return root;
    }

    public MyNode addNode(Object e) {
        MyNode newNode = new MyNode(e);
        root.children().add(newNode);
        size++;
        return newNode;
    }

    public MyNode addChild(MyNode v, Object e) {
        MyNode newNode = new MyNode(e);
        v.children().add(newNode);
        size++;
        return newNode;
    }

    public MyNode addChild(MyNode v, int i, Object e) {
        MyNode newNode = new MyNode(e);
        v.children().add(i, newNode);
        size++;
        return newNode;
    }

    public MyNode setChild(MyNode v, int i, Object e) {
        MyNode oldNode = v.children().get(i);
        MyNode newNode = new MyNode(e);
        v.children().set(i, newNode);
        size = size - oldNode.degree() + newNode.degree();
        return newNode;
    }

    public MyNode removeChild(MyNode v, int i) {
        MyNode removedNode = v.children().remove(i);
        size -= removedNode.degree();
        return removedNode;
    }
}
