import java.util.Scanner;

public class ArrayAddressCalculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of dimensions: ");
        int numDimensions = scanner.nextInt();
        int[] upperBounds = new int[numDimensions];

        for (int i = 0; i < numDimensions; i++) {
            System.out.print("Enter the upper bound of dimension " + (i + 1) + ": ");
            upperBounds[i] = scanner.nextInt();
        }

        System.out.print("Enter the value of alpha: ");
        int alpha = scanner.nextInt();

        System.out.print("Enter the size of each element (esize) in bytes: ");
        int elementSize = scanner.nextInt();

        int[] indices = new int[numDimensions];
        for (int i = 0; i < numDimensions; i++) {
            boolean isValidIndex = false;

            while (!isValidIndex) {
                System.out.print("Enter the index for dimension " + (i + 1) + ": ");
                indices[i] = scanner.nextInt();

                if (indices[i] >= 0 && indices[i] < upperBounds[i]) {
                    isValidIndex = true;
                } else {
                    System.out.println("Index out of bounds. Please enter a valid index. Available indices: 0 to " + (upperBounds[i] - 1));
                }
            }
        }

       
        long arrayAddress = calculateArrayAddress(upperBounds, alpha, elementSize, indices);

        System.out.println("Array address: " + arrayAddress);
    }

    private static long calculateArrayAddress(int[] upperBounds, int alpha, int elementSize, int[] indices) {
        long arrayAddress = 0;

        for (int i = 0; i < upperBounds.length; i++) {
            long product = 1;
            for (int j = i + 1; j < upperBounds.length; j++) {
                product *= upperBounds[j];
            }

            arrayAddress += product * indices[i];
        }

        arrayAddress = alpha * arrayAddress + elementSize;

        return arrayAddress;
    }
}
