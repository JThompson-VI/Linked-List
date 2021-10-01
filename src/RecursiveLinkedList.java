public class RecursiveLinkedList {
    private Node head;
    private static class Node{
        public int value;
        public Node next;
        public Node(int data) {
            value = data;
        }
    }
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
    public void remove(int value) {

    }

    public void show(){
        if (head != null) {
            Node currentNode = head;
            while (currentNode != null) {
                System.out.println(currentNode.value);
                currentNode = currentNode.next;
            }
        }
    }


}