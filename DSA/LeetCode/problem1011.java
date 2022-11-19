//Allocate minimum number of books to each student/lowest weight limit for each ship.
public class problem1011 {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int max = 0;
        int min = 0;

        for (int i = 0; i < n; i++) {
            max += weights[i];
            if (weights[i] > min)
                min = weights[i];
        }

        int res = Integer.MAX_VALUE;
        int mid;
        while (min <= max) {
            mid = (min + max) / 2;

            if (isFeasible(weights, days, mid)) {
                if (mid < res)
                    res = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return res;
    }

    static boolean isFeasible(int[] a, int k, int res) {
        int student = 1;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (sum + a[i] > res) {
                student++;
                sum = a[i];
            } else {
                sum += a[i];
            }
        }

        return student <= k;
    }
}
