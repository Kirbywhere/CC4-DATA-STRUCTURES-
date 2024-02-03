import java.util.Arrays;
import java.util.Random;

public class RadixSort {

    private int steps = 0; // Step counter

    // Using counting sort to sort the elements in the basis of significant places
    void countingSort(int array[], int size, int place) {
        int[] output = new int[size];
        int[] count = new int[10];

        // Calculate count of elements
        for (int i = 0; i < size; i++)
            count[(array[i] / place) % 10]++;

        // Calculate cumulative count
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
            output[count[(array[i] / place) % 10] - 1] = array[i];
            count[(array[i] / place) % 10]--;
            steps++; // Increment step counter
        }

        System.arraycopy(output, 0, array, 0, size);
    }

    // Function to get the largest element from an array
    int getMax(int array[], int n) {
        int max = array[0];
        for (int i = 1; i < n; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }

    // Main function to implement radix sort
    void radixSort(int array[], int size) {
        // Reset step counter
        steps = 0;

        // Get maximum element
        int max = getMax(array, size);

        // Apply counting sort to sort elements based on place value.
        for (int place = 1; max / place > 0; place *= 10)
            countingSort(array, size, place);
    }

    // Getter method for step counter
    public int getSteps() {
        return steps;
    }

    // Driver code
    public static void main(String args[]) {
        int[] data = new int[100];
        int size = data.length;

        // Generating 100 random values ranging from 1 to 1000
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(1000) + 1;
        }

        RadixSort rs = new RadixSort();
        rs.radixSort(data, size);
        
        // Printing the sorted array
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
        
        // Printing the number of steps
        System.out.println("Number of Steps: " + rs.getSteps());
    }
}