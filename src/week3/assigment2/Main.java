package week3.assigment2;

import week3.assigment2.classes.MyArrayList;
import week3.assigment2.classes.MyLinkedList;


public class Main {
    public static void main(String[] args) {
        System.out.println("MyArrayList Integer");
        MyArrayList<Integer> intArrList = new MyArrayList<>();
        //adding
        intArrList.add(5);
        intArrList.add(8);
        intArrList.add(7);
        intArrList.add(3);
        System.out.println(intArrList.size());
        System.out.println(intArrList.contains(5));
        System.out.println(intArrList.contains(45));
        printArrayList(intArrList);
        intArrList.add(41, 2);
        printArrayList(intArrList);
        intArrList.remove(2);
        intArrList.add(8);
        printArrayList(intArrList);
        System.out.println(intArrList.get(3));
        System.out.println(intArrList.indexOf(8));
        System.out.println(intArrList.lastIndexOf(8));
        intArrList.sort();
        printArrayList(intArrList);
        intArrList.clear();
        printArrayList(intArrList);

        System.out.println("\n" + "MyLinkedList Integer");
        MyLinkedList<Integer> intLinkList = new MyLinkedList<>();
        //adding
        intLinkList.add(5);
        intLinkList.add(8);
        intLinkList.add(7);
        intLinkList.add(3);
        System.out.println(intLinkList.size());
        System.out.println(intLinkList.contains(5));
        System.out.println(intLinkList.contains(45));
        printLinkedList(intLinkList);
        intLinkList.add(41, 2);
        printLinkedList(intLinkList);
        intLinkList.remove(2);
        intLinkList.add(8);
        printLinkedList(intLinkList);
        System.out.println(intLinkList.get(3));
        System.out.println(intLinkList.indexOf(8));
        System.out.println(intLinkList.lastIndexOf(8));
        intLinkList.sort();
        printLinkedList(intLinkList);
        intLinkList.clear();
        printLinkedList(intLinkList);

        System.out.println("\n" + "MyArrayList String");
        MyArrayList<String> strArrList = new MyArrayList<>();
        //adding
        strArrList.add("A");
        strArrList.add("B");
        strArrList.add("C");
        strArrList.add("D");
        System.out.println(strArrList.size());
        System.out.println(strArrList.contains("A"));
        System.out.println(strArrList.contains("E"));
        printArrayList(strArrList);
        strArrList.add("E", 2);
        printArrayList(strArrList);
        strArrList.remove(2);
        strArrList.remove("A");
        strArrList.add("B");
        printArrayList(strArrList);
        System.out.println(strArrList.get(3));
        System.out.println(strArrList.indexOf("B"));
        System.out.println(strArrList.lastIndexOf("B"));
        strArrList.sort();
        printArrayList(strArrList);
        strArrList.clear();
        printArrayList(strArrList);

        System.out.println("\n" + "MyLinkedList String");
        MyLinkedList<String> strLinkList = new MyLinkedList<>();
        //adding
        strLinkList.add("A");
        strLinkList.add("B");
        strLinkList.add("C");
        strLinkList.add("D");
        System.out.println(strLinkList.size());
        System.out.println(strLinkList.contains("A"));
        System.out.println(strLinkList.contains("E"));
        printLinkedList(strLinkList);
        strLinkList.add("E", 2);
        printLinkedList(strLinkList);
        strLinkList.remove("A");
        strLinkList.remove(2);
        strLinkList.add("B");
        printLinkedList(strLinkList);
        System.out.println(strLinkList.get(3));
        System.out.println(strLinkList.indexOf("B"));
        System.out.println(strLinkList.lastIndexOf("B"));
        strLinkList.sort();
        printLinkedList(strLinkList);
        strLinkList.clear();
        printLinkedList(strLinkList);
    }

    public static void printArrayList(MyArrayList<?> arr) {
        for (Object item : arr)
            System.out.print(item + " ");
        System.out.println();
    }
    public static void printLinkedList(MyLinkedList<?> arr) {
        for (Object item : arr)
            System.out.print(item + " ");
        System.out.println();
    }
}
