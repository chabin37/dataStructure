package PriorityQueues2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        PointComparator p1=new PointComparator();
        PointComparator2 p2=new PointComparator2();
        MyPQ pq=new MyPQ(p1);
        pq.insert("a",new ArrayList<>(Arrays.asList(5,4)));
        pq.insert("b",new ArrayList<>(Arrays.asList(2,7)));
        pq.insert("c",new ArrayList<>(Arrays.asList(9,5)));
        pq.insert("d",new ArrayList<>(Arrays.asList(3,1)));
        pq.insert("e",new ArrayList<>(Arrays.asList(7,2)));
        pq.insert("f",new ArrayList<>(Arrays.asList(9,7)));
        pq.insert("g",new ArrayList<>(Arrays.asList(1,4)));
        pq.insert("h",new ArrayList<>(Arrays.asList(4,3)));
        pq.insert("i",new ArrayList<>(Arrays.asList(8,2)));
        pq.insert("j",new ArrayList<>(Arrays.asList(4,8)));
        System.out.println("[가까운 순서]");
        while (!pq.isEmpty()) {
            var temp=pq.removeMin();
            var temparr= (ArrayList<Integer>) temp.getValue();
            System.out.println((String)temp.getKey()+" ("+temparr.get(0)+", "+temparr.get(1)+")");
        }
        pq.comp=p2;
        pq.insert("a",new ArrayList<>(Arrays.asList(5,4)));
        pq.insert("b",new ArrayList<>(Arrays.asList(2,7)));
        pq.insert("c",new ArrayList<>(Arrays.asList(9,5)));
        pq.insert("d",new ArrayList<>(Arrays.asList(3,1)));
        pq.insert("e",new ArrayList<>(Arrays.asList(7,2)));
        pq.insert("f",new ArrayList<>(Arrays.asList(9,7)));
        pq.insert("g",new ArrayList<>(Arrays.asList(1,4)));
        pq.insert("h",new ArrayList<>(Arrays.asList(4,3)));
        pq.insert("i",new ArrayList<>(Arrays.asList(8,2)));
        pq.insert("j",new ArrayList<>(Arrays.asList(4,8)));
        System.out.println("\n[멀리 있는 순서]");
        while (!pq.isEmpty()) {
            var temp=pq.removeMin();
            var temparr= (ArrayList<Integer>) temp.getValue();
            System.out.println((String)temp.getKey()+" ("+temparr.get(0)+", "+temparr.get(1)+")");
        }
    }
}
