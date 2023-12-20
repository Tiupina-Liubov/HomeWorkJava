package src.java13_12_23;

import java.util.ArrayList;

public interface Stack2023<T> {
    void put(T t); //put

    boolean isEmpty(); //

    T get();
    T pop();
}

class StackImpl<T> implements Stack2023<T> {
    ArrayList<T> stack = new ArrayList<>();

    @Override
    public void put(T t) {
        stack.add(t);

    }

    @Override
    public boolean isEmpty() {
        if (this.stack.size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public T get() {
        T t= stack.get(stack.size()-1);

        return t;
    }

    @Override
    public T pop() {
        T t= get();
        stack.remove(t);
        return t;
    }

    @Override
    public String toString() {
        return "StackImpl{" +
                "stack=" + stack +
                '}';
    }
}
