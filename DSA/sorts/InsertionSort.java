package sorts;

import java.util.*;

import utils.Input;

class InsertionSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> a = Input.inputAlist(sc);
        // Insertion sort algorithm
        int n = a.size();
        int current;

        for (int i = 1; i < n; i++) {
            current = a.get(i);
            int j = i - 1;

            while (j >= 0 && a.get(j) > current) {
                a.set(j + 1, a.get(j));
                j--;
            }
            a.set(j + 1, current);
        }
        // printing elements.
        for (Integer num : a) {
            System.out.print(num + " ");
        }
    }
}