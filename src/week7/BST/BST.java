package week7.BST;

import java.security.Key;

public class BST<K extends Comparable<K>, V> implements BSTInterface<K, V> {
    private Node root;

    private class Node {
        private int size;
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            size = 1;
        }
    }

    public class KeyVal {
        private K key;
        private V val;

        public K getKey() {
            return key;
        }

        public V getVal() {
            return val;
        }

        public KeyVal(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public BST() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private Node getMin(Node node) {
        if (node.left != null)
            return getMin(node.left);

        return node;
    }

    private Node getMax(Node node) {
        if (node.right != null)
            return getMin(node.right);

        return node;
    }

    @Override
    public KeyVal getMin() {
        if (isEmpty()) return null;
        Node node = getMin(root);
        KeyVal result = new KeyVal(node.key, node.val);

        return result;
    }

    @Override
    public KeyVal getMax() {
        if (isEmpty()) return null;
        Node node = getMax(root);
        KeyVal result = new KeyVal(node.key, node.val);

        return result;
    }

    @Override
    public int size() {
        return root.size;
    }

    @Override
    public void put(K key, V val) {
        Node newNode = new Node(key, val);
        if (root == null)
            root = newNode;
        else
            insert(key, val, root);
    }

    private Node insert(K key, V val, Node node) {
        if (node == null)
            return new Node(key, val);
        if (key.compareTo(node.key) > 0) {
            node.right = insert(key, val, node.right);
            node.size++;
        }
        else if (key.compareTo(node.key) < 0) {
            node.left = insert(key, val, node.left);
            node.size++;
        }
        return node;
    }

    @Override
    public V get(K key) {
        KeyVal result = get(key, root);
        return result.val;
    }

    private KeyVal get(K key, Node node) {
        if (isEmpty())
            return null;
        if (key.compareTo(node.key) > 0)
            return get(key, node.right);
        else if (key.compareTo(node.key) < 0)
            return get(key, node.left);
        else {
            return new KeyVal(node.key, node.val);
        }
    }

    @Override
    public void delete(K key) {
        delete(key, root);
    }

    private Node delete(K key, Node node) {
        if (node == null)
            return null;
        if (key.compareTo(node.key) > 0) {
            node.right = delete(key, node.right);
            node.size++;
        }
        else if (key.compareTo(node.key) < 0) {
            node.left = delete(key, node.left);
            node.size++;
        }
        else {
            // when only one child / no child (leaf node)
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;

            // when two child
            if (node.left.size < node.right.size) {
                        node = getMax(node.left);
                        node.left = delete(node.key, node.left);
                    }
            else {
                node = getMin(node.right);
                node.right = delete(node.key, node.right);
            }
        }
        return node;
    }

    private KeyVal traverseInOrder(Node node) {
        if (node == null)
            return
    }

    @Override
    public Iterable<K> iterator() {
        return null;
    }
}
