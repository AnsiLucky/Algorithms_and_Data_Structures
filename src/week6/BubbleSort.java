package week6;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++)
            for (int j = 0; j < len - 1 - i; j++){
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
    }
}
