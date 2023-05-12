package week7.BST;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        bst.put(10, "ten");
        bst.put(4, "four");
        bst.put(9, "nine");
        bst.put(3, "tree");
        bst.put(40, "forty");
        bst.put(30, "thirty");
        bst.put(25, "twenty five");
        bst.put(32, "thirty two");
        bst.put(45, "forty five");
        bst.put(12, "twelve");
        bst.put(2, "two");
        bst.put(3, "tree 2.0");
        bst.delete(30);

        for (var elem : bst.iterator()) {
            System.out.println("Key: " + elem.getKey() + ", Value: " + elem.getVal());
        }

        System.out.println("Min Value:" );


        System.out.println(bst.size());
    }
}
