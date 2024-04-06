package BinaryTrees;

import java.util.ArrayList;

public class MyTree {
    private MyNode root;
    static int size=1;
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
        MyNode mn=new MyNode(e);
        var arr=new ArrayList();
        arr.add(new MyNode(this.root.element()));
        mn.setChildren(arr);
        this.root=mn;
        size+=1;
        return mn;
    }
    public MyNode addNode(Object e) {
        MyNode mn=new MyNode(e);
        this.root.children().add(mn);
        size+=1;
        return root;
    }
    public MyNode addChild(MyNode v, Object e) {
        v.children().add(new MyNode(e));
        size+=1;
        return v;
    }
    public MyNode addChild(MyNode v, int i, Object e) {
        v.children().add(i,new MyNode(e));
        size+=1;
        return v;
    }
    public MyNode setChild(MyNode v, int i, Object e) {
        v.children().set(i,new MyNode(e));
        size+=1;
        return v;
    }
    public MyNode removeChild(MyNode v, int i) {
        v.children().remove(i);
        size+=1;
        return v;
    }
}
