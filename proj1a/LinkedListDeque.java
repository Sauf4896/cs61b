public class LinkedListDeque<T> {
    private class Node {
        public T item;
        public Node prev;
        public Node next;

        public Node(T i, Node p, Node n) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private Node head;
    private int size;

    public LinkedListDeque() {
        size = 0;
        head = new Node(null, null, null);
        head.prev = head;
        head.next = head;
    }

    public void addFirst(T item) {
        Node curr = new Node(item, head, head.next);
        head.next.prev = curr;
        head.next = curr;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T removeFirst() {
        if (isEmpty()) return null;
        T temp = head.next.item;
        head.next = head.next.next;
        head.next.prev = head;
        size--;
        return temp;
    }

    public void addLast(T item) {
        Node curr = new Node(item, head.prev, head);
        head.prev = curr;
        curr.prev.next = curr;
        size++;
    }

    public T removeLast() {
        if (isEmpty()) return null;
        T temp = head.prev.item;
        head.prev = head.prev.prev;
        head.prev.next = head;
        size--;
        return temp;
    }

    public T get(int index) {
        if (size <= index) return null;

        Node curr = head.next;
        for (int i=0; i<index; i++) {
            curr = curr.next;
        }
        return curr.item;
    }

    public void printDeque() {
        for (Node i = head.next; i != head; i = i.next) {
            if (i.next == head) {
                System.out.println(i.item);
                break;
            }
            System.out.print(i.item + " ");
        }
    }

    public T getRecursive(int index) {
        if (size <= index) return null;
        return getRecursive(head.next, index);
    }

    public T getRecursive(Node curr, int index) {
        if (index == 0) return curr.item;
        return getRecursive(curr.next, index - 1);
    }
}