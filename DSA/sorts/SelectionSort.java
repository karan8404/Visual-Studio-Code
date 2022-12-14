package sorts;

import java.util.*;

import utils.Input;

class SelectionSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> a = Input.inputAlist(sc);
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