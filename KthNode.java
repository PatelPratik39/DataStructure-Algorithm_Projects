import java.util.LinkedList;

/**
 * Get the Kth node from end of a linked list. It counts from 1 here, so the 1st node from end is the tail of the list.
 * Time Complexity =>
 * Space Complexity =>
 */


public class KthNode {
    static class Node {
        int value;
        Node next;

        Node(int value){
            this.value = value;
            this.next = null;
        }
    }

    static class LinkedList{
        private Node head;

        public LinkedList(){
            this.head = null;
        }

        public void add ( int value ) {
            if(head == null){
                head = new Node(value);
            } else {
                Node currentNode = head;
                while (currentNode.next != null){
                    currentNode = currentNode.next;
                }
                currentNode.next = new Node(value);
            }
        }

        public Node getKthNode ( int k ) {
            if(head == null){
                return null;
            }
            Node slow = head;
            Node fast = head;

            for(int i = 0; i < k; i++){
                if(fast == null){
                    return null;
                }
                fast = fast.next;
            }
            while(fast != null){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }

    public static void main ( String[] args ) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int k = 3;
        Node kthNodeFromEnd = list.getKthNode(k);

        if (kthNodeFromEnd != null) {
            System.out.println("The " + k + "rd node from the end has value: " + kthNodeFromEnd.value);
        } else {
            System.out.println("The list is shorter than " + k + " nodes.");
        }

    }
}
