package BinaryTrees;

public class MyBinTree extends MyTree{
    private MyBinNode root;

    MyBinTree() { this.root=null; }
    MyBinTree(Object e) {
        this.root = new MyBinNode(e);
    }
    public Boolean isEmpty() {
        return root == null;
    }
    public boolean isRoot(MyBinNode v) {
        return v.parent()==null;
    }
    public boolean isInternal(MyBinNode v) {
        return (v.left() != null || v.right() != null);
    }

    public boolean isExternal(MyBinNode v) {
        return (v.left() == null && v.right() == null);
    }

    public MyBinNode root() {
        return root;
    }

    public MyBinNode parent(MyBinNode v) {
        return (v == null ? null : v.parent());
    }
    public MyBinNode left(MyBinNode v) {
        return (v == null ? null : v.left());
    }

    public MyBinNode right(MyBinNode v) {
        return (v == null ? null : v.right());
    }

    public boolean hasLeft(MyBinNode v) {
        return (v.left() != null);
    }

    public boolean hasRight(MyBinNode v) {
        return (v.right() != null);
    }
    public MyBinNode addRoot(Object e) {
        var v=new MyBinNode(e);
        this.root=v;
        return this.root;
    }
    public MyBinNode insertLeft(MyBinNode v, Object e) {
        if(v.Binchildren().size()==0){
            v.setLeft(new MyBinNode(e));
        }
        else{
            v.Binchildren().add(new MyBinNode(e));
        }
        return v;
    }
    public MyBinNode insertRight(MyBinNode v, Object e) {
        if(v.Binchildren().size()==0){
            v.setLeft(new MyBinNode(e));
        }
        else{
            v.Binchildren().add(null);
            v.Binchildren().add(new MyBinNode(e));
        }
        return v;
    }
    public Object replace(MyBinNode v, Object e) {
        Object temp = v.element();
        v.setElement(e);
        return temp;
    }

    public MyBinNode remove(MyBinNode v) throws TwoChildrenException {
        if (v.left() != null && v.right() != null)
            throw new TwoChildrenException("Node has two children");
        return null;
    }

    public void attach(MyBinNode v, MyBinNode t1, MyBinNode t2) throws NotExternalException {
        if (!isExternal(v)) throw new NotExternalException("Node is not external");
    }
}
