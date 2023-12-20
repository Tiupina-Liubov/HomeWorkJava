package src._2023_12_13;

import java.util.ArrayList;

public class QueueClass<T> implements Queue<T>{
    ArrayList<T> arrayList=new ArrayList<>();

    @Override
    public void put(T t) {
        arrayList.add(t);
    }

    @Override
    public boolean isEmpty() {
        if (this.arrayList.size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public T get() {
        T t= arrayList.get(0);
        return t;
    }

    @Override
    public T pop() {
        T t= get();
        arrayList.remove(t);
        return t;
    }

    @Override
    public String toString() {
        return " " + arrayList;
    }
}
