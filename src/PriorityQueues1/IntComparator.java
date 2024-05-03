package PriorityQueues1;

import java.util.Comparator;

public class IntComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        MyEntry m1=(MyEntry)o1;
        MyEntry m2=(MyEntry)o2;
        int a=(int)m1.getKey();
        int b=(int)m2.getKey();
        return b-a;
    }
}
