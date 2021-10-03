import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LinkedList implements MyListInterface{
    Node head;
    Node current;

    public static void main(String[] args) throws IOException {

        MyListInterface list = new LinkedList();

        String inputFile = "inputFile.txt";

        File file = new File(inputFile);
        Scanner input = new Scanner(file);

        String operation;
        int value;
        while (input.hasNext()) {
            Scanner nextLine = new Scanner(input.nextLine());
            operation = nextLine.next();
            value = nextLine.nextInt();

            if (operation.equals("insert")) {
                list.insert(value);
            }
        }
        System.out.println("The complete Linked list is: ");
        list.show();

        input.close();
    }
    private static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            value = data;
        }
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        //newNode.next = null;
        if (head == null) {
            head = newNode;
            current = newNode;
        }else {
            current.next = newNode;
            current = current.next;

        }
    }
    // identify the first node of the list
    // print the data of each node and stop when current node.next == null
    /*
    if head not null
    while node.next != null print node.value node == node.next
     */
    public void show() {
        if (head != null) {
            Node currentNode = head;
            while (currentNode != null) {
                System.out.println(currentNode.value);
                currentNode = currentNode.next;
            }
        }
        System.out.println("=============");
    }
}
