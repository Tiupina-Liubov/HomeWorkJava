package src.java13_12_23;

public interface Queue<T> {
    void put(T t);
    boolean isEmpty();
    T get();
    T pop();

}
