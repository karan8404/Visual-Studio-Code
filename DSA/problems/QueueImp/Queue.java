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

    // addition to the rear end of the queue
    public void push(T data) {
        queue.add(data);
    }

    // removal from front of the queue
    public T pop() {
        return queue.remove(0).data();
    }

    //returns head.
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
