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
    public void enqueue(T data) {
        queue.add(data);
    }

    // removal from front of the queue
    public T dequeue() {
        return queue.remove(0).data();
    }

    public T front() {
        return queue.head().data() ;
    }

    public T rear() {
        return queue.tail().data();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return (queue.size() == 0);
    }
}
