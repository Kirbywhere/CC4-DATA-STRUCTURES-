import java.io.*;

public class Stacks {
    public String[] stack;
    public int top = -1;
    public int size;

    public Stacks(int size) {
        this.stack = new String[size];
        this.size = size;
    }

    public static int Empty(Stacks stack) {

        if (stack.top == -1)
            return 1; // stack is empty
        else if (stack.top == stack.size - 1)
            return 2; // stack is full
        else
            return 3;
    }


    public static void main(String[] args) {
        
        Stacks stacks[] = new Stacks[100];
        String stackNames[] = new String[100];

        int stackIndex = 0;
        int totalStacks = 0;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("To simulate stack operations, choose from the following options: \n1: Create a stack \n2: Push element to a stack \n3: Pop an element off a stack \n4: Return the top of the stack \n5: Return whether a stack is empty or not \n6: Display the contents of the stack \n7: Exit \n");
        while (true) {
            String option;
            System.out.print("Option -> ");
            try {
                option = input.readLine();
            } catch (IOException e) {
                System.out.println("Input error!");
                return;
            }
            String stackQuery;
            switch (option) {
                case "1":
                    // create stack
                    boolean stackFound;

                    String stackName; 

                    while (true) {
                        stackFound = false;
                        while (true) {
                            System.out.print("Enter stack name -> ");
                            try {
                                stackName = input.readLine();
                                if (stackName.equals("")) {
                                    System.out.println("You did not enter a name. Try again.");
                                } else {
                                    break;
                                }
                            } catch (IOException e) {
                                System.out.println("Input error!");
                            }
                        }

                        int stackSize;
                        while (true) {
                            System.out.print("Enter stack size -> ");
                            try {
                                stackSize = Integer.parseInt(input.readLine());
                                break;
                            } catch (IOException e) {
                                System.out.println("Input error! Try again.");
                            } catch (NumberFormatException nfe) {
                                System.out.println("You did not enter a valid number! Try again.");
                            }
                        }

                        for (int i = 0; i < totalStacks; i++) {
                            if (stackNames[i].equals(stackName)) {   
                                stackFound = true;
                                System.out.println("Stack already exists. Try again.");
                                break;
                            }
                        }
                        
                        if (!stackFound) {
                            stackNames[stackIndex] = stackName;
                            stacks[stackIndex] = new Stacks(stackSize);
                            stackIndex++;
                            totalStacks++;
                            break;
                        }

                    }
                    break;

                case "2":
                    // push element
                    if (stacks[0] == null) {
                        System.out.println("There are no stacks in existence.");
                        break;
                    }

                    stackFound = false;

                    while (true) {
                        System.out.print("Enter stack you want to push an element into -> ");
                        try {
                            stackQuery = input.readLine();
                        } catch (IOException e) {
                            System.out.println("Input error!");
                            return;
                        }

                        for (int i = 0; i < totalStacks; i++) {
                            if (stackNames[i].equals(stackQuery) && Empty(stacks[i]) != 2) {
                                stackFound = true;

                                stacks[i].top++;
                                int top = stacks[i].top;

                                System.out.print("Enter element to be pushed -> ");

                                try {
                                    stacks[i].stack[top] = input.readLine();
                                    System.out.println("Pushed: " + stacks[i].stack[top]);
                                } catch (IOException e) {
                                    System.out.println("Input error!");
                                    return;
                                }
                                break;
                            } else if (stackNames[i].equals(stackQuery) && Empty(stacks[i]) == 2) {
                                stackFound = true;
                                System.out.println("Cannot push element as the stack is full.");
                            }
                        }

                        if (!stackFound)
                            System.out.println("Stack does not exist. Try again.");
                        else   
                            break;
                    } 
                    break;
                case "3":
                    // pop element
                    if (stacks[0] == null) {
                        System.out.println("There are no stacks in existence.");
                        break;
                    }

                    stackFound = false;

                    while (true) {
                        System.out.print("Enter stack you want to pop an element off of -> ");
                        try {
                            stackQuery = input.readLine();
                        } catch (IOException e) {
                            System.out.println("Input error!");
                            return;
                        }
                        for (int i = 0; i < totalStacks; i++) {
                            if (stackNames[i].equals(stackQuery) && Empty(stacks[i]) != 1) {
                                stackFound = true;
                                System.out.println("Popped: "+ stacks[i].stack[stacks[i].top]);
                                stacks[i].top--;
                                break;
                            } else if (stackNames[i].equals(stackQuery) && Empty(stacks[i]) == 1) {
                                stackFound = true;
                                System.out.println("Cannot pop element as stack is empty.");
                            }
                        }

                        if (!stackFound)
                            System.out.println("Stack does not exist. Try again.");
                        else   
                            break;
                    }
                    break;

                case "4":
                    // return stack's top
                    if (stacks[0] == null) {
                        System.out.println("There are no stacks in existence.");
                        break;
                    }

                    stackFound = false;
                    
                    while (true) {
                        System.out.print("Enter stack whose top you want to display -> ");
                        try {
                            stackQuery = input.readLine();
                        } catch (IOException e) {
                            System.out.println("Input error!");
                            return;
                        }
                        for (int i = 0; i < totalStacks; i++) {
                            if (stackNames[i].equals(stackQuery)) {
                                stackFound = true;
                                System.out.println("Top of stack " + stackQuery + ": " + stacks[i].top);
                                break;
                            }
                        }
                        
                        if (!stackFound)
                            System.out.println("Stack does not exist. Try again.");
                        else   
                            break;

                    }
                    break;
                case "5":
                    // return if stack is empty or not
                    if (stacks[0] == null) {
                        System.out.println("There are no stacks in existence.");
                        break;
                    }

                    stackFound = false;
                    
                    while (true) {
                        System.out.print("Enter stack name to determine if it's full, empty, or neither -> ");
                        try {
                            stackQuery = input.readLine();
                        } catch (IOException e) {
                            System.out.println("Input error!");
                            return;
                        }
                        for (int i = 0; i < totalStacks; i++) {
                            if (stackNames[i].equals(stackQuery)) {
                                stackFound = true;
                                switch (Empty(stacks[i])) {
                                    case 1 -> System.out.println("Stack " + stackQuery + " is EMPTY.");
                                    case 2 -> System.out.println("Stack " + stackQuery + " is FULL.");
                                    default -> System.out.println("Stack " + stackQuery + " is NEITHER EMPTY NOR FULL.");
                                }
                                break;
                            }
                        }

                        if (!stackFound)
                            System.out.println("Stack does not exist. Try again.");
                        else   
                            break;
                    }
                    break;
                case "6":
                    // return and display all elements of the stack
                    if (stacks[0] == null) {
                        System.out.println("There are no stacks in existence.");
                        break;
                    }

                    stackFound = false;
                    
                    while (true) {
                        System.out.print("Enter stack of which elements you want to display -> ");
                        try {
                            stackQuery = input.readLine();
                        } catch (IOException e) {
                            System.out.println("Input error!");
                            return;
                        }
                        for (int i = 0; i < totalStacks; i++) {
                            if (stackNames[i].equals(stackQuery)) {
                                stackFound = true;
                                if (stacks[i].top > -1) {
                                    for (int j = stacks[i].top; j >= 0; j--) {
                                        System.out.println("Element at index " + j + ": " + stacks[i].stack[j]);
                                    }
                                    break;
                                } else {
                                    System.out.println("Stack is empty.");
                                }
                            }
                        }
                        
                        if (!stackFound)
                            System.out.println("Stack does not exist. Try again.");
                        else   
                            break;
        
                    }
                    break;
                case "7":
                    // exit simulator
                    System.out.println("You exited from the stack simulator.");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}