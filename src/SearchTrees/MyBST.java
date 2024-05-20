package SearchTrees;

import java.util.ArrayList;

public class MyBST extends MyBinTree{

    MyBST() { super(); }
    MyBST(Object e) { super(e); }


    private MyBinNode nextNode(MyBinNode v) {
        if (v.right() != null) {
            return minNode(v.right());
        }
        MyBinNode p = v.parent();
        while (p != null && v == p.right()) {
            v = p;
            p = p.parent();
        }
        return p;
    }private MyBinNode minNode(MyBinNode v) {
        while (v.left() != null) {
            v = v.left();
        }
        return v;
    }

    public Object find(Object k) {
        MyBinNode v = findNode(root, k);
        if (v == null) {
            return null;
        }
        return v.element();
    }
    private MyBinNode findNode(MyBinNode v, Object k) {
        if (v == null || k.equals(v.element())) {
            return v;
        }
        int compareResult = ((Comparable<Object>) k).compareTo(v.element());
        if (compareResult < 0) {
            return findNode(v.left(), k);
        } else {
            return findNode(v.right(), k);
        }
    }

    public ArrayList<Object> findAll(Object k) {
        ArrayList<Object> result = new ArrayList<>();
        findAllNodes(root, k, result);
        return result;
    }private void findAllNodes(MyBinNode v, Object k, ArrayList<Object> result) {
        if (v == null) {
            return;
        }
        int compareResult = ((Comparable<Object>) k).compareTo(v.element());
        if (compareResult < 0) {
            findAllNodes(v.left(), k, result);
        } else if (compareResult > 0) {
            findAllNodes(v.right(), k, result);
        } else {
            result.add(v.element());
            findAllNodes(v.left(), k, result);
            findAllNodes(v.right(), k, result);
        }
    }    public Object insert(Object k) {
        MyBinNode v = new MyBinNode(k);

        if (this.root == null) {
            this.root = v;
            return k;
        } else {
            return insert(root, v);
        }
    }
    private Object insert(MyBinNode n, MyBinNode k) {
        int rootKey = (int) n.element();
        int inputKey = (int) k.element();

        if (inputKey > rootKey) {
            if (n.binChildren().size() > 1 && n.binChildren().get(1) != null) { // 오른쪽 자식 노드가 존재하는 경우
                return insert(n.binChildren().get(1), k);
            } else { // 오른쪽 자식 노드가 존재하지 않는 경우
                k.parent = n;
                if (n.binChildren().size() > 1) {
                    n.binChildren().set(1, k);
                } else {
                    // 왼쪽 자식 노드가 없는 경우를 대비해 빈 자리 추가
                    if (n.binChildren().size() == 0) {
                        n.binChildren().add(null);
                    }
                    n.binChildren().add(k);
                }
            }
        } else if (inputKey < rootKey) {
            if (n.binChildren().size() > 0 && n.binChildren().get(0) != null) { // 왼쪽 자식 노드가 존재하는 경우
                return insert(n.binChildren().get(0), k);
            } else { // 왼쪽 자식 노드가 존재하지 않는 경우
                k.parent = n;
                if (n.binChildren().size() > 0) {
                    n.binChildren().set(0, k);
                } else {
                    n.binChildren().add(k);
                }
            }
        } else { // 같은 경우
            if (n.binChildren().size() < 2) { // 자식 노드가 1개 이하인 경우
                n.binChildren().add(k);
                k.parent = n;
            } else { // 자식 노드가 2개인 경우
                return insert(n.binChildren().get(0), k);
            }
        }
        return k.element().toString();
    }
    public Object remove(Object k) {
        MyBinNode v = findNode(root, k);
        if (v == null) {
            return null;
        }
        Object removedElement = v.element();
        deleteNode(v);
        return removedElement;
    }

    private void deleteNode(MyBinNode v) {
        if (v.left() == null && v.right() == null) {
            if (v == root) {
                root = null;
            } else {
                if (v.parent().left() == v) {
                    v.parent().setLeft(null);
                } else {
                    v.parent().setRight(null);
                }
            }
        } else if (v.left() == null || v.right() == null) {
            MyBinNode child = (v.left() != null) ? v.left() : v.right();
            if (v == root) {
                root = child;
                child.setParent(null);
            } else {
                if (v.parent().left() == v) {
                    v.parent().setLeft(child);
                } else {
                    v.parent().setRight(child);
                }
                child.setParent(v.parent());
            }
        } else {
            MyBinNode successor = nextNode(v);
            v.setElement(successor.element());
            deleteNode(successor);
        }
    }
    public void inOrder(MyBinNode v) {
        if (v != null) {
            inOrder(v.left());
            System.out.print(v.element() + " ");
            inOrder(v.right());
        }
    }
}
