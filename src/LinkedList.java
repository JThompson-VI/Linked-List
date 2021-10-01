

public class LinkedList {
    Node head;
    Node current;

    public static void main(String[] args) {

//        LinkedList myList = new LinkedList();
//        insert(myList, 10);
//        show(myList);
//        insert(myList, 97);
//        show(myList);
//        insert(myList, 15);
//        show(myList);
//        insert(myList, 15);
//        show(myList);
        RecursiveLinkedList rList = new RecursiveLinkedList();
        rList.insert(10);
        rList.insert(12);
        rList.insert(1);
        rList.insert(15);
        rList.insert(2);
        rList.show();



    }
    private static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            value = data;
        }
    }

    public static void insert(LinkedList list, int data) {
        Node newNode = new Node(data);
        //newNode.next = null;
        if ( list.head == null) {
            list.head = newNode;
            list.current = newNode;
        }else {
            list.current.next = newNode;
            list.current = list.current.next;

        }
    }
    // identify the first node of the list
    // print the data of each node and stop when current node.next == null
    /*
    if head not null
    while node.next != null print node.value node == node.next
     */
    public static void show(LinkedList list) {
        if (list.head != null) {
            Node currentNode = list.head;
            while (currentNode != null) {
                System.out.println(currentNode.value);
                currentNode = currentNode.next;
            }
        }
        System.out.println("=============");
    }
}
