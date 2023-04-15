package week3.assigment2.classes;

import week3.assigment2.interfaces.MyList;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] hiddenArr;
    private int length;
    public MyArrayList() {
        this(5);
    }

    public MyArrayList(int initialCapacity) {
        hiddenArr = new Object[initialCapacity];
    }

    private void increaseBuffer() {
        int biggerSize = (int)(hiddenArr.length * 1.5);
        Object[] tempArr = new Object[biggerSize];

        for (int i = 0; i < hiddenArr.length; i++)
            tempArr[i] = hiddenArr[i];

        hiddenArr = tempArr;
    }

    private void swap(T a, T b){
        T temp = a;
        a = b;
        b = temp;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < length; i++)
            if (hiddenArr[i] == o)
                return true;

        return false;
    }

    @Override
    public void add(T item) {
        if (length == hiddenArr.length)
            increaseBuffer();
        hiddenArr[length++] = item;
    }

    @Override
    public void add(T item, int index) {
        if (length == hiddenArr.length)
            increaseBuffer();
        for (int i = length - 1; i >= index; i--)
            hiddenArr[i + 1] = hiddenArr[i];
        hiddenArr[index] = item;
        length++;
    }

    @Override
    public boolean remove(T item) {
        for (int i = 0; i < length; i++)
            if (hiddenArr[i] == item) {
                for (int j = i; j < length - 1; j++)
                    hiddenArr[i] = hiddenArr[i + 1];
                return true;
            }

        return false;
    }

    @Override
    public T remove(int index) {
        T temp = get(index);
        for (int i = index; i < length - 1; i++)
            hiddenArr[i] = hiddenArr[i + 1];
        length--;

        return temp;
    }

    @Override
    public void clear() {
        length = 0;
    }

    @Override
    public T get(int index) {
        if(index >= length)
            throw new IndexOutOfBoundsException();
        return (T) hiddenArr[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < length; i++)
            if (hiddenArr[i] == o)
                return i;

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = length - 1; i > 0; i--)
            if (hiddenArr[i] == o)
                return i;

        return -1;
    }

    @Override
    public void sort() {
        for (int i = 0; i < size() - 1; i++)
            for (int j = 0; j < size() - i - 1; j++)
                if (hiddenArr[j] < hiddenArr[j + 1])
                    swap(hiddenArr[j], hiddenArr[j + 1]);
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
