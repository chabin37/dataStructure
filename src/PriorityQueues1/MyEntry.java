package PriorityQueues1;

public class MyEntry implements Entry{
    private Object key;
    private Object value;

    public MyEntry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public void setKey(Object key) {
        this.key = key;
    }

    @Override
    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public Object getKey() {
        return this.key;
    }

    @Override
    public Object getValue() {
        return this.value;
    }
}
