//implementing a stack using a linked list. Video #41
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

    public T pop(){//removes top and returns the data stored in it.
        return stack.remove(0).data();
    }

    public T peek(){// returns the top of the stack.
        return stack.head().data();
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