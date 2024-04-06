package Trees;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyTree tree=new MyTree("Computers'R Us");
        tree.addNode("Sales");
        tree.addNode("Manufacturing");
        tree.addNode("R&D");
        ArrayList<MyNode>arr =new ArrayList<>();
        ArrayList<MyNode>arr2 =new ArrayList<>();
        ArrayList<MyNode>arr3 =new ArrayList<>();
        arr.add(new MyNode("US"));
        arr.add(new MyNode("International"));
        tree.root().children().get(0).setChildren(arr);

        arr2.add(new MyNode("Laptops"));
        arr2.add(new MyNode("Desktops"));
        tree.root().children().get(1).setChildren(arr2);

        arr3.add(new MyNode("Europe"));
        arr3.add(new MyNode("Asia"));
        arr3.add(new MyNode("Canada"));
        tree.root().children().get(0).children().get(1).setChildren(arr3);

        //실습 3
        System.out.println("[Level0]");
        System.out.println(tree.root().element()+"\n");
        System.out.println("[Level1]");
        System.out.println(tree.root().children().get(0).element().toString()+", "+tree.root().children().get(1).element().toString()+", "+tree.root().children().get(2).element().toString()+"\n");
        System.out.println("[Level2]");
        System.out.println(tree.root().children().get(0).children().get(0).element()+", "+tree.root().children().get(0).children().get(1).element()+", "+tree.root().children().get(1).children().get(0).element()+", "+tree.root().children().get(1).children().get(1).element()+"\n");
        System.out.println("[Level3]");
        System.out.println(tree.root().children().get(0).children().get(1).children().get(0).element()+", "+tree.root().children().get(0).children().get(1).children().get(1).element()+", "+tree.root().children().get(0).children().get(1).children().get(2).element()+"\n");
        System.out.println("*Tree size=Total "+tree.size()+" Nodes");
        //실습 4-1
        MyTree tree2=new MyTree("Make Money Fast!");
        tree2.addNode("1. Motivation");
        tree2.addNode("2. Methods");
        tree2.addNode("3. Reference");
        ArrayList<MyNode> arr01=new ArrayList<>();
        ArrayList<MyNode> arr02=new ArrayList<>();
        arr01.add(new MyNode("1.1 Greed"));
        arr01.add(new MyNode("1.2 Avidity"));
        arr02.add(new MyNode("2.1 Stock Fraud"));
        arr02.add(new MyNode("2.2 Ponzi Scheme"));
        arr02.add(new MyNode("2.3 Bank Robbery"));
        tree2.root().children().get(0).setChildren(arr01);
        tree2.root().children().get(1).setChildren(arr02);
        System.out.println(tree2.root().element());
        for (int i = 0; i < tree2.root().children().size(); i++) {
            System.out.println("\t"+(i+1)+". "+tree2.root().children().get(i).element().toString());
            int temp=tree2.root().children().get(i).children().size();
            for (int j = 0; j < temp; j++) {
                System.out.println("\t\t"+(i+1)+"."+(j+1)+" "+tree2.root().children().get(i).children().get(j).element().toString());
            }
        }
        //실습 4-2
    }
}