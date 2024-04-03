import java.util.ArrayList;

public class MyTree {
    private MyNode root;
    MyTree(){root=null;}
    MyTree(Object e){
        root=new MyNode(e);
        root.setChildren(new ArrayList());
    }
    public int size(){}
    public MyNode root() {}
    public ArrayList children(MyNode v) {}
    public boolean isExternal(MyNode v) {}
    public MyNode addRoot(Object e) {}
    public MyNode addNode(Object e) {}
    public MyNode addChild(MyNode v, Object e) {}
    public MyNode addChild(MyNode v, int i, Object e) {}
    public MyNode setChild(MyNode v, int i, Object e) {}
    public MyNode removeChild(MyNode v, int i) {}
}
