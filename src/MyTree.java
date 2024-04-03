import java.util.ArrayList;

public class MyTree {
    private MyNode root;
    MyTree(){root=null;}
    MyTree(Object e){
        root=new MyNode(e);
        root.setChildren(new ArrayList());
    }
    public int size(){}//자신을 포함한 모든 자식 노드의 갯수(트리 크기)
    public MyNode root() {return root;}
    public ArrayList children(MyNode v) {
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
        return mn;
    }
    public MyNode addNode(Object e) {
        MyNode mn=new MyNode(e);
        this.root.children().add(mn);
        return root;
    }
    public MyNode addChild(MyNode v, Object e) {}
    public MyNode addChild(MyNode v, int i, Object e) {}
    public MyNode setChild(MyNode v, int i, Object e) {}
    public MyNode removeChild(MyNode v, int i) {}
}
