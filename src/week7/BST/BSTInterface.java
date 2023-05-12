package week7.BST;

public interface BSTInterface<K extends Comparable<K>, V> {
    boolean isEmpty();
    K getMin();
    K getMax();
    int size();
    void put(K key, V val);
    V get(K key);
    void delete(K key);
}
