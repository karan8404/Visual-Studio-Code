//implementing a stack using a linked list. Video #41
package StackImp;

import LinkedListImp.LinkedList;

public class Stack<T> {
    LinkedList<T> stack;// the linked list which acts as stack.

    public Stack() {
        stack = new LinkedList<>();
    }

    /**
     * Adds element to top of stack with given data
     * @param data Data to be added
     */
    public void push(T data) {
        stack.add(data);
    }

    /**
     * Removes element from the top of the stack
     * @return The data removed
     */
    public T pop() {
        return stack.remove(stack.size() - 1).data();
    }

    /**
     * Returns data of the element at the top of stack without removing it
     * @return Data of Element at top of stack
     */
    public T peek() {
        return stack.tail().data();
    }

    /**
     * @return Number of elements in the stack
     */
    public int size() {
        return stack.size();
    }

    /**
     * @return True if stack is empty, otherwise returns false
     */
    public boolean isEmpty() {
        return (size() == 0);
    }
}