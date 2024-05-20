// Main.java
package BinaryTrees;

public class Main {
    public static void main(String[] args) {
        // 이진 트리 생성
        MyBinTree tree = new MyBinTree("A");

        // 노드 추가
        MyBinNode root = tree.root();
        MyBinNode nodeB = tree.insertLeft(root, "B");
        MyBinNode nodeC = tree.insertRight(root, "C");
        MyBinNode nodeD = tree.insertLeft(nodeB, "D");
        MyBinNode nodeE = tree.insertRight(nodeB, "E");
        MyBinNode nodeF = tree.insertLeft(nodeC, "F");
        MyBinNode nodeG = tree.insertRight(nodeC, "G");
        // 트리 정보 출력
        System.out.println("트리 크기: " + tree.size());
        System.out.println("루트 노드: " + tree.root().element());
        System.out.println("루트의 왼쪽 자식: " + tree.left(root).element());
        System.out.println("루트의 오른쪽 자식: " + tree.right(root).element());

        // 노드 정보 출력
        System.out.println("노드 B의 왼쪽 자식: " + tree.left(nodeB).element());
        System.out.println("노드 B의 오른쪽 자식: " + tree.right(nodeB).element());
        System.out.println("노드 C의 왼쪽 자식: " + tree.left(nodeC).element());
        System.out.println("노드 C의 오른쪽 자식: " + tree.right(nodeC).element());

        // 노드 타입 확인
        System.out.println("노드 A는 루트인가? " + tree.isRoot(root));
        System.out.println("노드 B는 내부 노드인가? " + tree.isInternal(nodeB));
        System.out.println("노드 D는 외부 노드인가? " + tree.isExternal(nodeD));

        // 노드 값 변경
        System.out.println("노드 D의 원래 값: " + nodeD.element());
        tree.replace(nodeD, "D2");
        System.out.println("노드 D의 변경된 값: " + nodeD.element());

        // 노드 제거
        try {
            tree.remove(nodeE);
            System.out.println("노드 E 제거 후 트리 크기: " + tree.size());
        } catch (TwoChildrenException e) {
            System.out.println("노드 E는 두 개의 자식을 가지고 있어 제거할 수 없습니다.");
        }

        // 서브트리 추가
        MyBinTree subTree = new MyBinTree("X");
        MyBinNode subRoot = subTree.root();
        subTree.insertLeft(subRoot, "Y");
        subTree.insertRight(subRoot, "Z");

        try {
            tree.attach(nodeD, subTree.root(), null);
            System.out.println("서브트리 추가 후 트리 크기: " + tree.size());
        } catch (NotExternalException e) {
            System.out.println("노드 D는 외부 노드가 아니어서 서브트리를 추가할 수 없습니다.");
        }

        // 순회
        System.out.println("전위 순회:");
        preorder(tree, root);
        System.out.println();

        System.out.println("중위 순회:");
        inorder(tree, root);
        System.out.println();

        System.out.println("후위 순회:");
        postorder(tree, root);
        System.out.println();
    }

    // 전위 순회
    public static void preorder(MyBinTree tree, MyBinNode node) {
        if (node == null) return;
        System.out.print(node.element() + " ");
        preorder(tree, tree.left(node));
        preorder(tree, tree.right(node));
    }

    // 중위 순회
    public static void inorder(MyBinTree tree, MyBinNode node) {
        if (node == null) return;
        inorder(tree, tree.left(node));
        System.out.print(node.element() + " ");
        inorder(tree, tree.right(node));
    }

    // 후위 순회
    public static void postorder(MyBinTree tree, MyBinNode node) {
        if (node == null) return;
        postorder(tree, tree.left(node));
        postorder(tree, tree.right(node));
        System.out.print(node.element() + " ");
    }
}