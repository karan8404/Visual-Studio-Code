//Detecting a cycle in a linked list using Floyd's cycle algorithm. Video #39
package LinkedListImp;

import LinkedListImp.LinkedList.Node;

public class FloydsCycle {
    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, 5, 7 };
        LinkedList<Integer> ll = new LinkedList<>();
        utils.addAll(ll, arr);
        System.out.println(ll);
        ll.tail.next = ll.get(3);

        System.out.println(detectCycle(ll));
    }

    public static <T> boolean detectCycle(LinkedList<T> ll) {

        Node<T> slow = ll.head;
        Node<T> fast = ll.head;
        slow = slow.next;
        fast = fast.next.next;

        while (fast != null && fast.next != null) {
            if (slow.equals(fast)) {
                getCycleStart(ll, fast);
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static <T> void getCycleStart(LinkedList<T> ll, Node<T> n) {
        Node<T> current = ll.head.next;
        while (n.next != current) {
            n = n.next;
            current = current.next;
        }
        n.next=null;
        System.out.println("Cycle present at:"+ll.getIndex(current));
    }
}
