package DequeImp;

import LinkedListImp.LinkedList;

//implementing a Deque(Doubly ended Queue) using linked list
public class Deque<T> {
    LinkedList<T> deque;

    // default constructor
    public Deque() {
        deque = new LinkedList<>();
    }

    /**
     * Adds element at front with given data
     * @param data data to be added
     */
    public void addFirst(T data){
        deque.add(data,0);
    }

    /**
     * Adds element at end with given data
     * @param data data to be added
     */
    public void addLast(T data){
        deque.add(data);
    }

    /**
     * Returns data of element at front without removing it
     * @return Data of element at front
     */
    public T peekFirst(){
        return deque.head().data();
    }

    /**
     * Returns data of element at end without removing it
     * @return Data of element at end
     */
    public T peekLast(){
        return deque.tail().data();
    }

    /**
     * Removes element at front and returns its data
     * @return Data of element removed
     */
    public T removeFirst(){
        return deque.remove(0).data();
    }

    /**
     * Removes element at end and returns its data
     * @return Data of element removed
     */
    public T removeLast(){
        return deque.remove(size()-1).data();
    }

    /**
     * Returns size of the Deque
     * @return Size of the Deque
     */
    public int size(){
        return deque.size();
    }

    public boolean isEmpty(){
        return (size()==0);
    }
}
