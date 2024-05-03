package PriorityQueues2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyPQ {
    Comparator<Object> comp;
    ArrayList<MyEntry> pq;


    public MyPQ(Comparator<Object> comp) {
        this.comp = comp;
        this.pq = new ArrayList<>();
    }

    public MyPQ(Comparator<Object> comp, int initialCapacity) {
        this.comp = comp;
        this.pq = new ArrayList<>(initialCapacity);
    }
    public int size() {
        return pq.size();
    }
    public boolean isEmpty() {
        return pq.isEmpty();
    }
    public MyEntry insert(Object k, Object v) {
        MyEntry e = new MyEntry(k, v);
        pq.add(e);
        return e;
    }
    public MyEntry removeMin() {
        Collections.sort(pq, comp);
        return pq.remove(pq.size() - 1);
    }
    public MyEntry min() {
        return pq.get(0);
    }
}
