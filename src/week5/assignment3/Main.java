package week5.assignment3;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##"); // Set precision to 2 decimal places
        MyHashTable<MyTestingClass, Student> hashTable = new MyHashTable();
       for (int i = 0; i < 10000; i++){
            hashTable.put(new MyTestingClass(unrealIIN(), (int) (Math.random() * (140 - 50 + 1) + 50), unrealUniversityCode()),
                    new Student(unrealName(3, 8), Double.parseDouble(df.format((Math.random() * 4)).replace(',', '.'))));
        }

        hashTable.printNumberOfElementsInEachBucket();

        System.out.println("Everything Good");
    }

    public static String unrealIIN() {
        String unrealIIN = "";
        for (int i = 0; i < 12; i++) {
            unrealIIN += (int) (Math.random() * 10);
        }

        return unrealIIN;
    }

    public static int unrealUniversityCode() {
        String unrealUniversityCode = "";
        for (int i = 0; i < 3; i++) {
            unrealUniversityCode += (int) (Math.random() * 10);
        }

        return Integer.valueOf(unrealUniversityCode);
    }

    public static String unrealName(int minLength, int maxLength) {
        int len = (int) (Math.random() * (maxLength - minLength + 1)) + minLength;
        String unrealName = "";
        unrealName += (char) ('A' + (int) (Math.random() *26));
        for(int i = 0; i < len - 1; i++)
            unrealName += ((char) ('a' + (int) (Math.random() * 26)));
        return unrealName;
    }
}
