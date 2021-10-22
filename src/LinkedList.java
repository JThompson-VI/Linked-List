import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LinkedList implements MyListInterface{
    Node head;

    public static void main(String[] args) throws IOException {

        MyListInterface list = new LinkedList();
        //TODO remove next line and uncomment the fist
        //RecursiveLinkedList list = new RecursiveLinkedList();
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
            else if (operation.equals("remove")) {
                list.remove(value);
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

    @Override
    public void insert(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = new Node(data);

    }

    @Override
    public void remove(int x) {
        if (head == null) {
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.value == x){
                currentNode.next = currentNode.next.next;
                return;
            }else {
                currentNode = currentNode.next;
            }
        }
    }

    // identify the first node of the list
    // print the data of each node and stop when current node.next == null
    /*
    if head not null
    while node.next != null print node.value node == node.next
     */
    @Override
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
    @Override
    public int sum() {
        int sum = 0;
        Node currentNode = this.head;
        while(currentNode != null) {
            sum += currentNode.value;
            currentNode = currentNode.next;
        }
        return sum;
    }

}
