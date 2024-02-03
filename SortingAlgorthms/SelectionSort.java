import java.util.Arrays;

public class SelectionSort {
    static int stepCounter = 0;

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int size = data.length;
        long startTime = System.nanoTime();

        for (int step = 0; step < size - 1; step++) {
            int min_idx = step;
            for (int i = step + 1; i < size; i++) {
                if (data[i] < data[min_idx]) {
                    min_idx = i;
                }
            }
            int temp = data[min_idx];
            data[min_idx] = data[step];
            data[step] = temp;
            stepCounter++;
        }

        long endTime = System.nanoTime();
        System.out.println("Sorted Array in Ascending Order:");
        System.out.println(Arrays.toString(data));
        System.out.println("Steps taken: " + stepCounter);
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");
    }
}
