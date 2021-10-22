public class RecursiveLinkedList implements MyListInterface{
    private Node head;

    private static class Node{
        public int value;
        public Node next;
        public Node(int data) {
            value = data;
        }
    }
    @Override
    public void insert(int value) {
        if (head == null) {head = new Node(value);} //special case when list is empty
        else {
            insert(value, head);
        }
    }
    private Node insert(int value, Node root){
        if (root.next != null) {
            root = insert(value, root.next);
        }else {
            root.next = new Node(value);
        }
        return root;
    }
    @Override
    public void remove(int value) {
        remove(head, value);
    }
    private Node remove(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (node.value != key){
            node.next = remove(node.next, key);
        }
        else {
            return node.next;
        }
        return node;
    }
    @Override
    public void show(){
        if (head != null) {
            Node currentNode = head;
            while (currentNode != null) {
                System.out.println(currentNode.value);
                currentNode = currentNode.next;
            }
        }
    }
    @Override
    public int sum(){
        return sum(head);
    }

    private int sum(Node node) {
        if (node == null){
            return 0;
        }
        return node.value + sum(node.next);
    }
    //TODO delete this
    public void testPrint(){
        Node current = head;
        System.out.println(current.value);
        System.out.println(current.next.value);
        current.next = current.next.next;
        System.out.println(current.next.value);
    }
}
