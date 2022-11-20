import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

import sorts.Input;

class KthLargest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> list = Input.input(sc);
        int k =sc.nextInt();
        sc.close();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer num : list)
            pq.add(num);

        while (k --> 1) {
            pq.poll();
        }
        System.out.println(pq.peek());
    }
}