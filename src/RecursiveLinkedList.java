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
        return sum(this.head);
    }
    private int sum(Node node) {
        if (node == null){
            return 0;
        }
        return node.value + sum(node.next);
    }
}
