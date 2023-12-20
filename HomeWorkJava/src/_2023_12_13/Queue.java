package src._2023_12_13;

public interface Queue<T> {
    void put(T t);
    boolean isEmpty();
    T get();
    T pop();

}
