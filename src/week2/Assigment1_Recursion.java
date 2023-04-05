package week2;

public class Assigment1_Recursion {
    //problem 1
    //return minimum value from array
    public static int minValue(int[] arr, int n) {
        if (n == 1)
            return arr[0];
        int temp = minValue(arr, n - 1);

        return temp < arr[n - 1] ? temp : arr[n - 1];
    }

    //problem 2
    //return average value of array numbers
    public static float averageValue(int[] arr, int n) {
        float len = arr.length;
        if (n == 1)
            return arr[0] / len;

        return arr[n - 1] / len + averageValue(arr, n - 1);
    }

    //problem 3
    // return boolean is it number prime
    public static String isPrime(int n) {
        return isPrimeRecursive(n, n - 1) ? "Prime" : "Composite";
    }
    private static boolean isPrimeRecursive(int n, int divisor) {
        if (divisor == 1)
            return true;
        if (n % divisor == 0)
            return false;

        return isPrimeRecursive(n, divisor - 1);
    }

    //problem 4
    //find recursion
    public static int factorial(int n) {
        if (n == 1)
            return 1;

        return n * factorial(n - 1);
    }

    //problem 5
    // fibonacci
    public static int fibonacci(int n) {
        if (n < 2)
            return n;

        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    //problem 6
    //a^n power(a, n)
    public static int power(int a, int n) {
        if (n == 1)
            return a;

        return a * power(a, n - 1);
    }

    //problem 7
    //print all permutations of the symbols of the given string
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void print_all_permutations(String str) {
        if (str == null || str.length() == 0) {
            return;
        }

        print_all_permutations_recursive(str.toCharArray(), 0);
    }

    private static void print_all_permutations_recursive (char[] symbols, int currentIndex) {
        if (currentIndex == symbols.length - 1) {
            System.out.println(symbols);
        }

        for (int i = currentIndex; i < symbols.length; i++)
        {
            swap(symbols, currentIndex, i);
            print_all_permutations_recursive(symbols, currentIndex + 1);
            swap(symbols, currentIndex, i);
        }
    }

    //problem 8
    //are all character digits
    public static String isAllDigits(String s) {
        char[] symbols = s.toCharArray();
        return isAllDigitsRecursive(symbols, s.length()) ? "Yes" : "No";
    }

    private static boolean isAllDigitsRecursive(char[] s, int n) {
        if (n == 0)
            return true;
        if (!Character.isDigit(s[n - 1]))
            return false;
        return isAllDigitsRecursive(s, n - 1);
    }

    //problem 9
    //return binomial coefficient
    public static int binomialCoefficient(int n, int k) {
        if (n == k || k == 0)
            return 1;

        return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
    }

    //problem 10
    //return GCD
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;

        return gcd(b, a % b);
    }
}
