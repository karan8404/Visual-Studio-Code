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

    /**
     * @return Size of the linked list
     */
    public int size() {// get size
        return size;
    }

    /**
     * @return Head of the linked list(first element)
     */
    public Node<T> head(){//get head
        return head;
    }

    /**
     * @return Tail of the linked list(last element)
     */
    public Node<T> tail(){//get tail
        return tail;
    }

    /**
     * Returns the Node at the specified index
     * @param index Index of the specified Node in LinkedList
     * @return Node at the specified index
     * @throws IndexOutOfBoundsException if specified index is invalid
     */
    public Node<T> get(int index) {
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

    /**
     * Adds data to the end of the LinkedList
     * @param data Data to be added 
     */
    public void add(T data) {
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

    /**
     * Adds data to any index in the linked list
     * @param data Data to be added
     * @param index Index at which data is to be added
     */
    public void add(T data, int index) {
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

    /**
     * Replaces data of the node at a specified index with provided data
     * @param data New(updated) data
     * @param index Index at which data is to be replaced
     */
    public void set(T data, int index) {
        Node<T> element = get(index);
        element.data = data;
    }

    /**
     * Removes a Node at the specified index
     * @param index Index at which node is to be removed
     * @return The removed node
     * @throws IndexOutOfBoundsException If the LinkedList is empty
     */
    public Node<T> remove(int index) {
        if(size==0){
            throw new IndexOutOfBoundsException("Index 0 out of bounds for size 0");
        }
        
        Node<T> element = get(index);
        Node<T> n=element;
        if(element==head && element==tail){//size==1
            head=null;
            tail=null;
        }
        else if(element==head){
            head=element.next;
            head.prev=null;
        }
        else if(element==tail){
            tail.prev=null;
            tail.next=null;
        }
        else{
            element.prev.next=element.next;
            element.next.prev=element.prev;
        }
        size--;
        return n;
    }

    /**
     * Gets the index of a given node in a LinkedList
     * @param n The node whose index is needed
     * @return Index of the given node
     */
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

        /**
         * Returns data of the invoking node
         * @return Data of the invoking node
         */
        public S data(){
            return this.data;
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