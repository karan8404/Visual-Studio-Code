package LinkedList;

import java.util.Scanner;
//import sorts.Input;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Linkedlist<Integer> ll = new Linkedlist<>();
        // int[] arr=Input.toIntArray(Input.inputAlist(sc));
        int[] arr = { 1, 2, 3, 5, 7 };
        addAll(ll, arr);
        System.out.println(ll);// print original linked list.
        reverse(ll);
        System.out.println(ll);// print reversed linked list.
        sc.close();
    }

    public static void addAll(Linkedlist<Integer> ll, int[] arr) {// input for linked list.
        for (int num : arr) {
            ll.add(num);
        }
    }

    public static void reverse(Linkedlist<Integer> ll) {
        if (ll.size == 0 || ll.size == 1)
            return;
        Linkedlist<Integer>.Node current = ll.head;
        Linkedlist<Integer>.Node prevNode = null;
        Linkedlist<Integer>.Node nextNode;
        while (current != null) {
            nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
        }
        // swapping tail and head.
        ll.tail = ll.head;
        ll.head = prevNode;
    }
}