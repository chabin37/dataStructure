// Main.java
package SearchTrees;

public class Main {
    public static void main(String[] args) {
        MyBST bst = new MyBST();

        // 1) BST 객체를 생성하고 주어진 대로 삽입 및 삭제 연산 수행
        bst.insert(6);
        bst.insert(2);
        bst.insert(9);
        bst.insert(1);
        bst.insert(4);
        bst.insert(8);
        bst.insert(9);

// 2) 메서드를 순서대로 실행하고 결과 출력
        System.out.println(bst.find(8));
        System.out.println(bst.find(3));
        System.out.println(bst.insert(3));
        System.out.println(bst.insert(7));
        System.out.println(bst.insert(9));
        System.out.println(bst.remove(1));
        System.out.println(bst.remove(4));
        System.out.println(bst.remove(6));
        System.out.println(bst.find(3));
        System.out.println(bst.find(6));
        System.out.println(bst.findAll(9));

        // 3) inOrder 메서드로 최종 BST의 모든 키 값을 출력
        System.out.print("InOrder Traversal: ");
        bst.inOrder(bst.root);
        System.out.println();
    }
}