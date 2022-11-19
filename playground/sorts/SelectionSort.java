package playground.sorts;

import java.util.*;

class SelectionSort {
    public static void main(String args[]) {
        ArrayList<Integer> a = Input.input();
        // Selection sort algorithm
        int n = a.size();
        int min;
        int minNum;

        for (int i = 0; i < n - 1; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (a.get(j) < a.get(min))
                    min = j;
            }
            minNum = a.get(min);
            a.set(min, a.get(i));
            a.set(i, minNum);
        }

        // printing elements.
        for (Integer num : a) {
            System.out.print(num + " ");
        }
    }
}