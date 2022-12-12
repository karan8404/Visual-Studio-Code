//implements Queue data structure using linked list.
package QueueImp;

import LinkedListImp.LinkedList;
//import LinkedListImp.LinkedList.Node;

//adds to rear and removes from front
public class Queue<T> {
    LinkedList<T> queue;// the linkedlist which acts as a queue.

    // default constructor
    public Queue() {
        queue = new LinkedList<>();
    }

    /**
     * Adds element to the rear end of the queue.
     * @param data data to be pushed into the queue
     */
    public void push(T data) {
        queue.add(data);
    }

    /**
     * Removes element from rear end of the queue
     * @return Data of the element removed
     */
    public T pop() {
        return queue.remove(0).data();
    }

    /**
     * Returns data of the element at rear end of queue without removing it
     * @return Data of the element at rear of queue
     */
    public T peek() {
        return queue.head().data() ;
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return (queue.size() == 0);
    }
}
