package week3.assigment2.classes;

import week3.assigment2.interfaces.MyList;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private MyNode head;
    private MyNode tail;
    private int size;

    private class MyNode {
        private T data;
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
            if (o == temp.data)
                return true;
            temp = temp.next;
        }
        return false;
    }

    @Override
    public void add(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = newNode;
        }
        else{
            newNode.previous = tail;
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public void add(T item, int index) {
        //check index
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        //check: item added into end
        if (index == size) {
            add(item);
            return;
        }
        //create new node with data
        MyNode newNode = new MyNode(item);
        //check: item added into start
        if (index == 0){
            head.previous = newNode;
            newNode.next = head;
            head = newNode;
        }

        else{
                //check: if path faster forward we start from "head"
                if (index <= size / 2){
                    MyNode cursor = head;
                    for (int i = 0; i < index; i++)
                        cursor = cursor.next;
                    newNode.next = cursor;
                    newNode.previous = cursor.previous;
                    cursor.previous.next = newNode;
                    cursor.previous = newNode;
                }
                //check: if path faster backward we start from "tail"
                else{
                    MyNode cursor = tail;
                    for (int i = size - 1; i > index; i--)
                        cursor = cursor.previous;
                    newNode.next = cursor;
                    newNode.previous = cursor.previous;
                    cursor.previous.next = newNode;
                    cursor.previous = newNode;
                }
            }
        size++;
        }

    @Override
    public boolean remove(T item) {
        MyNode cursor = head;
        while (cursor != null) {
            if (cursor.data == item){
                removeNode(cursor);
                return true;
            }
            cursor = cursor.next;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        MyNode cursor = head;
        for (int i = 0; i < index; i++)
            cursor = cursor.next;
        removeNode(cursor);
        return cursor.data;
    }

    private void removeNode(MyNode node) {
        if (node.previous == null) {
            head = node.next;
        } else {
            node.previous.next = node.next;
        }
        if (node.next == null) {
            tail = node.previous;
        } else {
            node.next.previous = node.previous;
        }
        size--;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        MyNode cursor = head;
        if (index > size / 2){
            // backward
            cursor = tail;
            for (int i = size - 1; i > index; i--)
                cursor = cursor.previous;
        }
        else{
            //forward
             for (int i = 0; i < index; i++)
                 cursor = cursor.next;
            }
        return cursor.data;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        for (MyNode cursor = head; cursor != null; cursor = cursor.next) {
            if (o == null ? cursor.data == null : o.equals(cursor.data)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size - 1;
        for (MyNode cursor = tail; cursor != null; cursor = cursor.previous) {
            if (o == null ? cursor.data == null : o.equals(cursor.data)) {
                return index;
            }
            index--;
        }
        return -1;
    }

    @Override
    public void sort() {
        if (!(head == null || head.data instanceof Comparable))
            throw new ClassCastException("Elements are not comparable");
        // sort with bubble sort algorithm
        for (int i = 0; i < size - 1; i++) {
            for (MyNode cursor = head; cursor.next != null; cursor = cursor.next) {
                if (((Comparable<T>) cursor.data).compareTo(cursor.next.data) > 0) {
                    T tmp = cursor.data;
                    cursor.data = cursor.next.data;
                    cursor.next.data = tmp;
                }
            }
        }
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
