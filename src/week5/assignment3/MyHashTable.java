package week5.assignment3;/////////////////0.75 loadFactor

public class MyHashTable<K, V> {
    private class HashNode<K, V>{ // HashNode class
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray; // Array of buckets
    private int M = 11; // default number of buckets
    private int N; // number of 'key-value' hashNodes

    public MyHashTable() {
        chainArray = new HashNode[M];
    }

    public MyHashTable(int M){
        this.M = M;
        chainArray = new HashNode[M];
    }

    private int hash(K key) {
        int hash = 0;
        try{
            char[] keyCharArray = key.toString().toCharArray(); // key convert into string, after into charArray
            for (char c : keyCharArray)
                hash += c;
        } catch (Exception e){
            hash = Math.abs(key.hashCode());
        }

        return hash % M;
    }

    public void put(K key, V value) {
        int bucket = hash(key);
        HashNode<K, V> hashNode = chainArray[bucket];
        while (hashNode != null){ // traversing all bucket
            if (hashNode.key.equals(key)) // check does key already exist in bucket
                break;
            hashNode = hashNode.next;
        }
        if (hashNode != null) // if key already exist
            hashNode.value = value; // change the value of hashNode
        else{ // if key doesn't exist, add new 'key-value' hashNode
            HashNode<K, V> newHashNode = new HashNode<>(key, value);
            if (4 * M < N){ // check need we increase number of buckets
                increaseBucketsNumber();
                bucket = hash(key); // assign new hashCode
            }
            newHashNode.next = chainArray[bucket];
            chainArray[bucket] = newHashNode;
            N++;
        }
    }

    private void increaseBucketsNumber() {
        M =  (int)(M * 0.75); // increase buckets in chainArray
        HashNode<K, V>[] newChainArray = new HashNode[M]; // create new chainArray with new number of buckets
        for (int i = 0; i < chainArray.length; i++){ //traversing throw all buckets in chainArray
            HashNode<K, V> current = chainArray[i]; // make current for keep location of node in chainArray
            while (current != null){ // traversing all bucket
                int hash = hash(current.key); // new hash for key (because our buckets number increased
                HashNode<K, V> next = current.next; // 'next' hashNode for keep location of next for further assign into 'current'
                current.next = newChainArray[hash]; // add hashNode in front of 'bucket' in new chainArray
                newChainArray[hash] = current; // assign the first 'hashNode' in current bucket
                current = next; // continue traversing in old 'chainArray'
            }
        }
        chainArray = newChainArray; // assign new location of memory for chainArray
    }

    public V get(K key) {
        int bucket = hash(key);
        HashNode<K, V> hashNode = chainArray[bucket];
        while (hashNode != null){ // traversing all bucket
            if (hashNode.key.equals(key))
                return hashNode.value;
            hashNode =  hashNode.next;
        }
        return null;
    }

    public V remove(K key) {
        int bucket = hash(key);
        HashNode<K, V> previousHashNode = chainArray[bucket];
        HashNode<K, V> hashNode = chainArray[bucket];
        while (hashNode != null){ // traversing all bucket
            if (hashNode.key.equals(key)) {
                if (previousHashNode == null) // check is our hashNode first in bucket
                    chainArray[bucket] = hashNode.next; // remove hashNode
                else
                    previousHashNode.next = hashNode.next; // remove hashNode
                N--;
                return hashNode.value;
            }
            previousHashNode = hashNode;
            hashNode =  hashNode.next;
        }
        return null;
    }

    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> hashNode = chainArray[i];
            while (hashNode != null) { // traversing all bucket
                if (hashNode.value.equals(value))
                    return true;
                hashNode = hashNode.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < M; i++) { // traversing all buckets or 'whole chainArray'
            HashNode<K, V> hashNode = chainArray[i];
            while (hashNode != null) { // traversing all bucket
                if (hashNode.value.equals(value))
                    return hashNode.key;
                hashNode = hashNode.next;
            }
        }
        return null;
    }
}
