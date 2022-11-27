//implementation of a doubly Linked List. Video #36.
package LinkedList;

public class Linkedlist<T> {
    private int size;
    Node head;
    Node tail;

    public Linkedlist() {// default constructor
        size = 0;
        head = null;
        tail = null;
    }

    public int size() {// get size
        return size;
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
        if (size == 0) {
            head = element;
            tail = element;
        } else {
            tail.next = element;
            element.prev = tail;
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
                head.prev = element;
                head = element;
            } else {
                Node current = get(index);
                element.prev = current.prev;
                element.next = current;
                current.prev = element;
                element.prev.next = element;

            }
            size++;
        }
    }

    public void set(T data, int index) {// set the data of a node.
        Node element = get(index);
        element.data = data;
    }

    public void remove(int index) {// remove a node.
        if (index == 0) {
            head = head.next;
            head.prev = null;
        } else {
            Node element = get(index - 1);
            element.next = element.next.next;
            element.next.prev = element;
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
        Node prev;// reference to previous node

        public Node(T data) {// def constructor
            this.data = data;
            next = null;
            prev = null;
        }

        @Override // used to print the data of a node
        public String toString() {
            return data.toString();
        }

        @Override // to check equality of two nodes
        public boolean equals(Object obj) {
            if (this == obj)// checks if both have same reference
                return true;
            if (obj == null ||this==null || this.getClass() != obj.getClass())
                return false;
            //@SuppressWarnings("unchecked")//casting obj to node will give a warning no matter what.
            //Node n=((Node)obj);
            if (!(obj instanceof Linkedlist<?>.Node)) return false;
                Linkedlist<?>.Node n = (Linkedlist<?>.Node) obj;
            if(!(this.data==n.data))
                return false;
            return true; 
        }

    }
}