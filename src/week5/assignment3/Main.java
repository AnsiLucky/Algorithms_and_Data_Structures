package week5.assignment3;

public class Main {
    public static void main(String[] args) {
        MyHashTable<Integer, String> hashTable = new MyHashTable<>();
        hashTable.put(500, "500");
        hashTable.put(575, "575");
        hashTable.put(300, "300");
        System.out.println(hashTable.get(300));

        Student student = new Student("Angsar", 3.58);
        System.out.println(student.getGpa());

    }
}
