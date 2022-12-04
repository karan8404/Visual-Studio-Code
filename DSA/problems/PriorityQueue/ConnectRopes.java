package PriorityQueue;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

import utils.Input;

//Find the minimum cost of connecting ropes. Video #34
class ConnectRopes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = Input.inputAlist(sc);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(list);

        int sum = 0;
        int temp;
        while (pq.size() > 1) {
            temp = pq.poll() + pq.poll();
            sum += temp;
            pq.add(temp);
        }
        System.out.println(sum);
    }
}