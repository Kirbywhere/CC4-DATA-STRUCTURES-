import java.io.*;

public class BSTTraversal {

    public static class BinarySearchTree
    {
        public class Node {
            public Integer data;
            public int index;
            public Node right;
            public Node left;
            public Node parent;

            public Node(int data)
            {
                this.data = data;
                this.right = null;
                this.left = null;
                this.parent = null;
            }
        }

        public Node root;
        public Integer[] array;
        public int farthestIndex;
        public int index = 0;
        public int keyCount = 0;
        public int printCounter;

        public BinarySearchTree(int length)
        {
            root = null;
            int nodeCount = (int) Math.pow(2.0 , length) - 1;
            array = new Integer[nodeCount];
            for (int i = 0; i < nodeCount; i++)
                array[i] = null;
        }

        public void insertKey(int data)
        {
            Node key = new Node(data);
            Node comparisonNode = root;
            if (root == null)
            {
                root = key;
                return;
            }

            if (root.data == data)  
                return;
            
            while (true) 
            { 
                if (data < comparisonNode.data)
                { 
                    if (comparisonNode.left == null)
                    {
                        comparisonNode.left = key;
                        key.parent = comparisonNode;
                        keyCount++;
                        return;
                    }
                    comparisonNode = comparisonNode.left;
                }
                else if (comparisonNode.data < data)
                {
                    if (comparisonNode.right == null)
                    {
                        comparisonNode.right = key;
                        key.parent = comparisonNode;
                        keyCount++;
                        return;
                    }
                    comparisonNode = comparisonNode.right;
                }
                else
                    return;
                
            }
        }

        // Preorder: <data> <LT> <RT>
        public void PreorderTraversal(Node node)
        {
            if (node == null) return;

            printCounter++;

            if (printCounter <= keyCount)
            {
                System.out.print(node.data + ", ");
            }
            else
            {
                System.out.print(node.data);
            }

            PreorderTraversal(node.left);
            PreorderTraversal(node.right);
        }

        // Postorder: <LT> <RT> <data>
        public void PostorderTraversal(Node node)
        {
            if (node == null) return;

            PostorderTraversal(node.left);
            PostorderTraversal(node.right);

            printCounter++;

            if (printCounter <= keyCount)
            {
                System.out.print(node.data + ", ");
            }
            else
            {
                System.out.print(node.data);
            }
        }

        // Inorder: <LT> <data> <RT>
        public void InorderTraversal(Node node)
        {
            if (node == null) return;

            InorderTraversal(node.left);

            printCounter++;

            if (printCounter <= keyCount)
            {
                System.out.print(node.data + ", ");
            }
            else
            {
                System.out.print(node.data);
            }

            InorderTraversal(node.right);
        }

        public void AppendToBSTArray(Node node)
        {
            if (node == null) return;

            if (node.parent == null)
            {
                node.index = 0;
                array[0] = node.data;
            }

            if (node.left != null)
            {
                array[2 * node.index + 1] = node.left.data;
                node.left.index = 2 * node.index + 1;
                if ((2 * node.index + 1) > farthestIndex)
                    farthestIndex = 2 * node.index + 1;
            }

            if (node.right != null)
            {
                array[2 * node.index + 2] = node.right.data;
                node.right.index = 2 * node.index + 2;
                if ((2 * node.index + 2) > farthestIndex)
                    farthestIndex = 2 * node.index + 2;
            }

            AppendToBSTArray(node.left);
            AppendToBSTArray(node.right);

        }

        public int FindHeight(Node node)
        {
            if (node == null) return 0;
            return 1 + Math.max(FindHeight(node.left), FindHeight(node.right));
        }
    }

    static void printKeys(Integer[] keys, int height)
    {
        int valueLength;
        int size = (int) Math.pow(2, height) - 1;
        // Print the index row
        // System.out.print("Index: ");
        // for (int i = 0; i < size; i++)
        // {
        //     System.out.print("| " + i);
        //     if (keys[i] != null)
        //         valueLength = String.valueOf(keys[i]).length();
        //     else
        //         valueLength = 0;
        //     if (String.valueOf(i).length() < valueLength)
        //     {
        //         for (int j = 0; j < ( String.valueOf(keys[i]).length() - String.valueOf(i).length() ); j++)
        //             System.out.print(" ");
        //     }

        //     System.out.print(" ");
        // }
        // System.out.println("|");

        // // Print the keys row
        // System.out.print("Key:   ");
        // for (int i = 0; i < size; i++)
        // {
        //     System.out.print("| ");
        //     if (keys[i] != null)
        //     {
        //         System.out.print(keys[i]);
        //         valueLength = String.valueOf(keys[i]).length();
        //     }
        //     else
        //     {
        //         System.out.print("");
        //         valueLength = 0;
        //     }

        //     if (String.valueOf(i).length() > valueLength)
        //     {
        //         for (int j = 0; j < (String.valueOf(i).length() - valueLength); j++)
        //             System.out.print(" ");
        //     }
        //     System.out.print(" ");
        // }
        // System.out.println("|");
        int pass = 0;
        for (int i = 0; i < size; i += 20)
        {
            System.out.print("Index: ");
            for (int j = i; (j < (pass + 1) * 20) && j < size; j++)
            {
                System.out.print("| " + j);
                if (keys[j] != null)
                    valueLength = String.valueOf(keys[j]).length();
                else
                    valueLength = 0;
                if (String.valueOf(i).length() < valueLength)
                {
                    for (int k = 0; k < ( String.valueOf(keys[j]).length() - String.valueOf(j).length() ); k++)
                        System.out.print(" ");
                }

                System.out.print(" ");
            }
            System.out.println("|");

            // Print the keys row
            System.out.print("Key:   ");
            for (int j = i; (j < (pass + 1) * 20) && j < size; j++)
            {
                System.out.print("| ");
                if (keys[j] != null)
                {
                    System.out.print(keys[j]);
                    valueLength = String.valueOf(keys[j]).length();
                }
                else
                {
                    System.out.print("");
                    valueLength = 0;
                }

                if (String.valueOf(j).length() > valueLength)
                {
                    for (int k = 0; k < (String.valueOf(j).length() - valueLength); k++)
                        System.out.print(" ");
                }
                System.out.print(" ");
            }
            System.out.println("|\n");
            pass++;
        }
    }

    public static void main(String[] args) {
        Integer[] keys = new Integer[50];

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        // Ask user for BST keys
        String token;
        int tokenCount = 0;
        System.out.println("============================");
        System.out.println("BINARY SEARCH TREE GENERATOR");
        System.out.println("============================");
        while (true)
        {
            System.out.println("Input key #" + tokenCount);
            try
            {
                token = input.readLine();
                if (token.equals(""))
                    break;
                keys[tokenCount] = Integer.valueOf(token);
                tokenCount++;
            }
            catch (IOException e)
            {
                System.out.println("Input error.");
                return;
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("You did not input an integer.");
            }
        }
        Integer[] keysArray = new Integer[tokenCount];

        for (int j = 0; j < tokenCount; j++)
        {
            keysArray[j] = keys[j];
        }



        BinarySearchTree bst = new BinarySearchTree(tokenCount);
        for (int k = 0; k < keysArray.length; k++)
        {
            bst.insertKey(keysArray[k]);
        }

        System.out.println("Total key count: "+ bst.keyCount);

        // Print 1D Array Representation of BST
        System.out.println("1D ARRAY REPRESENTATION: \n");
        bst.AppendToBSTArray(bst.root);
        printKeys(bst.array, bst.FindHeight(bst.root));
        System.out.println();

        System.out.println("TREE TRAVERSAL REPRESENTATIONS: \n");

        // Print preorder traversal of BST
        System.out.print("PREORDER: ");
        bst.PreorderTraversal(bst.root);
        bst.printCounter = 0;
        System.out.println("\n");

        // Print inorder traversal of BST
        System.out.print("INORDER: ");
        bst.InorderTraversal(bst.root);
        bst.printCounter = 0;
        System.out.println("\n");

        // Print postorder traversal of BST
        System.out.print("POSTORDER: ");
        bst.PostorderTraversal(bst.root);
        bst.printCounter = 0;
        System.out.println("\n");

        // Option to try again
        System.out.print("Would you like to try again? Y/N -> ");
        try
        {
            String option = input.readLine();
            if (option.toLowerCase().equals("y"))
            {
                String[] arg = {""};
                BSTTraversal.main(arg);
            }
        }
        catch (IOException e)
        {
            System.out.println("Input error.");
        }
    } 
}
