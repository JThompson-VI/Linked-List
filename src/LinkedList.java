public class LinkedList {
    Node head;

    public static void main(String[] args) {

        LinkedList myList = new LinkedList();
        insert(myList, 10);
        show(myList);
        insert(myList, 15);
        show(myList);
        insert(myList, 97);
        show(myList);

    }
    private static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }

    public static void insert(LinkedList list, int data) {
        Node newNode = new Node(data);
        //newNode.next = null;
        if ( list.head == null) {
            list.head = newNode;
        }else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
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
