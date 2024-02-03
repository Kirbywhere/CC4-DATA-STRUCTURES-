import java.util.Arrays;

public class BubbleSort {
    static int stepCounter = 0;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        long startTime = System.currentTimeMillis();
        bubbleSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("Array sorted with bubble sort: ");
        System.out.println(Arrays.toString(arr));
        System.out.println("Number of steps taken in each pass: ");
        System.out.println("Total number of steps: " + stepCounter);
        System.out.println("Time taken in milliseconds: " + (endTime - startTime));
    }

    public static void bubbleSort(int[] arr) {
        int size = arr.length;
        boolean swapped;
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
                stepCounter++;
            }
            if (!swapped) {
                break;
            }
        }
    }
}
