import java.util.ArrayList;

public class MyTree {
    private MyNode root;
    MyTree(){root=null;}
    MyTree(Object e){
        root=new MyNode(e);
        root.setChildren(new ArrayList());
    }
    public int size(){
        int result=1;
        result+=size(this.root);
        return result;
    }
    private int size(MyNode v){
        int temp=1;
        for(MyNode m:v.children()){//children이 없을경우, 1만 반환=>총 size 알 수 있음
            temp+=size(m);
        }
        return temp;
    }
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
    public MyNode addChild(MyNode v, Object e) {
        v.children().add(new MyNode(e));
        return v;
    }
    public MyNode addChild(MyNode v, int i, Object e) {
        v.children().add(i,new MyNode(e));
        return v;
    }
    public MyNode setChild(MyNode v, int i, Object e) {
        v.children().set(i,new MyNode(e));
        return v;
    }
    public MyNode removeChild(MyNode v, int i) {
        v.children().remove(i);
        return v;
    }
}
