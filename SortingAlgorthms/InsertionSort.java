import java.util.Arrays;

public class InsertionSort {
    static int stepCounter = 0;

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        long startTime = System.currentTimeMillis();
        insertionSort(data);
        long endTime = System.currentTimeMillis();
        System.out.println("Sorted Array in Ascending Order:");
        System.out.println(Arrays.toString(data));
        System.out.println("Step Counter: " + stepCounter);
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds");
    }

    public static void insertionSort(int[] array) {
        for (int step = 1; step < array.length; step++) {
            int key = array[step];
            int j = step - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
                stepCounter++;
            }
            array[j + 1] = key;
            stepCounter++;
        }
    }
}
