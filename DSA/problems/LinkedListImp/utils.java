package LinkedListImp;

import LinkedListImp.LinkedList.Node;

public class utils  {

    public static <T> void addAll(LinkedList<T> ll, T[] arr) {// input for linked list.
        for (T item : arr) {
            ll.add(item);
        }
    }

    public static <T> void reverse(LinkedList<T> ll) {// reversing linked list.Video #37
        if (ll.size() == 0 || ll.size() == 1)
            return;
        Node<T> current = ll.head;
        Node<T> nextNode;
        while (current != null) {
            nextNode = current.next;
            current.next = current.prev;
            current.prev = nextNode;
            current = nextNode;
        }
        // swapping tail and head.
        current = ll.head;
        ll.head = ll.tail;
        ll.tail = current;
    }

    public static <T> boolean palindrome(LinkedList<T> ll){//checking if linked list is palindrome.Video #38
        Node<T> headNode=ll.head;
        Node<T> tailNode=ll.tail;
        while(headNode!=tailNode && tailNode.next!=headNode){//checking for each half of the list
            if(!(headNode.equals(tailNode)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        Integer[] arr = { 1, 2, 3, 5, 7 };

        addAll(ll, arr);
        System.out.println(ll);
        reverse(ll);
        System.out.println(ll);
    }
}