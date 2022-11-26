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
        //checking for next and prev elements.
        Linkedlist<Integer>.Node current=ll.head;
        while(current!=null){
            System.out.print(current+",");
            current=current.next;
        }
        current=ll.tail;
        System.out.println();
        while(current!=null){
            System.out.print(current+",");
            current=current.prev;
        }
    }

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