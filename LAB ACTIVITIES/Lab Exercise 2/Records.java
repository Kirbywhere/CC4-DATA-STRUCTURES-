import java.io.*

;public class Records {

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

        System.out.print("To simulate a record address calculation, enter the data types and variables of the struct. Press enter to stop entering variables.\ntypedef struct {\n");
        String[] dataTypes = new String[20];
        String[] recArrays = new String[20];
        int[] numRecArrays = new int[20];

        int ArraysIndex = 0;
        int declarations = 0;
        
        while (true) { 

            String declaration;
            numRecArrays[ArraysIndex] = 1;
            System.out.print("  ");

            try {
                declaration = input.readLine();
                System.out.print("");
            } catch (IOException e) {
                System.out.println("Input error.");
                return;
            }

            if (declaration.equals("")) {
                break;
            }

            declarations++;
            int strlen = declaration.length();
            String dataType = "";
            String mode = "datatype";
            recArrays[ArraysIndex] = "";
            for (int i = 0; i < strlen; i++) {
                char charr = declaration.charAt(i);
                if ((charr == '[')) {
                    mode = "newUB";
                    dataTypes[ArraysIndex] = dataType;
                } else if ((charr != ' ') && (charr != ';') && mode.equals("datatype")) {
                    dataType += declaration.charAt(i);
                } else if ((charr == ' ')) {
                    dataTypes[ArraysIndex] = dataType;
                    mode = "notdatatype";
                } else if ((charr == '0' || charr == '1' || charr == '2' || charr == '3' || charr == '4' || charr == '5' || charr == '6' || charr == '7' || charr == '8' || charr == '9') && (mode.equals("newUB"))) {
                    recArrays[ArraysIndex] = String.valueOf(charr);//String.valueOf(charr);
                    mode = "sameUB";
                } else if ((charr == '0' || charr == '1' || charr == '2' || charr == '3' || charr == '4' || charr == '5' || charr == '6' || charr == '7' || charr == '8' || charr == '9') && (mode.equals("sameUB"))) {
                    recArrays[ArraysIndex] += String.valueOf(charr);
                } else if ((charr == ']' && !mode.equals("datatype") )) {
                    int arrayUpperBound = Integer.parseInt(recArrays[ArraysIndex]);
                    numRecArrays[ArraysIndex] *= arrayUpperBound;
                }
            }

            ArraysIndex++;
        }
        System.out.println("} RecordType;");

        int esize = 0;
        for (int i = 0; i < declarations; i++) {
            switch (dataTypes[i]) {
                case "byte":
                    esize += numRecArrays[i] * 1;
                    break;
                case "short":
                    esize += numRecArrays[i] * 2;
                    break;
                case "int":
                    esize += numRecArrays[i] * 2;
                    break;
                case "long":
                    esize += numRecArrays[i] * 8;
                    break;
                case "float":
                    esize += numRecArrays[i] * 4;
                    break;
                case "double":
                    esize += numRecArrays[i] * 8;
                    break;
                case "boolean":
                    esize += numRecArrays[i] * 1;
                    break;
                case "char":
                    esize += numRecArrays[i] * 1;
                    break;
                default:
                    esize += 1;

            }
            // System.out.println("Number of elements per data type: " + numRecArrays[i]);
        }
        // System.out.println("esize: " + esize);

        System.out.print("Enter the number of dimensions -> ");
        int dimensions;
        
        try {
            dimensions = Integer.parseInt(input.readLine());
            if (dimensions <= 0) return;
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

        System.out.println("Element size: " + esize);
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
        if (address % 1 != 0)
            System.out.print(" is " + address);
        else
            System.out.print( " is " + (int) address + "\n");

    }
    
}
