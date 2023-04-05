package week2;

public class Main {
    public static void main(String[] args) {
        //problem 1
        System.out.println("Problem 1:");
        System.out.println(Assigment1_Recursion.minValue(new int[]{10, 1, 32, 3, 45}, 5));
        System.out.println();
        //problem 2
        System.out.println("Problem 2:");
        System.out.println(Assigment1_Recursion.averageValue(new int[]{3, 2, 4, 1}, 4));
        System.out.println();
        //problem 3
        System.out.println("Problem 3:");
        System.out.println(Assigment1_Recursion.isPrime(7));
        System.out.println(Assigment1_Recursion.isPrime(10));
        System.out.println();
        //problem 4
        System.out.println("Problem 4:");
        System.out.println(Assigment1_Recursion.factorial(5));
        System.out.println();
        //problem 5
        System.out.println("Problem 5:");
        System.out.println(Assigment1_Recursion.fibonacci(5));
        System.out.println(Assigment1_Recursion.fibonacci(17));
        System.out.println();
        //problem 6
        System.out.println("Problem 6:");
        System.out.println(Assigment1_Recursion.power(2, 10));
        System.out.println();
        //problem 7
        System.out.println("Problem 7:");
        Assigment1_Recursion.print_all_permutations("IOX");
        System.out.println();
        //problem 8
        System.out.println("Problem 8:");
        System.out.println(Assigment1_Recursion.isAllDigits("123456"));
        System.out.println(Assigment1_Recursion.isAllDigits("123a12"));
        System.out.println();
        //problem 9
        System.out.println("Problem 9:");
        System.out.println(Assigment1_Recursion.binomialCoefficient(2, 1));
        System.out.println(Assigment1_Recursion.binomialCoefficient(7, 3));
        System.out.println();
        //problem 10
        System.out.println("Problem 10:");
        System.out.println(Assigment1_Recursion.gcd(32, 48));
        System.out.println(Assigment1_Recursion.gcd(10, 7));
        System.out.println();
    }
}
