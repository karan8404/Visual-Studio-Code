//implementation of a doubly Linked List. Video #36.
package LinkedListImp;

public class LinkedList<T> {
    protected int size;
    protected Node<T> head;
    protected Node<T> tail;

    public LinkedList() {// default constructor
        size = 0;
        head = null;
        tail = null;
    }

    public int size() {// get size
        return size;
    }
    public Node<T> head(){//get head
        return head;
    }
    public Node<T> tail(){//get tail
        return tail;
    }

    public Node<T> get(int index) {// get a node at specified index;
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Invalid index for list size: " + size);
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (index == i)
                return current;
            current = current.next;
        }
        return null;
    }

    public T getData(Node<T> node){
        return node.data;
    }

    public void add(T data) {// adding a node to the end.
        Node<T> element = new Node<T>(data);
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
        Node<T> element = new Node<T>(data);
        if (index == size)
            add(data);
        else {
            if (index == 0) {
                element.next = head;
                head.prev = element;
                head = element;
            } else {
                Node<T> current = get(index);
                element.prev = current.prev;
                element.next = current;
                current.prev = element;
                element.prev.next = element;

            }
            size++;
        }
    }

    public void set(T data, int index) {// set the data of a node.
        Node<T> element = get(index);
        element.data = data;
    }

    public Node<T> remove(int index) {// remove a node.
        if(size==0)
            throw new IndexOutOfBoundsException();
        Node<T> n;
        if (index == 0) {
            n=head;
            head = head.next;
            head.prev = null;
        } else {
            Node<T> element = get(index - 1);
            n=element;
            element.next = element.next.next;
            element.next.prev = element;
        }
        size--;
        return n;
    }

    public Integer getIndex(Node<T> n){
        Node<T> current=head;
        int i=0;
        while(current!=null){
            if(current.equals(n))
                return i;
            current=current.next;
            i++;
        }
        return null;
    }

    @Override
    public String toString() {// to help print the linked list.
        StringBuilder res = new StringBuilder("[");
        Node<T> curr = head;
        while (curr != null) {
            res.append(curr + ",");
            curr = curr.next;
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    public static class Node<S> {// Node class
        S data;// current node data
        Node<S> next;// reference to next node
        Node<S> prev;// reference to previous node

        public Node(S data) {// def constructor
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
            if (!(obj instanceof Node<?>)) return false;
                Node<?> n = (Node<?>) obj;
            if(!(this.data==n.data))
                return false;
            return true; 
        }

    }
}