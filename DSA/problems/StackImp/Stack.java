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

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return (stack.size() == 0);
    }
}