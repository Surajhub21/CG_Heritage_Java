public class SinglyLinkedListDemo {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        System.out.println("List after inserting 5 elements: " + list.traverse());
        list.delete(30);
        System.out.println("After deleting 30 (middle): " + list.traverse());
        list.delete(10);
        System.out.println("After deleting 10 (start): " + list.traverse());
        System.out.println("Search 40: " + list.search(40));
        System.out.println("Search 99: " + list.search(99));
    }

    static class SinglyLinkedList {
        private static class Node {
            int data;
            Node next;
            Node(int d) { data = d; }
        }

        private Node head;

        public void insertAtBeginning(int data) {
            Node n = new Node(data);
            n.next = head;
            head = n;
        }

        public void insertAtEnd(int data) {
            Node n = new Node(data);
            if (head == null) { head = n; return; }
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = n;
        }

        public void insertAtPosition(int pos, int data) {
            if (pos <= 0) { insertAtBeginning(data); return; }
            Node cur = head;
            int idx = 0;
            while (cur != null && idx < pos - 1) { cur = cur.next; idx++; }
            Node n = new Node(data);
            if (cur == null) { insertAtEnd(data); return; }
            n.next = cur.next;
            cur.next = n;
        }

        public void delete(int data) {
            if (head == null) return;
            if (head.data == data) { head = head.next; return; }
            Node cur = head;
            while (cur.next != null && cur.next.data != data) cur = cur.next;
            if (cur.next != null) cur.next = cur.next.next;
        }

        public boolean search(int data) {
            Node cur = head;
            while (cur != null) {
                if (cur.data == data) return true;
                cur = cur.next;
            }
            return false;
        }

        public String traverse() {
            StringBuilder sb = new StringBuilder();
            Node cur = head;
            while (cur != null) {
                if (sb.length() > 0) sb.append(" -> ");
                sb.append(cur.data);
                cur = cur.next;
            }
            return sb.toString();
        }
    }

}

