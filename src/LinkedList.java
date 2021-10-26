import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LinkedList implements MyListInterface{
    Node head;

    public static void main(String[] args) throws IOException {

        MyListInterface list = new RecursiveLinkedList();

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

    // has a O(n) but does what the user might expect from an insert method
    public void add(int data) {
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
    // inserts the new element at the beginning of the list and has a O(1)
    public void insert(int key) {
        if (head == null) {
            head = new Node(key);
            return;
        }
        Node newNode = new Node(key);
        newNode.next = head;
        head = newNode;
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
