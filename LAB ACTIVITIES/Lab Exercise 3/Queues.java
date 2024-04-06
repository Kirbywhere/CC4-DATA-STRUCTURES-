import java.io.*;

public class Queues {
    public String[] queue;
    public int front = -1;
    public int count = 0;
    public int size;

    public Queues(int size) {
        this.queue = new String[size];
        this.size = size;
    }

    public static int Empty(Queues queue) {

        if (queue.count == 0)
            return 1; // queue is empty
        else if (queue.count == queue.size)
            return 2; // queue is full
        else
            return 3; // queue is neither full nor empty
    }


    public static void main(String[] args) {
        
        Queues queues[] = new Queues[100];
        String queueNames[] = new String[100];

        int queueIndex = 0;
        int totalQueues = 0;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("To simulate queue operations, choose from the following options: \n1: Create a queue \n2: Enqueue an element \n3: Dequeue an element \n4: Return the front of the queue \n5: Return whether a queue is empty or not \n6: Display the contents of the queue \n7: Exit \n");
        while (true) {
            String option;
            System.out.print("Option -> ");
            try {
                option = input.readLine();
            } catch (IOException e) {
                System.out.println("Input error!");
                return;
            }
            String queueQuery;
            switch (option) {
                case "1":
                    // create stack
                    boolean queueFound;

                    String queueName; 

                    while (true) {
                        queueFound = false;
                        while (true) {
                            System.out.print("Enter queue name -> ");
                            try {
                                queueName = input.readLine();
                                if (queueName.equals("")) {
                                    System.out.println("You did not enter a name. Try again.");
                                } else {
                                    break;
                                }
                            } catch (IOException e) {
                                System.out.println("Input error!");
                            }
                        }

                        int queueSize;
                        while (true) {
                            System.out.print("Enter queue size -> ");
                            try {
                                queueSize = Integer.parseInt(input.readLine());
                                break;
                            } catch (IOException e) {
                                System.out.println("Input error! Try again.");
                            } catch (NumberFormatException nfe) {
                                System.out.println("You did not enter a valid number! Try again.");
                            }
                        }

                        for (int i = 0; i < totalQueues; i++) {
                            if (queueNames[i].equals(queueName)) {   
                                queueFound = true;
                                System.out.println("Queue already exists. Try again.");
                                break;
                            }
                        }
                        
                        if (!queueFound) {
                            queueNames[queueIndex] = queueName;
                            queues[queueIndex] = new Queues(queueSize);
                            queueIndex++;
                            totalQueues++;
                            break;
                        }

                    }
                    break;

                case "2":
                    // enqueue element

                    if (queues[0] == null) {
                        System.out.println("There are no queues in existence.");
                        break;
                    }
                    
                    queueFound = false;

                    while (true) {
                        System.out.print("Enter queue you want to enqueue into -> ");
                        try {
                            queueQuery = input.readLine();
                        } catch (IOException e) {
                            System.out.println("Input error!");
                            return;
                        }

                        for (int i = 0; i < totalQueues; i++) {
                            if (queueNames[i].equals(queueQuery) && Empty(queues[i]) != 2) {
                                queueFound = true;

                                if (queues[i].front == -1)
                                    queues[i].front = 0;

                                int index = (queues[i].front + queues[i].count) % queues[i].size;
                                queues[i].count++;

                                System.out.print("Enter element to be enqueued -> ");

                                try {
                                    queues[i].queue[index] = input.readLine();
                                    System.out.println("Enqueued: " + queues[i].queue[index]);
                                } catch (IOException e) {
                                    System.out.println("Input error!");
                                    return;
                                }
                                break;
                            } else if (queueNames[i].equals(queueQuery) && Empty(queues[i]) == 2) {
                                queueFound = true;
                                System.out.println("Cannot enqueue as the queue is full.");
                            }
                        }

                        if (!queueFound)
                            System.out.println("Queue does not exist. Try again.");
                        else   
                            break;
                    } 
                    break;
                case "3":
                    // dequeue

                    if (queues[0] == null) {
                        System.out.println("There are no queues in existence.");
                        break;
                    }

                    queueFound = false;

                    while (true) {
                        System.out.print("Enter queue you want to pop an element off of -> ");
                        try {
                            queueQuery = input.readLine();
                        } catch (IOException e) {
                            System.out.println("Input error!");
                            return;
                        }
                        for (int i = 0; i < totalQueues; i++) {
                            if (queueNames[i].equals(queueQuery) && Empty(queues[i]) != 1) {
                                queueFound = true;
                                System.out.println("Dequeued: "+ queues[i].queue[queues[i].front]);
                                queues[i].front = (queues[i].front + 1) % queues[i].size;
                                queues[i].count--;
                                break;
                            } else if (queueNames[i].equals(queueQuery) && Empty(queues[i]) == 1) {
                                queueFound = true;
                                System.out.println("Cannot dequeue as queue is empty.");
                            }
                        }

                        if (!queueFound)
                            System.out.println("Queue does not exist. Try again.");
                        else   
                            break;
                    }
                    break;

                case "4":
                    // return queue's front

                    if (queues[0] == null) {
                        System.out.println("There are no queues in existence.");
                        break;
                    }

                    queueFound = false;
                    
                    while (true) {
                        System.out.print("Enter queue whose front you want to display -> ");
                        try {
                            queueQuery = input.readLine();
                        } catch (IOException e) {
                            System.out.println("Input error!");
                            return;
                        }
                        for (int i = 0; i < totalQueues; i++) {
                            if (queueNames[i].equals(queueQuery)) {
                                queueFound = true;
                                System.out.println("Front of queue " + queueQuery + ": " + queues[i].front);
                                System.out.println("Front element of queue " + queueQuery + ": " + queues[i].queue[queues[i].front]);
                                break;
                            }
                        }
                        
                        if (!queueFound)
                            System.out.println("Queue does not exist. Try again.");
                        else   
                            break;

                    }
                    break;
                case "5":
                    // return if queue is empty or not

                    if (queues[0] == null) {
                        System.out.println("There are no queues in existence.");
                        break;
                    }

                    queueFound = false;
                    
                    while (true) {
                        System.out.print("Enter queue name to determine if it's full, empty, or neither -> ");
                        try {
                            queueQuery = input.readLine();
                        } catch (IOException e) {
                            System.out.println("Input error!");
                            return;
                        }
                        for (int i = 0; i < totalQueues; i++) {
                            if (queueNames[i].equals(queueQuery)) {
                                queueFound = true;
                                switch (Empty(queues[i])) {
                                    case 1 -> System.out.println("Queue " + queueQuery + " is EMPTY.");
                                    case 2 -> System.out.println("Queue " + queueQuery + " is FULL.");
                                    default -> System.out.println("Queue " + queueQuery + " is NEITHER EMPTY NOR FULL.");
                                }
                                break;
                            }
                        }

                        if (!queueFound)
                            System.out.println("Queue does not exist. Try again.");
                        else   
                            break;
                    }
                    break;
                case "6":
                    // return and display all elements of the queue

                    if (queues[0] == null) {
                        System.out.println("There are no queues in existence.");
                        break;
                    }

                    queueFound = false;
                    
                    while (true) {
                        System.out.print("Enter queue whose elements you want to display -> ");
                        try {
                            queueQuery = input.readLine();
                        } catch (IOException e) {
                            System.out.println("Input error!");
                            return;
                        }

                        for (int i = 0; i < totalQueues; i++) {
                            if (queueNames[i].equals(queueQuery) && Empty(queues[i]) != 1) {
                                queueFound = true;
                                if (queues[i].front + queues[i].count < queues[i].size) {
                                    for (int j = queues[i].front; j < queues[i].front + queues[i].count; j++) {
                                        System.out.println("Element at index " + j + ": " + queues[i].queue[j]);
                                    }
                                    break;
                                } else if (queues[i].front + queues[i].count >= queues[i].size) {
                                    for (int j = queues[i].front; j < queues[i].size; j++) {
                                        System.out.println("Element at index " + j + ": " + queues[i].queue[j]);
                                    }

                                    for (int j = 0; j < (queues[i].front + queues[i].count) % queues[i].size; j++) {
                                        System.out.println("Element at index " + j + ": " + queues[i].queue[j]);
                                    }
                                } else {
                                    System.out.println("Element at index " + i + ": " + queues[i].queue[queues[i].front]);
                                }
                            } else if (Empty(queues[i]) == 1) {
                                System.out.println("Queue is empty.");
                            }
                        }
                        
                        if (!queueFound)
                            System.out.println("Queue does not exist. Try again.");
                        else   
                            break;
        
                    }
                    break;
                case "7":
                    // exit simulator
                    System.out.println("You exited from the queue simulator.");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
