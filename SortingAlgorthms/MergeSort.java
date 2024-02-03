public class MergeSort {
    private static int stepCounter = 0;
    private static long timeCounter = 0;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Original Array:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted Array:");
        printArray(arr);

        System.out.println("\nStep Counter: " + stepCounter);
        System.out.println("Time Counter: " + timeCounter + " ns");
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            stepCounter++;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    public static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; ++i)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            rightArray[j] = arr[middle + 1 + j];

        int i = 0, j = 0;
        int k = left;

        long startTime = System.nanoTime();

        while (i < n1 && j < n2) {
            stepCounter++;
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            stepCounter++;
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            stepCounter++;
            arr[k] = rightArray[j];
            j++;
            k++;
        }

        long endTime = System.nanoTime();
        timeCounter += (endTime - startTime);
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}