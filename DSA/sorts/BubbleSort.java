package sorts;

import java.util.*;

class BubbleSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> a = Input.inputAlist(sc);
        // bubble sort algorithm
        int n = a.size();
        int current;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                current = a.get(j);
                if (current > a.get(j + 1)) {// swapping
                    a.set(j, a.get(j + 1));
                    a.set(j + 1, current);
                }
            }
        }
        // printing elements.
        for (Integer num : a) {
            System.out.print(num + " ");
        }
    }
}