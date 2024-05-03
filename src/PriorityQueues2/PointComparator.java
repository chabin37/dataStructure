package PriorityQueues2;

import java.util.ArrayList;
import java.util.Comparator;

public class PointComparator implements Comparator {//가까운 순서
    @Override
    public int compare(Object o1, Object o2) {
        var entry1=(MyEntry) o1;
        var entry2=(MyEntry) o2;
        var arr1=(ArrayList<Integer>)entry1.getValue();
        var arr2=(ArrayList<Integer>)entry2.getValue();
        int x1=arr1.get(0);
        int x2=arr2.get(0);
        int y1=arr1.get(1);
        int y2=arr2.get(1);
        return x2*x2+y2*y2-x1*x1-y1*y1;
    }
}
