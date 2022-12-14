package PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

import utils.Input;

class KthLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = Input.inputAlist(sc);
        int k = sc.nextInt();
        sc.close();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(list);

        while (k-- > 1) {// polling till kth element is at top.
            pq.poll();
        }
        System.out.println(pq.peek());
    }
}