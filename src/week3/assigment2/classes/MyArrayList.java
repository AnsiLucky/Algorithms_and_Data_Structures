package week3.assigment2.classes;

import week3.assigment2.interfaces.MyList;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] hiddenArr;
    private int capacity = 5;
    private int size;
    public MyArrayList() {
        this(5);
    }
    // constructor with parameter for special capacity
    public MyArrayList(int initialCapacity) {
        hiddenArr = new Object[initialCapacity];
    }

    private void increaseBuffer() {
        capacity = capacity * 2;
        Object[] tempArr = new Object[capacity];

        for (int i = 0; i < size; i++)
            tempArr[i] = hiddenArr[i];

        hiddenArr = tempArr;
    }
    // swap two Objects in array
    private void swap(Object[] arr, int i, int j){
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public void add(T item) {
        if (size == capacity)
            increaseBuffer();
        hiddenArr[size++] = item;
    }

    @Override
    public void add(T item, int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (size == capacity)
            increaseBuffer();
        for (int i = size - 1; i >= index; i--)
            hiddenArr[i + 1] = hiddenArr[i];
        hiddenArr[index] = item;
        size++;
    }

    @Override
    public boolean remove(T item) {
        int index = indexOf(item);
        if (index < 0)
            return false;
        remove(index);
        return true;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        T temp = get(index);
        for (int i = index; i < size - 1; i++)
            hiddenArr[i] = hiddenArr[i + 1];
        size--;

        return temp;
    }

    @Override
    public void clear() {
        hiddenArr = new Object[5];
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        return (T) hiddenArr[index];
    }
    // indexOf return the first index of given Object, if Object not consist return -1;
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++)
            if (hiddenArr[i] == o)
                return i;

        return -1;
    }
    // indexOf return the last index of given Object, if Object not consist return -1;
    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i > 0; i--)
            if (hiddenArr[i] == o)
                return i;

        return -1;
    }
    // sort with bubble sort algorithm
    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - i - 1; j++)
                if (((Comparable<T>) hiddenArr[j]).compareTo((T) hiddenArr[j + 1]) > 0)
                    swap(hiddenArr, j, j + 1);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor < size();
        }

        @Override
        public T next() {
            return get(cursor++);
        }
    }
}
