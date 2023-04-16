package week3.assigment2.classes;

import week3.assigment2.interfaces.MyList;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private MyNode head;
    private MyNode tail;
    private int size;

    private class MyNode {
        private final T data;
        private MyNode next;
        private MyNode previous;

        public MyNode(T data){
            this.data = data;
        }
    }

    public MyLinkedList(){
        head = tail = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        MyNode temp = head;
        for (int i = 0; i < size; i++) {
            if ((T) o == temp.data)
                return true;
            temp = temp.next;
        }
        return false;
    }

    @Override
    public void add(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = tail = newNode;
        }
        else{
            System.out.println(newNode.data);
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(T item, int index) {
        // backward
        if (index > size/2){

        } else{
            MyNode temp = head;
            for (int i = 0; i < index; i++){

            }
        }

    }

    @Override
    public boolean remove(T item) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public void clear() {
        head = tail = null;
    }

    @Override
    public T get(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException();
        MyNode temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.next;

        return temp.data;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private MyNode cursor = head;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public T next() {
            T data = cursor.data;
            cursor =  cursor.next;
            return data;
        }
    }
}
