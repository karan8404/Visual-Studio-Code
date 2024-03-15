package DequeImp;

public class MaxSlidingWindow {

    public static void printMax(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> deque = new Deque<>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < arr[i]) {

            }
        }
    }
}