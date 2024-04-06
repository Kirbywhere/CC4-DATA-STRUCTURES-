import java.io.*;

public class AVL
{
    public static class AVLTree 
    {

        public class Node 
        {
            Integer key;
            public int index;
            int height;
            Node left;
            Node right;

            Node(int key) 
            {
                this.key = key;
            }
        }

        public Node root;
        public Integer[] array = new Integer[127];
        public int index = 0;
        public int keyCount = 0;
        public int printCounter = 0;


        public Node find(int key) 
        {
            Node current = root;
            while (current != null) {
                if (current.key == key)
                    break;
                
                current = current.key < key ? current.right : current.left;
            }
            return current;
        }

        public void insert(int key) 
        {
            root = insert(root, key);
        }

        public void delete(int key) 
        {
            root = delete(root, key);
        }

        public Node getRoot() 
        {
            return root;
        }

        public int height() 
        {
            return root == null ? -1 : root.height;
        }

        private Node insert(Node root, int key) 
        {
            if (root == null)
                return new Node(key);
            else if (root.key > key)
                root.left = insert(root.left, key);
            else if (root.key < key)
                root.right = insert(root.right, key);
            else
                System.out.println("Cannot insert duplicate key " + key);
            
            return rebalance(root);
        }

        private Node delete(Node node, int key) 
        {
            if (node == null)
                return node;
            else if (node.key > key)
                node.left = delete(node.left, key);
            else if (node.key < key)
                node.right = delete(node.right, key);
            else {
                if (node.left == null || node.right == null)
                    node = (node.left == null) ? node.right : node.left;
                else {
                    Node mostRightChild = mostRightChild(node.left);
                    node.key = mostRightChild.key;
                    node.left = delete(node.left, node.key);
                }
            }
            if (node != null)
                node = rebalance(node);

            return node;
        }

        private Node mostRightChild(Node node) 
        {
            Node current = node;
            /* loop down to find the leftmost leaf */
            while (current.right != null)
                current = current.right;
            
            return current;
        }

        private Node rebalance(Node z) 
        {
            updateHeight(z);
            int balance = getBalance(z);
            if (balance < -1) {
                if (height(z.right.right) > height(z.right.left) || height(z.right.right) == height(z.right.left))
                    z = rotateLeft(z);
                else if (height(z.right.right) < height(z.right.left)) {
                    z.right = rotateRight(z.right);
                    z = rotateLeft(z);
                }
            } else if (balance > 1) {
                if (height(z.left.left) > height(z.left.right) || height(z.left.left) == height(z.left.right))
                    z = rotateRight(z);
                else if (height(z.left.left) < height(z.left.right)) {
                    z.left = rotateLeft(z.left);
                    z = rotateRight(z);
                }
            }
                
            return z;

        }

        private Node rotateRight(Node A) 
        {
            Node B = A.left;
            Node z = B.right;
            B.right = A;
            A.left = z;
            updateHeight(A);
            updateHeight(B);
            return B;
        }

        private Node rotateLeft(Node A) 
        {
            Node B = A.right;
            Node z = B.left;
            B.left = A;
            A.right = z;
            updateHeight(A);
            updateHeight(B);
            return B;
        }

        private void updateHeight(Node n) 
        {
            n.height = 1 + Math.max(height(n.left), height(n.right));
        }

        private int height(Node n) 
        {
            return n == null ? -1 : n.height;
        }

        public int getBalance(Node n) 
        {
            return (n == null) ? 0 : height(n.left) - height(n.right);
        }

        // Preorder: <data> <LT> <RT>
        public void PreorderTraversal(Node node)
        {
            if (node == null) return;

            printCounter++;

            if (printCounter < keyCount)
                System.out.print(node.key + ", ");
            else
                System.out.print(node.key + " ");

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

            if (printCounter < keyCount)
                System.out.print(node.key + ", ");
            else
                System.out.print(node.key + " ");
        }

        // Inorder: <LT> <data> <RT>
        public void InorderTraversal(Node node)
        {
            if (node == null) return;

            InorderTraversal(node.left);

            printCounter++;

            if (printCounter < keyCount)
                System.out.print(node.key + ", ");
            else
                System.out.print(node.key + " ");

            InorderTraversal(node.right);
        }

        public void AppendToAVLArray(Node node)
        {
            if (node == null) return;

            if (node == root)
            {
                node.index = 0;
                array[0] = node.key;
            }

            if (node.left != null)
            {
                array[2 * node.index + 1] = node.left.key;
                node.left.index = 2 * node.index + 1;
            }
            else
                array[2 * node.index + 1] = null;

            if (node.right != null)
            {
                array[2 * node.index + 2] = node.right.key;
                node.right.index = 2 * node.index + 2;
            }
            else
                array[2 * node.index + 2] = null;

            AppendToAVLArray(node.left);
            AppendToAVLArray(node.right);

        }

        public int FindHeight(Node node)
        {
            if (node == null) return 0;
            return 1 + Math.max(FindHeight(node.left), FindHeight(node.right));
        }
    }

    static void printKeys(AVLTree avl, Integer[] keys, int height)
    {
        avl.keyCount = 0;
        int valueLength;
        int size = (int) Math.pow(2, height) - 1;
        
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
                    avl.keyCount++;
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

    public static void main(String[] args) 
    {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        // Ask user for BST keys
        String token;
        int tokenCount;
        System.out.println("============================");
        System.out.println("     AVL TREE GENERATOR");
        System.out.println("============================");

        AVLTree avl = new AVLTree();

        while (true) 
        { 
            System.out.println("Enter:\n1 to INSERT keys\n2 to DELETE keys\n3 to TRY AGAIN\n4 to EXIT the simulator");
            String choice;
            try
            {
                System.out.print("-> ");
                choice = input.readLine();
            }
            catch (IOException e)
            {
                System.out.println("Input error.");
                return;
            }

            switch (choice)
            {
                case "1":
                    tokenCount = 0;
                    Integer[] insertKeys = new Integer[50];
                    System.out.println("============================");
                    System.out.println("     INSERT OPERATIONS");
                    System.out.println("============================");
                    while (true)
                    {
                        System.out.println("INSERT key #" + tokenCount);
                        try
                        {
                            token = input.readLine();
                            if (token.equals(""))
                                break;
                            insertKeys[tokenCount] = Integer.valueOf(token);
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
                    Integer[] insertKeysArray = new Integer[tokenCount];
        
                    for (int j = 0; j < tokenCount; j++)
                        insertKeysArray[j] = insertKeys[j];
        
                    for (int k = 0; k < insertKeysArray.length; k++)
                        avl.insert(insertKeysArray[k]);
        
                    break;
                case "2":
                    tokenCount = 0;
                    Integer[] deleteKeys = new Integer[50];
                    System.out.println("============================");
                    System.out.println("     DELETE OPERATIONS");
                    System.out.println("============================");
                    while (true)
                    {
                        System.out.println("DELETE key #" + tokenCount);
                        try
                        {
                            token = input.readLine();
                            if (token.equals(""))
                                break;
                            deleteKeys[tokenCount] = Integer.valueOf(token);
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
                    Integer[] deleteKeysArray = new Integer[tokenCount];
        
                    for (int j = 0; j < tokenCount; j++)
                        deleteKeysArray[j] = deleteKeys[j];
        
                    for (int k = 0; k < deleteKeysArray.length; k++)
                        avl.delete(deleteKeysArray[k]);

                    break;
                case "3":
                    System.out.println("You opted to try again. Restarting the simulator...");
                    String[] arg = {""};
                    AVL.main(arg);
                    break;
                case "4":
                    System.out.println("Exiting AVL Tree Simulator...");
                    System.exit(0);
            }

            // Print 1D Array Representation of BST
            System.out.println("1D ARRAY REPRESENTATION: \n");
            avl.AppendToAVLArray(avl.getRoot());
            printKeys(avl, avl.array, avl.FindHeight(avl.root));
            System.out.println();

            System.out.println("TREE TRAVERSAL REPRESENTATIONS: \n");

            // Print preorder traversal of BST
            avl.printCounter = 0;
            System.out.print("PREORDER: ");
            avl.PreorderTraversal(avl.root);
            avl.printCounter = 0;
            System.out.println("\n");

            // Print inorder traversal of BST
            System.out.print("INORDER: ");
            avl.InorderTraversal(avl.root);
            avl.printCounter = 0;
            System.out.println("\n");

            // Print postorder traversal of BST
            System.out.print("POSTORDER: ");
            avl.PostorderTraversal(avl.root);
            avl.printCounter = 0;
            System.out.println("\n");
            
        }
    }
}