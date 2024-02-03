import java.util.Scanner;

public class RecordAddressCalculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of fields in the record: ");
        int numFields = scanner.nextInt();
        int[] fieldSizes = new int[numFields];

        for (int i = 0; i < numFields; i++) {
            System.out.print("Enter the size of field " + (i + 1) + " in bytes: ");
            fieldSizes[i] = scanner.nextInt();
        }

        long[] result = calculateTotalElementsAndAddress(fieldSizes);

        long totalElements = result[0];
        long address = result[1];

        System.out.println("Total number of elements: " + totalElements);
        System.out.println("Address of the record: " + address);

        scanner.close();
    }

    private static long[] calculateTotalElementsAndAddress(int[] fieldSizes) {
        long totalElements = 1;
        long address = 0;

        for (int i = 0; i < fieldSizes.length; i++) {
            totalElements *= fieldSizes[i];
            address = (address * fieldSizes[i]) + 1;
        }

        return new long[]{totalElements, address};
    }
}
