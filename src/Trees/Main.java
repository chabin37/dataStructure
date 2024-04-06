package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        System.out.println();
        System.out.println();
        //실습 4-1
        MyTree tree2=new MyTree("Make Money Fast!");
        tree2.addNode("1. Motivation");
        tree2.addNode("2. Methods");
        tree2.addNode("Reference");
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
            System.out.println("\t"+tree2.root().children().get(i).element().toString());
            int temp=tree2.root().children().get(i).children().size();
            for (int j = 0; j < temp; j++) {
                System.out.println("\t\t"+tree2.root().children().get(i).children().get(j).element().toString());
            }
        }
        System.out.println();
        System.out.println();
        //실습 4-2
        MyTree tree3=new MyTree("cs16/");
        tree3.addNode("homeworks/");
        tree3.addNode("programs/");
        tree3.addNode("todo.txt(1K)");
        ArrayList<MyNode> arr001=new ArrayList<>();
        ArrayList<MyNode> arr002=new ArrayList<>();
        arr001.add(new MyNode("h1c.doc(3K)"));
        arr001.add(new MyNode("h1nc.doc(2K)"));
        arr002.add(new MyNode("DDR.java(10K)"));
        arr002.add(new MyNode("Stocks.java(25K)"));
        arr002.add(new MyNode("Robot.java(20K)"));
        tree3.root().children().get(0).setChildren(arr001);
        tree3.root().children().get(1).setChildren(arr002);
        Pattern pattern=Pattern.compile("\\((.*?)\\)");
        ArrayList<Integer> intarr=new ArrayList<>();
        Map<String,Integer> tempMap=new HashMap<>();
        for (int i = 0; i < tree3.root().children().size(); i++) {
            if (tree3.isExternal(tree3.root().children().get(i))){//깊이1이 엣지 일때
                String stringTemp = tree3.root().children().get(i).element().toString();
                Matcher matcher=pattern.matcher(stringTemp);
                matcher.find();//matcher.group하기위한 메서드
                String numberString=matcher.group(1);
                String numberOnly= numberString.replaceAll("[^0-9]", "");
                int num=Integer.valueOf(numberOnly);
                if(tempMap.containsKey(tree3.root().element().toString())){
                    tempMap.put(tree3.root().element().toString(),tempMap.get(tree3.root().element().toString())+num);
                }else{
                    tempMap.put(tree3.root().element().toString(),num);
                }
            }
            else {//깊이1에서 더 내려갈 수 있는경우
                for (int j = 0; j < tree3.root().children().get(i).children().size(); j++) {
                    if (tree3.isExternal(tree3.root().children().get(i).children().get(j))) {//엣지 일때
                        String stringTemp = tree3.root().children().get(i).children().get(j).element().toString();
                        Matcher matcher=pattern.matcher(stringTemp);
                        matcher.find();//matcher.group하기위한 메서드
                        String numberString=matcher.group(1);
                        String numberOnly= numberString.replaceAll("[^0-9]", "");
                        int num=Integer.valueOf(numberOnly);
                        if(tempMap.containsKey(tree3.root().children().get(i).element().toString())){
                            tempMap.put(tree3.root().children().get(i).element().toString(),tempMap.get(tree3.root().children().get(i).element().toString())+num);
                        }else{
                            tempMap.put(tree3.root().children().get(i).element().toString(),num);
                        }
                        if(tempMap.containsKey(tree3.root().element().toString())){//부모 노드가 있으면, 부모값에도 추가하려는 목적
                            tempMap.put(tree3.root().element().toString(),tempMap.get(tree3.root().element().toString())+num);
                        }else{
                            tempMap.put(tree3.root().element().toString(),num);
                        }
                    }
                }
            }
        }
        System.out.println(tempMap);
        System.out.println("homeworks/ = "+tempMap.get("homeworks/")+"KB");
        System.out.println("programs/ = "+tempMap.get("programs/")+"KB");
        System.out.println("cs16/ = "+tempMap.get("cs16/")+"KB");
    }
}