package LinkedList;

public class utils {

    public static void addAll(Linkedlist<Integer> ll, int[] arr) {// input for linked list.
        for (int num : arr) {
            ll.add(num);
        }
    }

    public static void reverse(Linkedlist<Integer> ll) {
        if (ll.size() == 0 || ll.size() == 1)
            return;
        Linkedlist<Integer>.Node current = ll.head;
        Linkedlist<Integer>.Node nextNode;
        while (current != null) {
            nextNode=current.next;
            current.next=current.prev;
            current.prev=nextNode;
            current=nextNode;
        }
        // swapping tail and head.
        current=ll.head;
        ll.head=ll.tail;
        ll.tail=current;
    }
}