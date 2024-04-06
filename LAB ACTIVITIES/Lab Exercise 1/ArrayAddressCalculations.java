import java.io.*

;public class ArrayAddressCalculations {

    public static float mult(int[] arr, float val, int min) {
        float factor = val;

        if (min >= arr.length) {
            return 0;
        }

        for (int i = min; i < arr.length; i++) {
            factor *= arr[i];
        }
        return factor;
    }

    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("To simulate an array address calculation, enter the number of dimensions -> ");
        int dimensions;
        
        try {
            dimensions = Integer.parseInt(input.readLine());
        } catch (IOException e) {
            System.out.println("Input error!");
            return;
        } catch (NumberFormatException nfe) {
            System.out.println("You did not input a number.");
            return;
        }
        System.out.println("");

        int[] upperBounds = new int[dimensions];
        int elementCount = 1;

        for (int i = 0; i < dimensions; i++) {
            System.out.print("Enter dimension number " + (i + 1) + " -> ");
            try {
                upperBounds[i] = Integer.parseInt(input.readLine());
                elementCount *= upperBounds[i];
            } catch (IOException e) {
                System.out.println("Input error!");
                return;
            } catch (NumberFormatException nfe) {
                System.out.println("You did not input a number.");
                return;
            }
            System.out.println("");
        }

        System.out.print("Enter the base address / alpha -> ");
        int alpha;
        try {
            alpha = Integer.parseInt(input.readLine());
        } catch (IOException e) {
            System.out.println("Input error!");
            return;
        } catch (NumberFormatException nfe) {
            System.out.println("You did not input a number.");
            return;
        }
        System.out.println("");

        System.out.print("Enter the element size -> ");
        float esize;
        try {
            esize = Float.parseFloat(input.readLine());
        } catch (IOException e) {
            System.out.println("Input error!");
            return;
        } catch (NumberFormatException nfe) {
            System.out.println("You did not input a number.");
            return;
        }
        System.out.println("");

        int[] arrayIndex = new int[dimensions];
        for (int i = 0; i < dimensions; i++) {
            System.out.print("Enter the index of dimension " + (i + 1) + " -> ");
            while (true){
                try {
                    arrayIndex[i] = Integer.parseInt(input.readLine());
                } catch (IOException e) {
                    System.out.println("Input error!");
                    return;
                } catch (NumberFormatException nfe) {
                    System.out.println("You did not input a number.");
                    return;
                }

                if (arrayIndex[i] < upperBounds[i]) {
                    break;
                } else {
                    System.out.print("Index value invalid. Try again -> ");
                }
            }
            System.out.println("");
        }

        System.out.println("Total number of elements: " + elementCount);

        float factor = 0;
        for (int i = 0; i < dimensions; i++) {
            float prod = mult(upperBounds, arrayIndex[i], (1 + i));
            if (prod != 0) {
                factor += prod;
            } else {
                factor += arrayIndex[i];
            }
        }
        float address = alpha + (esize * factor);
        System.out.print("The base address of A");
        for (int i = 0; i < dimensions; i++) {
            System.out.print("[" + arrayIndex[i] + "]");
        }
        System.out.print(" is " + address);

    }
    
}
