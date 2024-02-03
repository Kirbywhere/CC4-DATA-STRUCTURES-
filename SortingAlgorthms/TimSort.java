import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TimSort {

    static int RUN = 32;
    private int steps = 0; // Step counter

    int min(int a, int b) {
        return a < b ? a : b;
    }

    void insertionSort(int a[], int beg, int end) {
        int i, j, temp;
        for (i = beg + 1; i <= end; i++) {
            temp = a[i];
            j = i - 1;

            while (j >= beg && temp <= a[j]) {
                a[j + 1] = a[j];
                j = j - 1;
                steps++; // Increment step counter
            }
            a[j + 1] = temp;
        }
    }

    void merge(int a[], int beg, int mid, int end) {
        int i, j, k;
        int n1 = mid - beg + 1;
        int n2 = end - mid;

        int[] LeftArray = new int[n1];
        int[] RightArray = new int[n2];

        for (i = 0; i < n1; i++)
            LeftArray[i] = a[beg + i];
        for (j = 0; j < n2; j++)
            RightArray[j] = a[mid + 1 + j];

        i = 0;
        j = 0;
        k = beg;

        while (i < n1 && j < n2) {
            if (LeftArray[i] <= RightArray[j]) {
                a[k] = LeftArray[i];
                i++;
            } else {
                a[k] = RightArray[j];
                j++;
            }
            k++;
            steps++; // Increment step counter
        }

        while (i < n1) {
            a[k] = LeftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            a[k] = RightArray[j];
            j++;
            k++;
        }
    }

    void timSort(int a[], int n) {
        for (int i = 0; i < n; i += RUN)
            insertionSort(a, i, min((i + RUN - 1), (n - 1)));

        for (int size = RUN; size < n; size = 2 * size) {
            for (int beg = 0; beg < n; beg += 2 * size) {
                int mid = beg + size - 1;
                int end = min((beg + 2 * size - 1), (n - 1));
                if (mid < end)
                    merge(a, beg, mid, end);
            }
        }
    }

    void printArr(int[] a, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }

    public int getSteps() {
        return steps;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of values in the array: ");
        int size = scanner.nextInt();

        Integer[] data = new Integer[size];
        for (int i = 0; i < size; i++) {
            data[i] = i + 1; // Initialize with values from 1 to size
        }

        List<Integer> dataList = Arrays.asList(data);
        Collections.shuffle(dataList); // Shuffle the list

        TimSort ts = new TimSort();
        int[] shuffledArray = dataList.stream().mapToInt(Integer::intValue).toArray();

        long startTime = System.nanoTime();
        ts.timSort(shuffledArray, size);
        long endTime = System.nanoTime();

        System.out.println("Original array (shuffled):");
        ts.printArr(shuffledArray, size);

        System.out.println("\n\nSorted array:");
        ts.printArr(shuffledArray, size);

        System.out.println("\nNumber of steps: " + ts.getSteps());
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");

        scanner.close();
    }
}
