//implementing a stack using a linked list. Video #41
package StackImp;

import LinkedListImp.LinkedList;

public class Stack<T> {
    LinkedList<T> stack;// the linked list which acts as stack.

    public Stack() {
        stack = new LinkedList<>();
    }

    public void push(T data) {// add data at the tail of the linked list.
        stack.add(data);
    }

    public T pop() {// removes tail and returns the data stored in it.
        return stack.remove(stack.size() - 1).data();
    }

    public T peek() {// returns the tail of the stack.
        return stack.tail().data();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return (stack.size() == 0);
    }
}