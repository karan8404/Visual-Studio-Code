public class Josephus {// To solve the josephus problem.
    // video number #9

    static int jos(int n, int k) {
        if (n == 1)
            return 0;
        return (jos(n - 1, k) + k) % n;
    }
}
