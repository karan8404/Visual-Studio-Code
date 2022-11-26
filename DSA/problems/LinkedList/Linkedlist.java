package LinkedList;

public class Linkedlist<T> {
    int size;
    Node head;
    Node tail;

    public Linkedlist() {// default constructor
        size = 0;
        head = null;
        tail = null;
    }

    public Node get(int index) {// get a node at specified index;
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Invalid index for list size: " + size);
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (index == i)
                return current;
            current = current.next;
        }
        return null;
    }

    public void add(T data) {// adding a node to the end.
        Node element = new Node(data);
        element.next = null;
        if (size == 0) {
            head = element;
            tail = element;
        } else {
            tail.next = element;
            tail = element;
        }
        size++;
    }

    public void add(T data, int index) {// adding a node to required index
        Node element = new Node(data);
        if (index == size)
            add(data);
        else {
            if (index == 0) {
                element.next = head;
                head = element;
            } else {
                Node prev = get(index);
                element.next = prev.next;
                prev.next = element;
            }
            size++;
        }
    }

    public void set(T data, int index) {// set the data of a node.
        Node element = get(index);
        element.data = data;
    }

    public void remove(int index) {// remove a node.
        if (index == 0)
            head = head.next;
        else {
            Node element = get(index - 1);
            element.next = element.next.next;
        }
    }

    @Override
    public String toString() {// to help print the linked list.
        StringBuilder res = new StringBuilder("[");
        Node curr = head;
        while (curr != null) {
            res.append(curr + ",");
            curr = curr.next;
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    public class Node {// Node class
        T data;// current node data
        Node next;// reference to next node

        public Node(T data) {// def constructor
            this.data = data;
        }

        @Override // used to print the data of a node
        public String toString() {
            return data.toString();
        }

    }
}