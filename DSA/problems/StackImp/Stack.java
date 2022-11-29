package StackImp;

import LinkedListImp.LinkedList;

public class Stack<T> {
    LinkedList<T> stack;//the linked list which acts as stack.

    public Stack(){
        stack=new LinkedList<>();
    }

    public void push(T data){//add data at the head of the linked list.
        stack.add(data,0);
    }

    public T pop(){//removes head node and returns the data stored in it.
        return stack.getData(stack.remove(0));
    }

    public T peek(){
        return stack.getData(stack.head());
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        if(stack.size()==0)
            return true;
        return false;
    }
}
